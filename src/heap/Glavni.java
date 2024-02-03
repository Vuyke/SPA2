package heap;
import elementarnoSortiranje.Osobe;
import util.Util;

public class Glavni {
	public static void main(String args[]) {
		PriorityQueue<Osobe> PQ = new HeapPQ<Osobe>();
		Osobe[] osobe = Util.osobe;
		for(Osobe osoba : osobe) {
			PQ.add(osoba);
		}
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
		PQ.deleteMax();
		System.out.println(PQ.max());
	}
}
