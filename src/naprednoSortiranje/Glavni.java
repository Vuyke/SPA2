package naprednoSortiranje;

import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		Osobe[] osobe = Util.osobe;
		Util.ispis(osobe);
		SortiranjeNap.heapSort(osobe, Osobe::compare2);//ovde sam radi jednostavnosti samo sa prirodnim uredjenjem
		Util.ispis(osobe);
	}
}
