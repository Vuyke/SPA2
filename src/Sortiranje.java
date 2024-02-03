import java.util.Comparator;

public class Sortiranje {
	public static <T> void ispis(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static <T> void grubaSila(T[] arr, Comparator<T> comparator) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (comparator.compare(arr[i], arr[j]) > 0) {
					T tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	public static<T> void umetanje(T[] arr, Comparator<T> comparator) {
		int n = arr.length;
		int best = 0;
		for(int i = 1; i < n; i++) {
			best = comparator.compare(arr[best], arr[i]) > 0 ? i : best;
		}
		T tmp = arr[0];
		arr[0] = arr[best];
		arr[best] = tmp;
		for(int i = 2; i < n; i++) {
			int j = i - 1;
			tmp = arr[i];
			while(comparator.compare(arr[j], tmp) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = tmp;
		}
	}
	
	public static<T> void izabiranje (T[] arr, Comparator<T> comparator) {
		int n = arr.length;
		for(int i = 0; i < n - 1; i++) {
			int best = i;
			for(int j = i + 1; j < n; j++) {
				best = comparator.compare(arr[best], arr[j]) > 0 ? j : best;
			}
			T tmp = arr[i];
			arr[i] = arr[best];
			arr[best] = tmp;
		}
	}
	
	public static<T> void razmena (T[] arr, Comparator<T> comparator) {
		int n = arr.length;
		boolean p = true;
		for(int i = 0; i < n - 1 && p; i++) {
			p = false;
			for(int j = 0; j < n - 1 - i; j++) {
				if(comparator.compare(arr[j], arr[j + 1]) > 0) {
					p = true;
					T tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
	
	public static<T> void shell (T[] arr, Comparator<T> comparator) {
		int K[] = {701, 301, 132, 57, 23, 10, 4, 1}; //priblizno k = k / 2.25
		int n = arr.length;
		for(int k : K) {
			if(k >= n) {
				continue;
			}
			for(int i = 0; i < k; i++) {
				int best = i;
				for(int j = i + k; j < n; j += k) {
					if(comparator.compare(arr[best], arr[j]) > 0) {
						best = j;
					}
				}
				T tmp = arr[i];
				arr[i] = arr[best];
				arr[best] = tmp;
				for(int j = i + 2 * k; j < n; j += k) {
					tmp = arr[j];
					int j1 = j - k;
					while(comparator.compare(arr[j1], tmp) > 0) {
						arr[j1 + k] = arr[j1];
						j1 -= k;
					}
					arr[j1 + k] = tmp;
				}
			}
		}
	}
	
	private static int kComb (int k) {
		k /= 1.3;
		if(k < 1)
			k = 1;
		else if(k == 9 || k == 10)
			k = 11;
		return k;
	}
	
	public static<T> void comb(T[] arr, Comparator<T> comparator) {
		int k = arr.length; // bice smanjivano k = k / 1.3
		int n = arr.length;
		k = kComb(k);
		while(k != 1) {
			for(int i = 0; i + k < n; i++) {
				if(comparator.compare(arr[i], arr[i + k]) > 0) {
					T tmp = arr[i];
					arr[i] = arr[i + k];
					arr[i + k] = tmp;
				}
			}
			k = kComb(k);
		}
		razmena(arr, comparator); // od momenta kad k postane 1 se svodi na sortiranje razmenom(ali ispisati na ispitu celokupno razmenu i ovde :))
	}
}
