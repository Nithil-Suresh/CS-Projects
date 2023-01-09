package tester;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import tree.AVLTree;
import tree.BinarySearchTree;

public class Main {
	public static void main(String[] args) throws Exception{
		File file = new File("/Users/nithilsuresh/test.txt");
		Scanner sc = new Scanner(file);
		AVLTree<String> avl = new AVLTree<String>();
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		AVLTree<Integer> avlInt = new AVLTree<Integer>();
		BinarySearchTree<Integer> bstInt = new BinarySearchTree<Integer>();
		int wordCounter = 0;
		Random ran = new Random();
		long startTime = System.currentTimeMillis(); // get timer when we start
		for( int i = 0; i < 69808; i++) {
			int nxt = ran.nextInt(10000);
			//avlInt.insert(nxt);
			bstInt.insert(nxt);
			
		}
//		long startTime = System.currentTimeMillis(); // get timer when we start
//		for( int i = 0; i < 69808; i++) {
//			int nxt = ran.nextInt(10000);
//			//avlInt.find(nxt);
//			bstInt.find(nxt);
//			
//		}
//		while(sc.hasNext()) {
//			//avl.insert(sc.next());
//			bst.insert(sc.next());
//			//wordCounter++;
//			//System.out.println(sc.nextLine());
//			
//		}
//		Scanner myScanner = new Scanner(file);
//		//long startTime = System.currentTimeMillis(); // get timer when we start
//		while(myScanner.hasNext()) {
//			wordCounter++;
//			//avl.find(myScanner.next());
//			bst.find(myScanner.next());
//			//wordCounter++;
//			//System.out.println(sc.nextLine());
//			
//		}
		long elapsedTime = System.currentTimeMillis() - startTime; // get end time and subtract
		System.out.println("Elapsed time "+elapsedTime);
		System.out.println("Word count "+wordCounter);
		System.out.println("Height is "+bstInt.height());
	}
}
