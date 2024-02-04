package backtrack;

import util.Osobe;
import util.Util;

public class Skupovi {
	private Osobe[] osobe;
	private boolean[] in;

	public Skupovi(Osobe[] osobe) {
		this.osobe = osobe;
		in = new boolean[osobe.length];
	}

	private void print() {
		boolean empty = true;
		System.out.print("{");
		for (int i = 0; i < osobe.length; i++) {
			if (in[i]) {
				empty = false;
				System.out.print(osobe[i] + " ");
			}
		}
		if (empty)
			System.out.print("Empty set");
		System.out.println("} ");
	}
	
	public void find() {
		find(0);
	}
	
	private void find(int i) {
		if(i == osobe.length) {
			print();
			return;
		}
		in[i] = true;
		find(i + 1);
		in[i] = false;
		find(i + 1);
	}
	
	public static void main(String args[]) {
		Skupovi skup = new Skupovi(Util.osobe2);
		skup.find();
	}
}
