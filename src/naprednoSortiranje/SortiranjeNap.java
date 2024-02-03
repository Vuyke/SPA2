package naprednoSortiranje;

import java.util.Comparator;

import heap.HeapPQ;
import heap.PriorityQueue;
import util.Osobe;

public class SortiranjeNap {
	public static <T extends Comparable<T>> void heapSortFake(T[] arr) {//bez komparatora da ne bih menjao PQ implementaciju
		PriorityQueue<T> prio = new HeapPQ<T>();
		if(arr == null || arr.length == 0)
			return;
		for(T elem : arr) {//dodamo sve u prio queue
			prio.add(elem);
		}
		for(int i = arr.length - 1; i >= 0; i--) {//ispisemo maksimalni na poslednju poziciju, drugi max
			arr[i] = prio.deleteMax();//na pretposlednju...
		}
	}
	
	public static <T> void heapSort(T[] arr, Comparator<T> c) {//sada ide big boy implementacija bez PQ
		int n = arr.length;//                                    radi memorijske optimizacije
		int ind = n - 2 >> 1; //fensi nacin za (n - 2) / 2
		for(int i = ind; i >= 0; i--) {
			HeapSortUtil.makeHeapProperty(arr, c, i, n);
		}
		for(int i = n - 1; i >= 0; i--) {
			HeapSortUtil.swapHeap(arr, 0, i);
			HeapSortUtil.makeHeapProperty(arr, c, 0, i);
		}
	}
}
