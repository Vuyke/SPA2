package naprednoSortiranje;

import java.util.Comparator;

import util.Util;

public class QuickSortUtil {
	static <T> int partitionLomut(T[] arr, Comparator<T> c, int l, int r) {// lomutova sema za biranje pivota
		T pivot = arr[r];
		int lastSmaller = l;
		for (int i = l; i <= r; i++) {// razlika od slajdova, slucaj i == r se svakako uvek izvrsava
			if (c.compare(arr[i], pivot) <= 0) {
				Util.swap(arr, i, lastSmaller);
				lastSmaller++;
			}
		}
		return lastSmaller - 1;
	}

	static <T> int partitionHoare(T[] arr, Comparator<T> c, int l, int r) {// hoareva sema za biranje pivota
		T pivot = arr[l];
		int ind1 = l + 1;
		int ind2 = r;
		while (ind1 < ind2) {
			while (ind1 < ind2 && c.compare(arr[ind1], pivot) <= 0)
				ind1++;
			while (ind1 < ind2 && c.compare(arr[ind2], pivot) >= 0)
				ind2--;
			if (ind1 >= ind2)
				break;
			Util.swap(arr, ind1, ind2);
			ind1++;
			ind2--;
		}
		Util.swap(arr, ind2, l);// moramo sa ind2 da zamenimo na kraju, primer: 4 2 2 5 1 6
		return ind2;// posle while-a cemo imati 4 2 2 1 5 6, ind2 ce biti indeks od 1, a ind1 od 5
	} // ako zamenimo sa ind1 dobili bi 5 2 2 1 4 6, 5 nije manje od 4 a levo je
}
