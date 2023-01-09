// Name: Nithil Suresh 
package hash;


/**
 * Hash Table implementation.
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements Map<K,V>{
	public static void main(String[] args){
		HashTable<Integer, String> test = new HashTable<Integer, String>();
//		test.insert( 5, 25);
//		test.insert( 5, 20) ;
//		test.insert( 8, 20) ;
//		test.insert( 6, 20) ;
//		test.insert( 7, 20) ;

		String[] stringInts = { "0", "1", "2" ,"3", "4", "5", "6", "7", "8", "9" };
		test = new HashTable<>(11);
		test.printHashTable();
		int smallCount = 5;
		for (int i=0; i < smallCount; ++i) {
			test.insert(i, stringInts[i]);
		}
	}
	
	private static final int INITIAL_CAP = 5;  // a default initial capacity (set low for initial debugging)
	private int currentCapacity = INITIAL_CAP;


	private HashNode<K,V>[] table;
	private int size = 0;
	
	
	
	public HashTable() {  // default constructor sets capacity to default value
		this(INITIAL_CAP);
	}
	
	public HashTable(int capacity) {  // constructor sets capacity to given value

		this.table = new HashNode[capacity];
		currentCapacity = capacity;
	}
	
	// insert() adds a new key/value pair if the key is not found, otherwise it replaces
	//    the existing key's value
	@Override
	public void insert(K key, V value) {
		HashNode <K, V> newNode = new HashNode <K, V>(key, value);
		double lambda = (double) size / currentCapacity;
		if( lambda >= 0.75 ) {
			HashNode<K, V>[] newTable = new HashNode[currentCapacity*2];
			for(int i = 0; i < table.length; i++) {
				newTable[i] = table[i];
			}
			currentCapacity *= 2;
			table = newTable;
		}
		for(int i = 0; i < table.length; i++) {
			if( table[i] != null ) {
				if( table[i].getKey().equals(key) ) {
					table[i] = newNode;
					size++;
					return;
				}
			}
		}
		for(int i = 0; i < table.length; i++) {
			if(table[index(key, i)] == null) {
				table[index(key, i)] = newNode;
				size++;
				return;
			}
		}
	}
	private int index(K key, int i) {
		return Math.abs(key.hashCode() + i) % table.length;
	}
//	private void resize() {
//		System.out.println("test");
//		HashNode<K, V>[] newTable = new HashNode[currentCapacity*2];
//		for(int i = 0; i < table.length; i++) {
//			newTable[i] = table[i];
//		}
//		table = newTable;
//	}
	@Override
	public V retrieve(K key) {
		for(int i = 0; i < table.length; i++) {
			if( table[i] != null ) {
				if( table[i].getKey().equals(key) ) {
					return table[i].getValue();
				}
			}
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		for(int i = 0; i < table.length; i++) {
			if( table[i] != null ) {
				if( table[i].getKey().equals(key) )
					return true;
			}
		}
		return false;
	}

	@Override
	public void remove(K key) {
		for( int i = 0; i < table.length; i++ ) {
			if( table[i] != null ) {
				if( table[i].getKey().equals(key) ) {
					table[i] = null;
					size--;
					return;
				}
			}
		}
	}
	
	

	
	public void printHashTable() {
		for (int idx=0; idx < this.currentCapacity; ++idx) {
			System.out.print(idx + ": ");
			printEntriesByIndex(idx);
		}
	}
	
	private void printEntriesByIndex(int idx) {

		if( table[idx] == null ) {
			System.out.println("no entries");
		}
		else {
			System.out.println( table[idx].getKey() + " "+ table[idx].getValue());
		}
	}
		
}
