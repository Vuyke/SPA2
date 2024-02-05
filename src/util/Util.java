package util;

public class Util { // odavde ce se uzimati elementi za nizove,liste,priority queove...
	public static Osobe[] osobe;
	public static Osobe[] osobe2;
	public static Item[] items;
	public static Tacka[] tacke;
	static {
		osobe = new Osobe[8];
		osobe[0] = new Osobe(12, "Jovan");
		osobe[1] = new Osobe(15, "Milana");
		osobe[2] = new Osobe(14, "Luka");
		osobe[3] = new Osobe(21, "Sebastijan");
		osobe[4] = new Osobe(45, "Milica");
		osobe[5] = new Osobe(19, "Danilo");
		osobe[6] = new Osobe(80, "Radmila");
		osobe[7] = new Osobe(5, "Ana");
	}

	static {
		osobe2 = new Osobe[3];
		osobe2[0] = new Osobe(12, "Jovan");
		osobe2[1] = new Osobe(15, "Milana");
		osobe2[2] = new Osobe(14, "Luka");
	}

	static {
		items = new Item[8];
		items[0] = new Item(5, 10);
		items[1] = new Item(8, 15);
		items[2] = new Item(3, 7);
		items[3] = new Item(6, 12);
		items[4] = new Item(2, 4);
		items[5] = new Item(7, 14);
		items[6] = new Item(4, 9);
		items[7] = new Item(1, 2);
	}
	
	static {
		tacke = new Tacka[8];
        tacke[0] = new Tacka(1.0, 2.0);
        tacke[1] = new Tacka(3.5, 4.2);
        tacke[2] = new Tacka(0.8, 1.7);
        tacke[3] = new Tacka(2.5, 3.0);
        tacke[4] = new Tacka(4.2, 1.5);
        tacke[5] = new Tacka(3.0, 2.8);
        tacke[6] = new Tacka(1.2, 4.0);
        tacke[7] = new Tacka(0.5, 1.0);
	}
	
	public static <T> void ispis(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static <T> void swap(T[] arr, int ind1, int ind2) {
		T tmp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = tmp;
	}
}
