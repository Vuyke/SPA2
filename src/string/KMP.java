package string;

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
	
	private int[] createLast() {
		int[] last = new int[256];
		for(int i = 0; i < last.length; i++)
			last[i] = -1;
		for(int i = pattern.length() - 1; i >= 0; i--) {
			if(last[pattern.charAt(i)] == -1) {
				last[pattern.charAt(i)] = i;
			}
		}
		return last;
	}
	
	private boolean check(int ind) {
		for(int i = ind; i < ind + pattern.length(); i++) {
			if(text.charAt(i) != pattern.charAt(i - ind))
				return false;
		}
		return true;
	}
	
	public int findQuick() {
		int[] last = createLast();
		for(int i = 0; i <= text.length() - pattern.length();) {
			if(check(i)) {
				return i;
			}
			char c = text.charAt(i + pattern.length());
			i += pattern.length() - last[c];
		}
		return -1;
	}
	
	public static void main(String args[]) {
		KMP k = new KMP("ana voli milovana", "van");
		System.out.println(k.findQuick());
	}
}
