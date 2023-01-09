// Name: Nithil Suresh 
// Computing ID: anh6ee@virginia.edu
// Homework: Homework 7a
package tree;

/**
 * Self-balancing AVL Tree
 * @author CS 2100 Team
 *
 * @param <T>
 */
 
 // Don't worry about this class for the first assignment in the module.
 // You WILL use this class in the second assignment on AVL trees.

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	//public static void main(String [] args) {
//		AVLTree<Integer> avl = new AVLTree<Integer>();
//		int [] test = {1, 2};
//		for(int i : test) {
//			avl.insert(i);
//			//bst.insert(i);
//			//System.out.println("Tree is ");
//		}
//		System.out.println(avl.toString());
		
	//}
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		curNode = super.insert(data,  curNode);
		
		/* Handle the case when remove returns null */
		if(curNode == null) return null;
		
		/* update the height of this node if necessary (if no change, that’s OK) */
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		
		/* rotate if necessary (call balance() method to balance the node) */
		curNode = this.balance(curNode);
		//System.out.println(curNode.data);
		return curNode;
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing, use “super” to achieve this */
		curNode = super.remove(data,  curNode);
		
		/* Handle the case when remove returns null */
		if(curNode == null) return null;
		
		/* update the height of this node if necessary (if no change, that’s OK) */
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		
		/* rotate if necessary (call balance() method to balance the node) */
		curNode = this.balance(curNode);
		
		return curNode;
	}
	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		//System.out.println(balanceFactor(curNode));
		if( balanceFactor(curNode) == 2 ) {
			if( balanceFactor(curNode.left) == 1) {
				return rotateRight(curNode);
			}
			else {
				curNode.left = rotateLeft(curNode.left);
				return rotateRight(curNode);
			}
		}
		if( balanceFactor(curNode) == -2 ) {
			if( balanceFactor(curNode.right) == -1) {
				return rotateLeft(curNode);
			}
			else {
				curNode.right = rotateRight(curNode.right);
				return rotateLeft(curNode);
			}
		}
		return curNode;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		//TODO: Implement this method
		TreeNode<T> lNew = curNode.left;
		TreeNode<T> LR = curNode.left.right;
		lNew.right = curNode;
		curNode.left = LR;
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		lNew.height = Math.max(height(lNew.left), height(lNew.right))+1;
		return lNew;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		//TODO: Implement this method
		TreeNode<T> rNew = curNode.right;
		TreeNode<T> RL = curNode.right.left;
		rNew.left = curNode;
		curNode.right = RL;
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		rNew.height = Math.max(height(rNew.left), height(rNew.right))+1;
		return rNew;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		//TODO: Implement this method	
		return height(node.left) - height(node.right); 
	}

	
	
}
