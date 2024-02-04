package backtrack;

public class Kraljice {
	private int[] table;
	private int[] C, D;
	public int num = 0;
	public Kraljice(int n) {
		table = new int[n];
		C = new int[n];
		D = new int[n];
	}
	
	public void print() {
		num++;
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table.length; j++) {
				if(table[i] == j) {
					System.out.print("X ");
				}
				else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean check(int k) {
		int cur = D[k];
		for(int i = 0; i < k; i++) {
			if(table[i] == cur || Math.abs(table[i] - cur) == Math.abs(i - k))
				return false;
		}
		return true;
	}
		
	public void prviSledeci(int k) {
		while(!check(k) && D[k] < table.length)
			D[k]++;
	}
		
	public void find() {
		int k = 0;
		int n = table.length;
		D[0] = 0;
		while(k >= 0) {
			while(D[k] < n) {
				table[k] = D[k];
				D[k]++;
				prviSledeci(k);
				if(k == n - 1) {
					//print();
					num++;
					continue;
				}
				k++;
				D[k] = 0;
				prviSledeci(k);
			}
			k--;
		}
	}
	
	public static void main(String args[]) {
		Kraljice K = new Kraljice(8);
		K.find();
		System.out.println(K.num);
	}
}
