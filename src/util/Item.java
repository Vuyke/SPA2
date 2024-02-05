package util;

public class Item implements Comparable<Item> {
	private int tezina;
	private int cena;

	public Item(int tezina, int cena) {
		if (tezina <= 0 || cena <= 0)
			throw new IllegalArgumentException("Negativan broj?");
		this.tezina = tezina;
		this.cena = cena;
	}

	public int getTezina() {
		return tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String toString() {
		return "(" + tezina + ", cena: " + cena + ")";
	}

	@Override
	public int compareTo(Item o) {
		double cur1 = (double) cena / (double) tezina;
		double cur2 = (double) o.cena / (double) o.tezina;
		if (cur1 > cur2)
			return -1; // da bi sortirali opadajuce
		if (cur1 < cur2)
			return 1;
		return 0;
	}

}
