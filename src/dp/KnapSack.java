package dp;

import util.Item;
import util.Util;

public class KnapSack {
	private Item[] items;
	private int[][] mat;
	private int capacity;
	public KnapSack(Item[] items, int capacity) {
		this.items = items;
		this.capacity = capacity;
		mat = new int[items.length + 1][capacity + 1];
	}
	
	private void createMat() {
		for(int i = 1; i <= items.length; i++) {
			Item cur = items[i - 1];
			for(int j = 1; j <= capacity; j++) {
				mat[i][j] = mat[i - 1][j];
				if(j - cur.getTezina() >= 0) {
					mat[i][j] = Math.max(mat[i][j], mat[i - 1][j - cur.getTezina()] + cur.getCena());
				}
			}
		}
	}
	
	public void print() {
		createMat();
		int i = items.length, j = capacity;
		while(i != 0 && j != 0) {
			i--;
			if(mat[i + 1][j] == mat[i][j]) {
				continue;
			}
			System.out.println(items[i]);
			j -= items[i].getTezina();
		}
	}
	
	public static void main(String args[]) {
		KnapSack K = new KnapSack(Util.items, 20);
		K.print();
	}
}
