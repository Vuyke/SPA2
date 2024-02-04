package backtrack;

public class Item {
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

}
