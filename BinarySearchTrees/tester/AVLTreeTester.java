package tester;

import tree.AVLTree;
import tree.BinarySearchTree;

public class AVLTreeTester {

	public static void main(String[] args) {
		
		/* Here are two test cases for your implementations. */
		/* You SHOULD create more */
		
		/*
		 * 	Correct output:
		 * 	BST Pre: 5 4 3 2 1 9 8 7 6 
		 *	BST In: 1 2 3 4 5 6 7 8 9 
		 *	BST Post: 1 2 3 4 6 7 8 9 5 
		 *	AVL Pre: 4 2 1 3 8 6 5 7 9 
		 *	AVL In: 1 2 3 4 5 6 7 8 9 
		 *	AVL Post: 1 3 2 5 7 6 9 8 4 
		 */

		//You can comment this line back in next week
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		//BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		int[] toInsert = {5,4,3,2,1,9,8,7,6};
		//int [] test = {1, 2, 3};
		for(int i : toInsert) {
			avl.insert(i);
			
			//System.out.println(avl.toString());
			//bst.insert(i);
			//System.out.println("Tree is ");
		}
		
		/* Print out pre, in, and post-order */

//		System.out.println("BST Pre: " + bst.getPreOrder());
//		System.out.println("BST In: " + bst.getInOrder());
//		System.out.println("BST Post: " + bst.getPostOrder());
		
		// You can comment these lines in next week as well
		 System.out.println("AVL Pre: " + avl.getPreOrder());
		 System.out.println("AVL In: " + avl.getInOrder());
		 System.out.println("AVL Post: " + avl.getPostOrder());
		
	}
}
