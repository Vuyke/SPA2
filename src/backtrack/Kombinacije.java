package backtrack;

import util.Osobe;
import util.Util;

public class Kombinacije {
	private Osobe[] osobe;
	private int[] indeksi;
	public Kombinacije(Osobe[] osobe, int k) {
		this.osobe = osobe;
		indeksi = new int[k];
	}
	
	private void print() {
		System.out.print("{");
		for (int x : indeksi) 
			System.out.print(osobe[x] + " ");
		System.out.println("} ");
	}
	
	public void find() {
		find(0);
	}
	
	private void find(int cur) {
		if(cur == indeksi.length) {
			print();
			return;
		}
		int prev = cur - 1 >= 0 ? indeksi[cur - 1] + 1 : 0;
		int remain = indeksi.length - cur;
		for(int i = prev; i < osobe.length - remain + 1; i++) {
			indeksi[cur] = i;
			find(cur + 1);
		}
	}
	
	public void findVarijacije() {
		findVarijacije(0);
	}
	
	private void findVarijacije(int cur) {
		if(cur == indeksi.length) {
			print();
			return;
		}
		for(int i = 0; i < osobe.length; i++) {
			indeksi[cur] = i;
			findVarijacije(cur + 1);
		}
	}
	
	public static void main(String args[]) {
		Kombinacije K = new Kombinacije(Util.osobe2, 2);
		//K.find();
		K.findVarijacije();
	}
}
