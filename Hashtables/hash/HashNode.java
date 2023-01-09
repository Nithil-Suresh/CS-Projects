package hash;

public class HashNode<K, V> {

	private K key;
	private V value;
	private HashNode<K, V> next; // only needed if you do separate chaining

	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean equals(Object other) {
		return this.key.equals(((HashNode<K, V>) other).key);
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public void setValue(V newValue) {
		this.value = newValue;
	}

	public HashNode<K, V> getNext() { // only needed if you do separate chaining
		return this.next;
	}

	public void setNext(HashNode<K, V> node) { // only needed if you do separate chaining
		this.next = node;
	}

	@Override
	public String toString() {
		return "(" + key + "," + value + ")";
	}
}
