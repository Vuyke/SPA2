package heap;
import util.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		PriorityQueue<Osobe> PQ = new HeapPQ<Osobe>();
		Osobe[] osobe = Util.osobe;
		for(Osobe osoba : osobe) {
			PQ.add(osoba);
		}//tesitranje svih funkcija
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
		PQ.add(new Osobe(100, "Sofija"));
		System.out.println(PQ.deleteMax());
	}
}
