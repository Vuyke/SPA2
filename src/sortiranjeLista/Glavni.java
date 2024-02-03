package sortiranjeLista;

import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		SortableList<Osobe> list = new SortableList<Osobe>();
		Osobe[] osobe = Util.osobe;
		for(Osobe osoba : osobe) {
			list.add(osoba);
		}
		list.ispis();
		list.mergeSort();
		list.ispis();
	}
}
