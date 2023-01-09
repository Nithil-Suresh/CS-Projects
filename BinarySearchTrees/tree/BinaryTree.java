// Name: Nithil Suresh 

package tree;


public class BinaryTree<T> {

	public TreeNode<T> root = null;
	
	/* Tree Traversal methods */
	
	
	//left, root, right
	public String getInOrder() {
		 return getInOrder(root); // call getInOrder starting at the root!
	}
	String answerIn = "";
	private String getInOrder(TreeNode<T> curNode) {
		if( curNode == null ){
			return "";
		}
		return getInOrder(curNode.left)+ curNode.data.toString() + " " + getInOrder(curNode.right);
	}
	
	// root, left, right
	public String getPreOrder() {
		return getPreOrder(root); // call getPreOrder starting at the root! 
	}
	String answerPre = "";
	private String getPreOrder(TreeNode<T> curNode) {
		
		if( curNode == null )
			return answerPre;
		answerPre += curNode.data.toString() + " ";
		getPreOrder(curNode.left);
		getPreOrder(curNode.right);
		return answerPre;
	}
	
	// left, right, root
	public String getPostOrder() {
		return getPostOrder(root);  // call getPostOrder starting at the root! 
	}
	String answerPost = "";
	private String getPostOrder(TreeNode<T> curNode) {
		if( curNode == null )
			return answerPost;
		getPostOrder(curNode.left);
		getPostOrder(curNode.right);
		answerPost += curNode.data.toString() + " ";
		return answerPost;
	}


	
	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		//System.out.println("Root data "+this.root.data);
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
//		if(curNode!=null) {
//			System.out.println("Current node " +curNode.data);
//		}
//		if(curNode == null) {
//			System.out.println("Current node " +curNode);
//		}
		if(curNode == null) {
			return;
		}
		//System.out.println("indentlevel is " +indentLev);
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}
	
	//TODO: Look at these methods and think about how they might be useful for this assignment
	public int height() {
		return height(root);
	}
	
	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right))+1;
	}
	/* toString(): Returns a string representation of a binary tree in the following format:
	   (root left-subtree right-subtree)
	   where the subtrees’ strings are made recursively. If a subtree is empty, “null”
	   is printed, but if *both* subtrees are empty, the node is printed alone without
	   the parentheses or the nulls.  The final result has any leading or trailing
	   spaces removed, and multiple spaces are converted to single spaces.
	 */
		public String toString() {
			return treeString(this.root).trim().replaceAll("\\s+\\)", ")");
		}

		private String treeString(TreeNode<T> curNode) {
			if (curNode == null) {
				return "null ";
			}
			if (curNode.left == null && curNode.right == null) {
				return curNode.data + " ";
			}
			String res = "(" + curNode.data + " " + treeString(curNode.left) +
						treeString(curNode.right) + ") ";
			return res;
		}



		public void copyOf(BinaryTree<T> source) {
			this.root = copyRecursive(source.root);
		}

		public TreeNode<T> copyRecursive(TreeNode<T> sourceNode) {
			if (sourceNode == null)
				return null;	
			TreeNode<T> copyNode = new TreeNode<T>(sourceNode.data);
			copyNode.left = copyRecursive(sourceNode.left);
			copyNode.right = copyRecursive(sourceNode.right);
			return copyNode;
		}
		

}
