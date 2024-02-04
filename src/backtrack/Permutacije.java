package backtrack;

import util.Osobe;
import util.Util;

public class Permutacije {
	private Osobe[] osobe;
	public Permutacije(Osobe[] osobe) {
		this.osobe = osobe;
	}
	public void print() {
		System.out.print("{");
		for(int i = 0; i < osobe.length; i++) {
			System.out.print(osobe[i] + " ");
		}
		System.out.println("}");
	}
	
	public void find() {
		find(0);
	}

	private void find(int cur) {
		if(cur == osobe.length) {
			print();
			return;
		}
		for(int i = cur; i < osobe.length; i++) {
			swap(i, cur);
			find(cur + 1);
			swap(i, cur);
		}
	}
	
	public static void main(String args[]) {
		Permutacije p = new Permutacije(Util.osobe2);
		p.find();
	}
	
	private void swap(int ind1, int ind2) {
		Osobe tmp = osobe[ind1];
		osobe[ind1] = osobe[ind2];
		osobe[ind2] = tmp;
	}
}
