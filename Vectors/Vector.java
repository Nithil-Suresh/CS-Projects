package vector;

import java.util.Arrays;

public class Vector<T> implements List<T> {

	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;

	public Vector() {
		this(INITIAL_CAPACITY);  // calls the other constructor that takes an int parameter
	}

	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}

	public int capacity() {
		return this.itemArray.length;
	}

	/**
	 * When the underlying array fills up, we need to somehow resize it to accommodate the
	 * Vectors's elements.
	 * Ignores the request if the requested new capacity is too small to fit the elements
	 * already in the Vector
	 */
	public void resize(int newCapacity) {
		// TODO: Implement this method
		if(newCapacity > capacity()) {
			T [] temp = (T[]) new Object[newCapacity];
			for( int i = 0; i < size(); i++) {
				temp[i] = itemArray[i];
			}
			itemArray = temp;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for( int i = 0; i < size; i++ ) {
			itemArray[i] = null;
		}
		size = 0;
	}

	@Override
	public void insertAtTail(T item) {
		if(size == capacity()) {
			resize(capacity() + 100);
		}
		itemArray[this.size()] = item;
		size++;
//		System.out.println(size);
//		System.out.println(capacity());
	}
	
	@Override
	public void insertAtHead(T item) {
		if(size == capacity()) {
			resize(capacity() + 100);
		}
		if(size() == 0) {
			itemArray[0] = item;
			size++;
			return;
		}
		T temp = itemArray[size()-1];
		if(size() == 1) {
			itemArray[1] = itemArray[0];
			itemArray[0] = item;
		}
		for( int i = size()-1; i >= 0; i--) {
			itemArray[i+1] = itemArray[i];
		}
		itemArray[0] = item;
		size++;
		itemArray[size()-1] = temp;
	}

	@Override
	public void insertAt(int index, T item) {
		if( index < 0 || index > size)
			return;
		if(index == 0) {
			insertAtHead(item);
			return;
		}
		if(index == size()) {
			insertAtTail(item);
			return;
		}
		if(size() + 1 > capacity()) {
			resize(capacity() + 5000);
		}
		T temp = itemArray[size()-1];
		if(size() == 1) {
			itemArray[1] = itemArray[0];
			itemArray[0] = item;
		}
		for( int i = size()-1; i >= index; i--) {
			itemArray[i+1] = itemArray[i];
		}
		itemArray[index] = item;
		size++;
		itemArray[size-1] = temp;
		
	}

	@Override
	public T removeAtTail() {
		
		T item = itemArray[size() - 1];
		itemArray[size() - 1] = null;
		size--;
		return item;
		
	}

	@Override
	public T removeAtHead() {
		
		T item = itemArray[0];
		for(int i = 0; i < size(); i++) {
			itemArray[i] = itemArray[i+1];
		}
		size--;
		return item;
		
	}

	@Override
	public int find(T item) {
		
		for( int i = 0; i < size; i++ ) {
			if( get(i).equals(item) ) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public T get(int index) {
		if( index > size()-1 || index < 0)
			return null;
		return itemArray[index];

	}
	
	/*
	 * This toString() method allow you to print a nicely formatted version of your Vector. E.g.
	 *     System.out.println( myVector );
	 * It uses utility methods in the Java Arrays library.
	 */
	@Override
	public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
	}

}
