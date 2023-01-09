package sorting;




import java.util.Arrays;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		/* Read in size and which algorithm to run */
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int whichSort = in.nextInt();
		in.close();

		/* Make an array to sort. Fill with random numbers */
		final Integer[] list = new Integer[size];
		for (int i = 0; i < size; i++)
			list[i] = (int) (Math.random() * 3 * size);

		/* Make four copies to sort */
		Integer[] mergeSortList = list.clone();
		Integer[] quickSortList = list.clone();
		Integer[] insertionSortList = list.clone();

		if (whichSort == 1) {
			System.out.print("Sorting using mergesort...");
			System.out.println(Arrays.toString(mergeSortList));
			SortingAlgorithms.mergeSort(mergeSortList);
			System.out.print("Done...checking if sorted correctly...");
			checkSorted(list, mergeSortList);
			System.out.println("DONE");
			System.out.println(Arrays.toString(mergeSortList));
		}
		else if (whichSort == 2) {
			System.out.print("Sorting using quicksort...");
			SortingAlgorithms.quickSort(quickSortList);
			System.out.print("Done...checking if sorted correctly...");
			checkSorted(list, quickSortList);
			System.out.println("DONE");
		}
		else if (whichSort == 3) {
			System.out.print("Sorting using insertion sort...");
			System.out.println(Arrays.toString(insertionSortList));
//			System.out.println("\ninput: " + Arrays.toString(insertionSortList));
			SortingAlgorithms.insertionSort(insertionSortList);
//			System.out.println("sorted:" + Arrays.toString(insertionSortList));
			System.out.print("Done...checking if sorted correctly...");
			checkSorted(list, insertionSortList);
			System.out.println("DONE");
			System.out.println(Arrays.toString(insertionSortList));
		}

	}

	public static <T extends Comparable<T>> boolean checkSorted(T[] orig, T[] sorted) {
		/* Make sure size is the same */
		if (orig.length != sorted.length) {
			System.out.println("ERROR...original list and sorted list have different lengths...");
			return false;
		}

		/* Make sure new array is sorted */
		for (int i = 1; i < sorted.length; i++) {
			if (sorted[i].compareTo(sorted[i - 1]) < 0) {
				System.out.println("ERROR...the sorted list does not appear to be correctly sorted...");
				return false;
			}
		}
		
		// Make sure the same elements are in each array using binary search.

		boolean ok = true;
		for (int i = 0; i < orig.length; i++) {
			int inSortedIndex = Arrays.binarySearch(sorted, orig[i]);
			if (inSortedIndex < 0) {
				ok = false;
				break;
			}
		}
		if (!ok ) {
			System.out.println(
					"ERROR...The sorted list does not contain the same elements that the original list does...");
			return false;
		}
		
		return true;
	}
}
