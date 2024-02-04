package set;

public class CHashSet<T> implements Set<T> {
	
	private static final int DEFAULT_CAPACITY = 101;
	private int numElements;
	private enum Status {
		EMPTY, OCCUPIED, DELETED
	};
	private static class Node {
		public Object value;
		public Status status;
		public Node(Object value, Status status) {this.value = value; this.status = status;}
		public Node(Object value) {this(value, Status.EMPTY);}
		public Node() {this(null);}
	}
	
	Node[] table;
	
	public CHashSet(int value) {
		if(value <= 0) throw new IllegalArgumentException("Negativan broj elemenata?");
		reset(value);
	}
	
	public CHashSet() {
		this(DEFAULT_CAPACITY);
	}
	
	private void reset(int size) {
		table = new Node[size];
		for(int i = 0; i < table.length; i++) {
			table[i] = new Node();
		}
		numElements = 0;
	}
	
	private boolean isProst(int x) {
		for(int i = 2; i * i <= x; i++)
			if(x % i == 0)
				return false;
		return true;
	}
	
	private int hashF(T o) {
		if(o == null)
			throw new IllegalArgumentException("Null objekat!");
		return Math.abs(o.hashCode() % table.length);
	}
	
	private void extend() {
		int newSize = table.length * 2 + 1;
		int sz = table.length;
		while(!isProst(newSize)) newSize++;
		Node[] tmp = new Node[sz];
		for(int i = 0; i < sz; i++)
			tmp[i] = table[i];
		reset(newSize);
		for(int i = 0; i < sz; i++) {
			if(tmp[i].status == Status.OCCUPIED) {
				T cur = (T) tmp[i].value;
				add(cur, hashF(cur));
			}
		}
	}
	
	private int searchChain(T element, int hash) {
		int i = 0;
		int maxLength = table.length - 1 >> 1;
		int cur = hash;
		while(i <= maxLength && table[cur].status != Status.EMPTY) {
			if(table[cur].status == Status.OCCUPIED && table[cur].value.equals(element)) {
				return cur;
			}
			i++;
			cur = (hash + i * i) % table.length;
		}
		return -1;
	}
	
	private void add(T element, int hash) {
		int i = 0;
		int cur = hash;
		numElements++;
		while(table[cur].status == Status.OCCUPIED) {
			i++;
			cur = (hash + i * i) % table.length;
		}
		table[cur] = new Node(element, Status.OCCUPIED);
	}
	
	@Override
	public boolean add(T element) {
		int i = 0;
		int hash = hashF(element);
		int cur = hash;
		int maxIteration = table.length - 1 >> 1;
		int firstOpenPosition = -1;
		while(i <= maxIteration) {
			if(table[cur].status != Status.OCCUPIED) {
				if(firstOpenPosition == -1) {
					firstOpenPosition = cur;
				}
				if(table[cur].status == Status.EMPTY)
					break;
			}
			if(table[cur].status == Status.OCCUPIED && table[cur].value.equals(element)) {
				return false;
			}
			i++;
			cur = (hash + i * i) % table.length;
		}
		double overload = (double) numElements / (double) table.length;
		if(firstOpenPosition == -1 || overload > 0.7) {
			extend();
			add(element, hashF(element));
		}
		else {
			table[firstOpenPosition] = new Node(element, Status.OCCUPIED);
			numElements++;
		}
		return true;
	}

	@Override
	public boolean remove(T element) {
		int hash = hashF(element);
		int ind = searchChain(element, hash);
		if(ind == -1)
			return false;
		numElements--;
		table[ind].status = Status.DELETED;
		return true;
	}

	@Override
	public boolean contains(T element) {
		int hash = Math.abs(element.hashCode() % table.length);
		if(searchChain(element, hash) == -1)
			return false;
		return true;
	}
	
	public void print() {
		for(int i = 0; i < table.length; i++) {
			if(table[i].status == Status.OCCUPIED) {
				System.out.println(table[i].value + " ");
			}
		}
		System.out.println();
	}

}
