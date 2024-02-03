package elementarnoSortiranje;

import util.Util;

public class Glavni {
	public static void main(String args[]) {
		Osobe[] osobe = Util.osobe;
		Sortiranje.ispis(osobe);
		Sortiranje.comb(osobe, Osobe::compare);
		Sortiranje.ispis(osobe);
	}
}
