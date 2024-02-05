package string;

import java.util.HashMap;

public class KMP {
	private String text;
	private String pattern;
	
	public KMP(String text, String pattern) {
		if (text.length() < pattern.length())
			throw new IllegalArgumentException("Patern manji od teksta?");
		this.text = text;
		this.pattern = pattern;
	}
	
	public int find() {//moja metoda(podrazumeva da ? ne postoji ni u jednom stringu)
		String searchString = pattern + "?" + text;
		int sz = pattern.length();
		int[] K = new int[searchString.length()];
		for(int i = 1; i < searchString.length(); i++) {
			int pos = K[i - 1];
			while(pos != 0 && searchString.charAt(pos) != searchString.charAt(i)) 
				pos = K[pos - 1];
			if(searchString.charAt(pos) == searchString.charAt(i)) {
				K[i] = pos + 1;
			}
			else {
				K[i] = 0;
			}
			if(K[i] == sz) {
				return i - 2 * pattern.length();
			}
		}
		return -1;
	}
	
	private int[] createMat() {
		int[] K = new int[pattern.length()];
		for(int i = 1; i < pattern.length(); i++) {
			int pos = K[i - 1];
			while(pos != 0 && pattern.charAt(pos) != pattern.charAt(i)) 
				pos = K[pos - 1];
			if(pattern.charAt(pos) == pattern.charAt(i)) {
				K[i] = pos + 1;
			}
			else {
				K[i] = 0;
			}
		}
		return K;
	}
	
	public int find2() { //metoda sa slajdova
		int[] K = createMat();
		int cur = 0;
		for(int i = 0; i < text.length(); i++) {
			while(cur != 0 && pattern.charAt(cur) != text.charAt(i))
				cur = K[cur - 1];
			if(pattern.charAt(cur) == text.charAt(i)) {
				cur++;
			}
			if(cur == pattern.length()) {
				return i - pattern.length() + 1;
			}
		}
		return -1;
	}
	
	private HashMap<Character, Integer> createMap() {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = pattern.length() - 1; i >= 0; i--) {
			if(!map.containsKey(pattern.charAt(i))) {
				map.put(pattern.charAt(i), i);
			}
		}
		return map;
	}
	
	private boolean check(int ind) {
		for(int i = ind; i < ind + pattern.length(); i++) {
			if(text.charAt(i) != pattern.charAt(i - ind))
				return false;
		}
		return true;
	}
	
	public int findQuick() {
		HashMap<Character, Integer> last = createMap();
		for(int i = 0; i <= text.length() - pattern.length();) {
			if(check(i)) {
				return i;
			}
			char c = text.charAt(i + pattern.length());
			int oduzmi = last.containsKey(c) ? last.get(c) : -1;
			i += pattern.length() - oduzmi;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		KMP k = new KMP("ana voli milovana", "a v");
		System.out.println(k.findQuick());
	}
}
