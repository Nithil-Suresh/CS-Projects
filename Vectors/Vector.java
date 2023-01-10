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
	}

	@Override
	public int size() {
		// TODO: Implement this method
	}

	@Override
	public void clear() {
		// TODO: Implement this method
	}

	@Override
	public void insertAtTail(T item) {
		// TODO: Implement this method
	}

	@Override
	public void insertAtHead(T item) {
		// TODO: Implement this method
	}

	@Override
	public void insertAt(int index, T item) {
		// TODO: Implement this method
	}

	@Override
	public T removeAtTail() {
		// TODO: Implement this method
		return null;
	}

	@Override
	public T removeAtHead() {
		// TODO: Implement this method
		return null;
	}

	@Override
	public int find(T item) {
		// TODO: Implement this method
	}

	@Override
	public T get(int index) {
		// TODO: Implement this method
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
