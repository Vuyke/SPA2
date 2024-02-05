package map;

import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		OHashMap<Integer, Osobe> mapa = new OHashMap<Integer, Osobe>(15);
		Osobe[] osobe = Util.osobe;
		int i = 2;
		for (Osobe osoba : osobe) {
			mapa.add(i, osoba);
			i *= 2;
		}
		mapa.print();
		// System.out.println(mapa.remove(16));
		// mapa.print();
		mapa.modify(16, new Osobe(5, "Mirjana"));
		mapa.get(16);
		mapa.print();
	}
}