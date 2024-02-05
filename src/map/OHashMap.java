package map;

public class OHashMap<K, V> implements Map<K, V> {
	private static final int DEFAULT_CAPACITY = 101;

	private static class Node {
		Object key;
		Object value;
		Node next;

		public Node(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node[] table;

	public OHashMap(int value) {
		if (value <= 0)
			throw new IllegalArgumentException("Negativan broj elemenata?");
		table = new Node[value];
	}

	public OHashMap() {
		this(DEFAULT_CAPACITY);
	}

	int hash(K o) {
		if (o == null)
			throw new IllegalArgumentException("Ne postoji za hesovanje!");
		return Math.abs(o.hashCode() % table.length);
	}

	private Node[] searchCollisionChain(K key, int hashValue) {
		Node cur = table[hashValue];
		Node prev = null;
		while (cur != null) {
			if (cur.key.equals(key)) {
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
	public boolean add(K key, V value) {
		int hashValue = hash(key);
		Node[] res = searchCollisionChain(key, hashValue);
		if (res != null)
			return false;
		Node nov = new Node(key, value);
		nov.next = table[hashValue];
		table[hashValue] = nov;
		return true;
	}

	@Override
	public boolean remove(K key) {
		int hashValue = hash(key);
		Node[] res = searchCollisionChain(key, hashValue);
		if (res == null)
			return false;
		if (res[0] == null) {
			table[hashValue] = table[hashValue].next;
		} else {
			res[0].next = res[1].next;
		}
		return true;
	}

	@Override
	public V get(K key) {
		int hashValue = hash(key);
		Node[] res = searchCollisionChain(key, hashValue);
		if (res == null) {
			return null;
		}
		if (res[1] != table[hashValue]) {
			res[0].next = res[1].next;
			res[1].next = table[hashValue];
			table[hashValue] = res[1];
		}
		return (V) res[1].value;
	}

	@Override
	public boolean modify(K key, V value) {
		int hashValue = hash(key);
		Node[] res = searchCollisionChain(key, hashValue);
		if (res == null)
			return false;
		res[1].value = value;
		return true;
	}

	public void print() {
		for (int i = 0; i < table.length; i++) {
			System.out.print("Hes kod = " + i + ": ");
			Node cur = table[i];
			while (cur != null) {
				System.out.print(cur.key + " " + cur.value + ", ");
				cur = cur.next;
			}
			System.out.println();
		}
	}
}
