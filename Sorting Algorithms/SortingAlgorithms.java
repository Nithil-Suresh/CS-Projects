// Name: Nithil Suresh
// Project Name: Implementing Sorting Algorithms 
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
	/**
	 * Usually a slow sorting algorithm. Insertion sort. 
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
	 */
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
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

	
	// ###############
	// ## QUICKSORT ## ----------------------------------------------------------------------
	// ###############	
	/**
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
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

}
