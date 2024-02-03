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

	private void swap(int ind1, int ind2) {
		T tmp = queue.get(ind1);
		queue.set(ind1, queue.get(ind2));
		queue.set(ind2, tmp);
	}

	@Override
	public void add(T element) {
		queue.add(element);
		int cur = queue.size() - 1;
		int par = cur - 1 >> 1;
		while (cur > 0 && queue.get(cur).compareTo(queue.get(par)) > 0) {
			swap(par, cur);
			cur = par;
			par = par - 1 >> 1;
		}
	}

	private boolean checkDel(int cur, int child) {
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
		cur = 0;
		int child1 = 1;
		int child2 = 2;
		while (checkDel(cur, child1) || checkDel(cur, child2)) {
			int best = child1;
			if (child2 < sz) {
				best = queue.get(child1).compareTo(queue.get(child2)) > 0 ? child1 : child2;
			}
			swap(cur, best);
			cur = best;
			child1 = cur * 2 + 1;
			child2 = cur * 2 + 2;
		}
		return max;
	}

	@Override
	public T max() {
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
