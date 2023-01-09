package tree;

/**
 * Simple BST Node. Contains the data in this node, and pointers to left and right children
 * @author CS2100 Team
 *
 * @param <T>
 */
public class TreeNode<T>{
		// Every TreeNode has a left and right reference (pointer), and a data item (currently null)
		public TreeNode<T> left = null;
		public TreeNode<T> right = null;
		protected int height = 1;
		public T data = null;
		
		public TreeNode(T data) { // Constructor
			this.data = data;
		}
		
		public TreeNode(T data, int height) { // Another Constructor
			this(data);
			this.height = height;
		}
		public static void main(String[] args) {
			TreeNode<Integer> node = new TreeNode<Integer>(5);
			System.out.println(node.height);
		}
		
}
