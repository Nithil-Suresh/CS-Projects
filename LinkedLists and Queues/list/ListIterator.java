// Name: Nithil Suresh
// Computing ID: anh6ee@virginia.edu
// Homework Name: Homework 5 - LinkedLists
package list;

public class ListIterator<T> {
	
	/* Current node (of type ListNode) */
	protected ListNode<T> curNode; 
	
/* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) { 
		/* TODO: Implement this method */
		curNode = currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy tail node? */
		if( curNode.next == null )
			return true;
		else
			return false;
	}
	
	public boolean isPastBeginning() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy head node? */
		if( curNode.prev == null )
			return true;
		else
			return false;
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		/* TODO: Implement this method */
		/* Hint: Remember to first validate the position of the Iterator */
		return curNode.getData();
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() { 
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move forward before you do! */
		/*       (Otherwise, do not move at all) */
		if( isPastEnd() )
			return;
		else
			curNode = curNode.next;
	}
	
	public void moveBackward() { 
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move backwards before you do! */
		/*       (Otherwise, do not move at all) */
		if( isPastBeginning() )
			return;
		else
			curNode = curNode.prev;
	}
}


