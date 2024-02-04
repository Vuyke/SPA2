package util;

import backtrack.Item;

public class Util { //odavde ce se uzimati elementi za nizove,liste,priority queove...
	public static Osobe[] osobe;
	public static Item[] items;
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
	
	public static <T> void ispis(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static<T> void swap(T[] arr, int ind1, int ind2) {
		T tmp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = tmp;
	}
}
