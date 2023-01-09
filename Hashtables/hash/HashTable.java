// Name: Nithil Suresh 
// Computing ID: anh6ee@viginia.edu
// Homework Name: Homework 10: Hash Tables
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

	/*
	 * Here are some hints about how to declare your hash table.
	 * If you're using open addressing, it might look like this:
	 * 		private HashNode<K,V>[] table;
	 * If you're using separate chaining, it might look like this:
	 * 		private HashNode<K,V>[] table;
	 * or like this:
	 * 		private ArrayList<HTNode<K, V>> table;
	 */
	private HashNode<K,V>[] table;
	private int size = 0;
	
	/* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
	
	
	public HashTable() {  // default constructor sets capacity to default value
		this(INITIAL_CAP);
	}
	
	public HashTable(int capacity) {  // constructor sets capacity to given value
		/* TODO: IMPLEMENT THIS METHOD */
		
		/*
		 * Here are some hints about how to allocate memory for your hash table.
		 * If you're using either definition that uses arrays shown above, it might
		 * look like this:
		 * 		this.table = new HashNode[capacity];
		 * If you're using an ArrayList as shown above, it might look like this:
		 * 		this.table = new ArrayList<>(capacity); // sets list's initial capacity
		 */
		this.table = new HashNode[capacity];
		currentCapacity = capacity;
	}
	
	// insert() adds a new key/value pair if the key is not found, otherwise it replaces
	//    the existing key's value
	@Override
	public void insert(K key, V value) {
		/* TODO: IMPLEMENT THIS METHOD */
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
		/* TODO: IMPLEMENT THIS METHOD */
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
		/* TODO: IMPLEMENT THIS METHOD */
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
		/* TODO: IMPLEMENT THIS METHOD */
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
	
	
	/*
	 * OPTIONAL HELPER METHODS: The next two methods will let you print out your
	 * entire hash table, or let you make sure all keys that hash to a single
	 * bucket's index get stored as they should in your table. You'll need to
	 * implement the second method; it depends on how you store entries and
	 * handle collisions. This is NOT required, but you may find it helpful when
	 * debugging and testing your code.
	 */
	
	public void printHashTable() {
		for (int idx=0; idx < this.currentCapacity; ++idx) {
			System.out.print(idx + ": ");
			printEntriesByIndex(idx);
		}
	}
	
	private void printEntriesByIndex(int idx) {
		/*
		 * To implement this to help print out one bucket of your hash table, you need to:
		 * a) If there are no key/value pairs in the bucket idx, print "no entries"
		 * b) If there are key/value pairs at that bucket, use a loop to print each one.
		 *    Best to use System.out.print() and not println() so they're all on one line.
		 * c) At the end of that loop, do System.out.println() to print a new line.
		 */
		//System.out.println("Not yet implemented...");
		if( table[idx] == null ) {
			System.out.println("no entries");
		}
		else {
			System.out.println( table[idx].getKey() + " "+ table[idx].getValue());
		}
	}
		
}
