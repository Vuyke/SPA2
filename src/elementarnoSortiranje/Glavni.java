package elementarnoSortiranje;

import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		Osobe[] osobe = Util.osobe;
		Util.ispis(osobe);
		Sortiranje.comb(osobe, Osobe::compare); //ovde testirajte sve sortove imenom
		//Osobe::compare i Osobe::compare2 se moze koristiti svuda gde je argument Comparator c
		//Vise o tome ima na OOP2 kod JavaFX na kraju teorijske prezentacije(funkcionalno programiranje)
		Util.ispis(osobe);
	}
}
