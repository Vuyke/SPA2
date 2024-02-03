package set;

public class OHashSet<T> implements Set<T> {

	private static final int DEFAULT_CAPACITY = 100;

	private static class Node {
		Object value;
		Node next;

		public Node(Object value) {
			this.value = value;
		}
	}

	private Node[] table;

	public OHashSet(int value) {
		if (value <= 0)
			throw new IllegalArgumentException("Nije pozitivan broj");
		table = new Node[value];
	}

	public OHashSet() {
		this(DEFAULT_CAPACITY);
	}

	private int hash(T o) {
		if (o == null)
			throw new IllegalArgumentException("Objekat ne postoji!");
		return Math.abs(o.hashCode() % table.length);
	}

	private Node[] searchChain(T element, int hash) {//vracamo element i njegovog prethodnog ako nadjemo
		Node cur = table[hash];
		Node prev = null;
		while (cur != null) {
			if (cur.value.equals(element)) {
				Node[] res = new Node[2];
				res[0] = prev;
				res[1] = cur;
				return res;
			}
			prev = cur;
			cur = cur.next;
		}
		return null;
	}

	@Override
	public boolean contains(T element) {
		if (element == null)
			throw new IllegalArgumentException("Objekat ne postoji!!!");
		return searchChain(element, Math.abs(element.hashCode() % table.length)) != null;
	}

	public boolean add(T element) {
		if (element == null)
			throw new IllegalArgumentException("Objekat ne postoji!!!");
		int hash = Math.abs(element.hashCode() % table.length);
		if (searchChain(element, hash) != null)
			return false;
		Node tmp = new Node(element);
		tmp.next = table[hash];
		table[hash] = tmp;
		return true;
	}
	
	@Override
	public boolean remove(T element) {
		if(element == null)
			throw new IllegalArgumentException("Objekat ne postoji!");
		int hash = Math.abs(element.hashCode() % table.length);
		Node[] n = searchChain(element, hash);
		if(n == null)
			return false;
		if(n[0] == null) {
			table[hash] = table[hash].next;
			return true;
		}
		n[0].next = n[1].next;
		return true;
	}
	
	public void print() {
		for(int i = 0; i < table.length; i++) {
			System.out.print("HashCode = " + i + ": ");
			Node cur = table[i];
			while(cur != null) {
				System.out.print(cur.value + " ");
				cur = cur.next;
			}
			System.out.println();
		}
	}
}
