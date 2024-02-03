package elementarnoSortiranje;
import java.util.Comparator;

public class Sortiranje { ///sva elementarna sortiranja
	public static <T> void grubaSila(T[] arr, Comparator<T> comparator) {//svaka dva elementa menjamo ako su u inverziji
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
	//svi odavde sortovi idu na princip levi deo niza sortiran, desni nije
	public static<T> void umetanje(T[] arr, Comparator<T> comparator) {
		//do i-te pozicije sortiran, ubacuje se i+1. element gde treba u levom delu tako sto se svi 
		//veci od njega pomere desno (da bi ubacili u niz na neki indeks element prvo napravimo mesta tako sto
		//sve gurnemo desno pa tek onda ubacimo)
		int n = arr.length;
		int best = 0;
		for(int i = 1; i < n; i++) { //odma stavimo najmanji na pocetak da budemo sigurni u kasnijem whileu
			best = comparator.compare(arr[best], arr[i]) > 0 ? i : best;
		}
		T tmp = arr[0];
		arr[0] = arr[best];
		arr[best] = tmp;
		for(int i = 2; i < n; i++) {
			int j = i - 1;
			tmp = arr[i];
			while(comparator.compare(arr[j], tmp) > 0) {//posto je najmanji na pocetku, sigurno
				arr[j + 1] = arr[j];//                    ce trenutni ici negde posle njega, tako da
				j--;//                                    se sigurno zavrsava pre j = -1
			}
			arr[j + 1] = tmp;
		}
	}
	
	public static<T> void izabiranje (T[] arr, Comparator<T> comparator) {//postavimo najmanji element niza
		//na prvu poziciju, drugi najmanji na drugu...
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
	
	public static<T> void razmena (T[] arr, Comparator<T> comparator) {//poredimo svaka dva susedna
		//i menjamo ako su u inverziji, zbog toga posle svake iteracije najveci ,,ispliva'' na kraj niza
		int n = arr.length;
		boolean p = true;
		for(int i = 0; i < n - 1 && p; i++) {
			p = false;
			for(int j = 0; j < n - 1 - i; j++) {//ovo n-1-i je zbog isplivljavanja, probaj na primeru
				if(comparator.compare(arr[j], arr[j + 1]) > 0) {
					p = true;
					T tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
	
	public static<T> void shell (T[] arr, Comparator<T> comparator) {//umetanje na steroidima
		//napravimo k podnizova, svaki u sebi ima ne susedne elemente(i, i + k, ...) i nad svakim tim radimo umetanje
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
	
	private static int kComb (int k) {//pomocna funkcija za comb sort
		k /= 1.3;
		if(k < 1)
			k = 1;
		else if(k == 9 || k == 10)
			k = 11;
		return k;
	}
	
	public static<T> void comb(T[] arr, Comparator<T> comparator) {//slicno kao shell, samo sto 
		//ne delimo niz u k podnizova nego samo trustujemo da neki dalek element od svoje pozicije
		//brze priblizimo gde treba da bude tako sto ga pomerimo umesto za 1 mesto, za k mesta
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
		//posle ,,priblizavanja'' svih udaljenih elemenata, radimo obicnu razmenu
		razmena(arr, comparator); // od momenta kad k postane 1 se svodi na sortiranje razmenom(ali ispisati na ispitu celokupno razmenu i ovde :))
	}
}
