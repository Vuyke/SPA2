package map;

public interface Map<K, V> {
	boolean add(K key, V value);
	boolean remove(K key);
	V get(K key);
	boolean modify(K key, V value);
}
