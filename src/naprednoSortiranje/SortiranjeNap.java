package naprednoSortiranje;

import java.util.Comparator;

import heap.HeapPQ;
import heap.PriorityQueue;
import util.Osobe;

public class SortiranjeNap {
	public static <T extends Comparable<T>> void heapSortFake(T[] arr, Comparator<T> c) {
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
}
