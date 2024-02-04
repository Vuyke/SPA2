package set;

import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		CHashSet<Osobe> set = new CHashSet<Osobe>(4);
		Osobe[] osobe = Util.osobe;
		for(Osobe osoba : osobe) {
			if(set.add(osoba)) {
				System.out.println("POG!");
			}
		}
		set.print();
		Osobe test = new Osobe(12, "Jovan");
		if(set.contains(test)) {
			System.out.println("Ima!!!");
		}
		if(set.remove(test)) {
			System.out.println("Obrisan!!");
		}
		set.print();
	}
}
