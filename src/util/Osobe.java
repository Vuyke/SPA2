package util;

public class Osobe implements Comparable<Osobe> { ///Klasa za elemente liste
	private int godine;
	private String ime;

	public Osobe(int godine, String ime) {
		this.ime = ime;
		this.godine = godine;
	}

	public int getGodine() {
		return godine;
	}

	public String getIme() {
		return ime;
	}

	public static int compare(Osobe o1, Osobe o2) { //comparovi za Comparator interfejs
		if(o1.godine == o2.godine)
			return o1.ime.compareTo(o2.ime);
		return o1.godine - o2.godine;
	}
	
	public static int compare2(Osobe o1, Osobe o2) {
		if(o1.ime.equals(o2.ime))
			return o1.godine - o2.godine;
		return o1.ime.compareTo(o2.ime);
	}
	
	public String toString() {
		return ime + " " + godine + ", ";
	}

	@Override
	public int compareTo(Osobe o) { //prirodno uredjenje isto kao i compare
		return compare(this, o);
	}

}
