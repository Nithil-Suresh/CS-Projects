// Name: Nithil Suresh
package list;

public class ListIterator<T> {
	
	/* Current node (of type ListNode) */
	protected ListNode<T> curNode; 
	
/* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) { 
		curNode = currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { 
		if( curNode.next == null )
			return true;
		else
			return false;
	}
	
	public boolean isPastBeginning() { 
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
		return curNode.getData();
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() { 
		if( isPastEnd() )
			return;
		else
			curNode = curNode.next;
	}
	
	public void moveBackward() { 
		if( isPastBeginning() )
			return;
		else
			curNode = curNode.prev;
	}
}


