package heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapPQ<T extends Comparable<T>> implements PriorityQueue<T> {
	private static final int DEFAULT_CAPACITY = 100;
	private ArrayList<T> queue;

	public HeapPQ(int init) {
		if (init <= 0)
			throw new IllegalArgumentException("Negative array size");
		queue = new ArrayList<T>(init);
	}

	public HeapPQ() {
		this(DEFAULT_CAPACITY);
	}

	private void swap(int ind1, int ind2) {// nema pametnijeg nacina za swap, java ne daje da napravis
		// swap(T element1, T element2) posto nikad ne prosledjuje po referenci nego
		// uvek po vrednosti
		T tmp = queue.get(ind1);
		queue.set(ind1, queue.get(ind2));
		queue.set(ind2, tmp);
	}

	@Override
	public void add(T element) {
		queue.add(element);
		int cur = queue.size() - 1;
		int par = cur - 1 >> 1;
		while (cur > 0 && queue.get(cur).compareTo(queue.get(par)) > 0) { // drugacije od slajdova,
			swap(par, cur);// dokle god je parrent manji od currenta menjamo ih i updatujemo pozicije
			cur = par;
			par = par - 1 >> 1;
		}
	}

	private boolean checkDel(int cur, int child) {// check za da li postoji dete i da li je vece od parrenta
		return child < queue.size() && queue.get(cur).compareTo(queue.get(child)) < 0;
	}

	@Override
	public T deleteMax() {
		if (queue.size() == 0) {
			throw new NoSuchElementException("Empty queue");
		}
		T max = queue.get(0);
		int cur = queue.size() - 1;
		swap(0, cur);
		queue.remove(cur);
		int sz = queue.size();
		cur = 0;// trenutno imamo neki mali element na pocetku i moguce da
		int child1 = 1;// ne vazi heap properti za njega i njegovu decu
		int child2 = 2;
		while (checkDel(cur, child1) || checkDel(cur, child2)) {// dokle god ima dete vece od parrenta
			int best = child1;// cim ima dete sigurno ima prvo dete jer mu je indeks manji uvek od drugog
			if (child2 < sz) {// ako drugo postoji proveri dal je vece od prvog i zameni ako jeste
				best = queue.get(child1).compareTo(queue.get(child2)) > 0 ? child1 : child2;
			}
			swap(cur, best);// posle ovoga najvece dete ce biti gore, a manji parrent i manje dete dole sto
							// je
			cur = best;// vratilo heap property, al ga mozda zeznulo na mestu gde je parrent pomeren
			child1 = cur * 2 + 1;
			child2 = cur * 2 + 2;
		}
		return max;
	}

	@Override
	public T max() {// ostale funkcije su trivijalne :)
		if (queue.size() == 0) {
			throw new NoSuchElementException("Empty queue");
		}
		return queue.get(0);
	}

	@Override
	public boolean isEmpty() {
		return queue.size() == 0;
	}

	@Override
	public int size() {
		return queue.size();
	}

}
