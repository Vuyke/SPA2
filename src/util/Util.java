package util;

public class Util { //odavde ce se uzimati elementi za nizove,liste,priority queove...
	public static Osobe[] osobe;
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
	
	public static <T> void ispis(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
