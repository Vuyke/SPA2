package dp;

import java.util.Stack;

public class StringEdit {
	private String text;
	private String pattern;
	private int[][] mat;
	public StringEdit(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		mat = new int[text.length() + 1][pattern.length() + 1];
	}
	
	private void createMat() {
		for(int i = 0; i < text.length(); i++) {
			mat[i][0] = i;
		}
		for(int i = 0; i < pattern.length(); i++) {
			mat[0][i] = i;
		}
		for(int i = 1; i <= text.length(); i++) {
			for(int j = 1; j <= pattern.length(); j++) {
				mat[i][j] = mat[i - 1][j - 1] + 1;
				if(text.charAt(i - 1) == pattern.charAt(j - 1)) {
					mat[i][j]--;
					continue;
				}
				mat[i][j] = Math.min(mat[i - 1][j] + 1, mat[i][j]);
				mat[i][j] = Math.min(mat[i][j], 1 + mat[i][j - 1]);
			}
		}
	}
	
	public void find() {
		createMat();
		Stack<String> messages = new Stack<String>();
		int i = text.length(), j = pattern.length();
		while(i != 0 && j != 0) {
			if(text.charAt(i - 1) == pattern.charAt(j - 1)) {
				i--;
				j--;
				continue;
			}
			if(mat[i][j] == mat[i - 1][j - 1] + 1) {
				messages.add("Promenjen " + text.charAt(i - 1) + " u " + pattern.charAt(j - 1));
				i--;
				j--;
			}
			else if (mat[i][j] == mat[i - 1][j] + 1) {
				messages.add("Obisan " + text.charAt(i - 1));
				i--;
			}
			else {
				messages.add("Dodat " + pattern.charAt(j - 1));
				j--;
			}
		}
		while(!messages.isEmpty())
			System.out.println(messages.pop());
	}
	
	public static void main(String args[]) {
		StringEdit s = new StringEdit("Anki", "Ana");
		s.find();
	}
}
