package naprednoSortiranje;

import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		Osobe[] osobe = Util.osobe;
		Util.ispis(osobe);
		SortiranjeNap.quickSort(osobe, Osobe::compare);// ovde sam radi jednostavnosti samo sa prirodnim uredjenjem
		Util.ispis(osobe);
		int niz[] = { 8, 7, 6, 4, 4, 5, 1, 1, 5, 2, 9 };
		SortiranjeNap.countSort(niz);
		for (int x : niz) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
