// Name: Nithil Suresh
package list;

/**
 * 
 * A custom built linked list
 * There is the type the list stores
 */
public class LinkedList<T> implements List<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		head = new ListNode( null );
		tail = new ListNode ( null );
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	
	public ListNode<T> getHead() {
		return head;
	}

	public ListNode<T> getTail() {
		return tail;
	}

	/**
	 * Clears out the entire list
	 */
	public void clear() {
		while( size > 0 ) {
			removeAtHead();
		}
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		ListNode lastNode = new ListNode (data);
		ListNode oldLast = tail.prev;
		oldLast.next = lastNode;
		tail.prev = lastNode;
		lastNode.prev = oldLast;
		lastNode.next = tail;
		size++;
		
		
	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		ListNode newNode = new ListNode (data);
		ListNode oldFirst = head.next;
		newNode.next = oldFirst;
		oldFirst.prev = newNode;
		newNode.prev = head;
		head.next = newNode;
		size++;
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {

		ListNode newNode = new ListNode(data);
		ListNode current = head;
		if( index < 0 || index > size ) {
			return;
		}
		else if( size == 0 || index == 0) {
			insertAtHead(data);
		}
		else {
			for( int i = 0; i < index; i++ ) {
				current = current.next;
			}
			ListNode nextNode = current.next;
			current.next = newNode;
			newNode.prev = current;
			newNode.next = nextNode;
			nextNode.prev = newNode;
			size++;
		}
		
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		ListNode newNode = new ListNode (data);
		ListNode nextNode = it.curNode.next;
		it.curNode.next = newNode;
		newNode.prev = it.curNode;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		size++;
	}
	
	
	
	public T removeAtTail(){
		if( size == 0 ) {
			return null;
		}
		T deletedNodeValue = tail.prev.getData();
		ListNode newLast = tail.prev.prev;
		newLast.next = tail;
		tail.prev = newLast;
		size--;
		return deletedNodeValue;
	}
	
	public T removeAtHead(){
		if( size == 0 ) {
			return null;
		}
		T deletedNodeValue = head.next.getData();
		ListNode newFirst = head.next.next;
		newFirst.prev = head;
		head.next = newFirst;
		size--;
		return deletedNodeValue;
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		ListNode ret = it.curNode;
		ListNode previous = it.curNode.prev;
		ListNode next = it.curNode.next;
		previous.next = next;
		next.prev = previous;
		size--;
		it.moveForward();
		return (T) ret;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		ListIterator iterator = new ListIterator(head.next);
		for( int i = 0; i < size; i++ ) {
			if(iterator.curNode.getData() == null)
				iterator.moveForward();
			else if(iterator.curNode.getData().equals(data)) {
				return i;
			}
			else {
				iterator.moveForward();
			}
		}
		return -1;
	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		if( index < 0 || index > size )
			return null;
		if( size == 0 )
			return null;
		ListIterator iterator = new ListIterator(head.next);
		for( int i = 0; i < index; i++ ) {
			iterator.moveForward();
		}
		return (T) iterator.value();
	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		ListIterator <T> iterator = new ListIterator(head.next);
		return iterator;
	}

	public ListIterator<T> back(){
		ListIterator <T> iterator = new ListIterator(tail.prev);
		return iterator;
	}
	
	
}
