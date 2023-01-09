// Name: Nithil Suresh
// Computing ID: anh6ee@virginia.edu
// Homework Name: Implementing Sorting Algorithms 
package sorting;

public class SortingAlgorithms {

	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static <T> void swap(T[] list, int i, int j) {
		if (i < 0 || i >= list.length)
			return;
		if (j < 0 || j >= list.length)
			return;
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	// ####################
	// ## INSERTION SORT ## ----------------------------------------------------------------------
	// ####################
	// ## IMPORTANT: the code we've given you below has a small bug!
	// ##   You will need to look at this code and/or test, and fix the bug.
	// ####################
	/**
	 * Usually a slow sorting algorithm. Insertion sort. 
	 * @param list - An array of items
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] list) {
		for (int i = 1; i < list.length; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= 0 && val.compareTo(list[j]) < 0) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = val;
		}
	}
	
	
	// ################
	// ## MERGE SORT ## ----------------------------------------------------------------------
	// ################	
	/**
	 * Recursive Merge sort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * 
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		//TODO: write the body of this method
		int listLength = j+1;
		if( listLength < 2 ) {
			return;
		}
		int mid = listLength / 2;
		T [] leftHalf = (T[]) new Comparable [mid];
		T [] rightHalf = (T[]) new Comparable [listLength - mid];
		for(int a = 0; a < mid; a++) {
			leftHalf[a] = list[a];
		}
		for(int b = mid; b < listLength; b++) {
			rightHalf[b - mid] = list[b];
		}
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		merge(list, leftHalf, rightHalf);

	}
	
	/**
	 * Merge method for Merge Sort algorithm.
	 * Your mergeSort algorithm will call this method as appropriate to do the merging.
	 * @param list - An array of items
	 * @param i - lower bound index
	 * @param mid - middle index
	 * @param j - upper bound index 
	 */
	public static<T extends Comparable<T>> void merge(T[] list, T[]leftList, T[]rightList) {
		int leftSize = leftList.length;
		int rightSize = rightList.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while( i < leftSize && j < rightSize ) {
			if( leftList[i].compareTo(rightList[j]) <= 0 ) {
				list[k] = leftList[i];
				i++;
			}
			else {
				list[k] = rightList[j];
				j++;
			}
			k++;
		}
		while( i < leftSize ) {
			list[k] = leftList[i];
			i++;
			k++;
		}
		while( j < rightSize ) {
			list[k] = rightList[j];
			j++;
			k++;
		}
	}
	public static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		//TODO: write the body of this method
		
		//Reminder: when using a generic type, to create a new array to hold items of type T,
		//  you do something like the following:
		@SuppressWarnings("unchecked")
		T[] merged = (T[]) new Comparable[j-i+1]; // space for new merged list to hold (sorted) sublist
//		int leftSize =  mid - i;
//		int rightSize = j - mid +1;
//		int a_ptr = i;
//		int b_ptr = mid;
//		int merged_ptr = 0;
//		while( a_ptr < mid && b_ptr < j) {
//			if( (int)list[a_ptr] <= (int) list[b_ptr]) {
//				merged[merged_ptr] = list[a_ptr];
//				a_ptr++;
//			}
//			else {
//				merged[merged_ptr] = list[b_ptr];
//				b_ptr++;
//			}
//			merged_ptr++;
//		}
//		while ( a_ptr < mid ) {
//			merged[merged_ptr] = list[a_ptr];
//			merged_ptr++;
//			a_ptr++;
//		}
//		while( b_ptr < j ) {
//			merged[merged_ptr] = list[b_ptr];
//			merged_ptr++;
//			b_ptr++;
//		}
//		while( a_ptr < mid && b_ptr < j) {
//			if( (int)list[a_ptr] <= (int)list[b_ptr]) {
//				merged[merged_ptr] = list[a_ptr];
//				a_ptr++;
//			}
//			else {
//				merged[merged_ptr] = list[b_ptr];
//				b_ptr++;
//			}
//			merged_ptr++;
//		}
//		while( a_ptr < mid ) {
//			merged[merged_ptr] = list[a_ptr];
//			merged_ptr++;
//			a_ptr++;
//		}
//		while( b_ptr < j ) {
//			merged[merged_ptr] = list[b_ptr];
//			merged_ptr++;
//			b_ptr++;
//		}
	}

	
	// ###############
	// ## QUICKSORT ## ----------------------------------------------------------------------
	// ###############	
	/**
	 * Recursive Quicksort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * >>> Use any partition scheme that you like. 
	 * 
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		//TODO: write the body of this method
		if( i >= j ) {
			return;
		}
		T p = list[j];
		//int pivot = (int) p;
		int leftPointer = i;
		int rightPointer = j;
		while ( leftPointer < rightPointer ) {
			while( list[leftPointer].compareTo(p) <= 0 && leftPointer < rightPointer) {
				leftPointer++;
			}
			while ( list[rightPointer].compareTo(p) >= 0 && leftPointer < rightPointer) {
				rightPointer--;
			}
			swap(list, leftPointer, rightPointer);
		}
		swap(list, leftPointer, j);
		quickSort(list, i, leftPointer -1);
		quickSort(list, leftPointer+1, j);
	}
	
	/**
	 * Partition method for Quicksort - Use any valid partition algorithm that you like.
	 * Your quickSort algorithm will call this method as appropriate to do the partitioning.
	 * @param list - An array of items
	 * @param i - lower bound
	 * @param j - upper bound
	 */
	public static<T extends Comparable<T>> int partition(T[] list, int i, int j) {	
		//TODO: write the body of this method
		return 0; // be sure to return the right value and not 0
		
		
	}
	
	//=================================================================================
	
	public static void main(String[] args) {
		// TODO:  If you wish to do your own kind of testing
		
	}

}