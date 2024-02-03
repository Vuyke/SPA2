package naprednoSortiranje;

import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		Osobe[] osobe = Util.osobe;
		Util.ispis(osobe);
		SortiranjeNap.heapSortFake(osobe, Osobe::compare);
		Util.ispis(osobe);
	}
}
