package naprednoSortiranje;

import java.util.Comparator;

public class HeapSortUtil {
	static <T> void makeHeapProperty(T[] arr, Comparator<T> c, int cur, int sz) {
		//ovde radimo isto kao u PQ posle del maxa namestanje heap osobine
		int child1 = cur * 2 + 1;
		int child2 = cur * 2 + 2;
		while(checkHeap(arr, c, cur, child1, sz) || checkHeap(arr, c, cur, child2, sz)) {
			int best = child1;
			if(child2 < sz) {
				best = c.compare(arr[child1], arr[child2]) < 0 ? child2 : child1;
			}
			swapHeap(arr, cur, best);
			cur = best;
			child1 = cur * 2 + 1;
			child2 = cur * 2 + 2;
		}
	}
	
	static<T> void swapHeap(T[] arr, int ind1, int ind2) {
		T tmp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = tmp;
	}
	
	private static <T> boolean checkHeap(T[] arr, Comparator<T> c, int cur, int child, int sz) {//provera dal je dete vece od oca
		return child < sz && c.compare(arr[cur], arr[child]) < 0; 
	}
}
