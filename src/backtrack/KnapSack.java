package backtrack;

import util.Util;

public class KnapSack {
	private Item[] items;
	private boolean in[];
	private boolean best[];
	private int bestProfit = 0;
	private int capacity;
	
	public KnapSack(Item[] items, int capacity) {
		if (items == null)
			throw new IllegalArgumentException("No array found");
		this.items = items;
		in = new boolean[items.length];
		best = new boolean[items.length];
		this.capacity = capacity;
	}
	
	public void change(int curProfit) {
		int n = items.length;
		for(int i = 0; i < n; i++) {
			best[i] = in[i];
		}
		bestProfit = curProfit;
	}
	
	public void find() {
		find(0, 0, 0);
	}
	
	public void print() {
		for(int i = 0; i < items.length; i++) {
			if(best[i]) {
				System.out.print(items[i] + ", ");
			}
		}
		System.out.println();
	}
	
	public void find(int k, int sum, int curProfit) {
		if(k == items.length) {
			if(curProfit > bestProfit) {
				change(curProfit);
			}
			return;
		}
		if(sum + items[k].getTezina() <= capacity) {
			in[k] = true;
			find(k + 1, sum + items[k].getTezina(), curProfit + items[k].getCena());
		}
		in[k] = false;
		find(k + 1, sum, curProfit);
	}
	
	public static void main(String args[]) {
		KnapSack K = new KnapSack(Util.items, 20);
		K.find();
		K.print();
	}
}