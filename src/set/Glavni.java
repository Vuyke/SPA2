package set;

import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		OHashSet<Osobe> set = new OHashSet<Osobe>(15);
		Osobe[] osobe = Util.osobe;
		for(Osobe osoba : osobe)
			set.add(osoba);
		set.print();
		Osobe test = new Osobe(12, "Jovan");
		if(set.contains(test)) {
			System.out.println("Ima!!!");
		}
	}
}
