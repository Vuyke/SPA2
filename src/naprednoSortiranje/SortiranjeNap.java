package naprednoSortiranje;

import java.util.Comparator;

import heap.HeapPQ;
import heap.PriorityQueue;
import sortiranjeLista.SortableList;
import util.Osobe;
import util.Util;

public class SortiranjeNap {
	public static <T extends Comparable<T>> void heapSortFake(T[] arr) {// bez komparatora da ne bih menjao PQ
																		// implementaciju
		PriorityQueue<T> prio = new HeapPQ<T>();
		if (arr == null || arr.length == 0)
			return;
		for (T elem : arr) {// dodamo sve u prio queue
			prio.add(elem);
		}
		for (int i = arr.length - 1; i >= 0; i--) {// ispisemo maksimalni na poslednju poziciju, drugi max
			arr[i] = prio.deleteMax();// na pretposlednju...
		}
	}

	public static <T> void heapSort(T[] arr, Comparator<T> c) {// sada ide big boy implementacija bez PQ
		int n = arr.length;// radi memorijske optimizacije
		int ind = n - 2 >> 1; // fensi nacin za (n - 2) / 2
		for (int i = ind; i >= 0; i--) {
			HeapSortUtil.makeHeapProperty(arr, c, i, n); // pogledati HeapSortUtil file
		}
		for (int i = n - 1; i >= 0; i--) {
			Util.swap(arr, 0, i);
			HeapSortUtil.makeHeapProperty(arr, c, 0, i);
		}
	}

	public static <T> void quickSort(T[] arr, Comparator<T> c, int l, int r) {// izaberemo pivota, svi manji od
		// pivota levo, veci desno, ponavljamo za levi i desni deo
		if (l >= r) {
			return;
		}
		int mid = QuickSortUtil.partitionLomut(arr, c, l, r);// radi particionisanje na manje i vece od pivota
		quickSort(arr, c, l, mid - 1);// svi manji od pivota
		quickSort(arr, c, mid + 1, r);// svi veci od pivota
	}

	public static <T> void quickSort(T[] arr, Comparator<T> c) {
		quickSort(arr, c, 0, arr.length - 1);
	}

	public static void countSort(int[] arr) {// ne uporedjujemo elemente vec brojimo koliko kog ima
		if (arr.length == 0)
			return;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int niz[] = new int[max + 1];// pravljenje dovoljno brojaca
		for (int i = 0; i < arr.length; i++) {
			niz[arr[i]]++;// dodavanje na brojac broja a[i]
		}
		int ind = 0;
		for (int i = 0; i <= max; i++) {
			for (int j = 0; j < niz[i]; j++) {
				arr[ind++] = i;
			}
		}
	}
}
