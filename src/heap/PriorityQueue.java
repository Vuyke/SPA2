package heap;

public interface PriorityQueue<T extends Comparable<T>> {
	void add(T element);

	T max();

	T deleteMax();

	boolean isEmpty();

	int size();
}
