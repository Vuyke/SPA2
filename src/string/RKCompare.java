package string;

public class RKCompare {
	private static final int MOD = 15485863;
	private String text;
	private String pattern;
	private int textH;
	private int patH;
	private int stepen;

	public RKCompare(String text, String pattern) {
		if (text.length() < pattern.length())
			throw new IllegalArgumentException("Patern manji od teksta?");
		this.text = text;
		this.pattern = pattern;
		patH = hash(pattern, pattern.length());
		textH = hash(text, pattern.length());
		stepen = 1;
		for(int i = 1; i < pattern.length(); i++) {
			stepen = (stepen * 31) % MOD;
		}
	}

	private int hash(String s, int len) {
		int cur = 0;
		for (int i = 0; i < len; i++) {
			cur = (cur * 31) % MOD + s.charAt(i);
			cur %= MOD;
		}
		return cur;
	}
	
	private boolean check(int ind) {
		for(int i = ind; i < ind + pattern.length(); i++) {
			if(text.charAt(i) != pattern.charAt(i - ind))
				return false;
		}
		return true;
	}
	
	private void updateHash(int ind) {
		if(ind == text.length())
			return;
		textH = (MOD + textH - (stepen * text.charAt(ind - pattern.length())) % MOD) % MOD;
		textH = ((textH * 31) % MOD + text.charAt(ind)) % MOD;
	}
	
	public int find() {
		for(int i = 0; i <= text.length() - pattern.length(); i++) {
			if(textH == patH) {//bez ove dve linije je brute force!!!
				if(check(i)) {
					return i;
				}
			}
			updateHash(i + pattern.length());//i ove!!!
		}
		return -1;
	}
	
	public static void main(String args[]) {
		RKCompare r = new RKCompare("ana voli milovana", "van");
		System.out.println(r.find());
	}
}
