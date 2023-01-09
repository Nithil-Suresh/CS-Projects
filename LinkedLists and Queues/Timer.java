package tester;

import java.util.ArrayList;
import java.util.Random;

import tester.TimerExample.Method;

public class Timer {
	
	public enum Methods{
		InsertAtTail, InsertAtHead, InsertAt, Insert, RemoveAtTail, RemoveAtHead, Remove, Find, Get
	}
	
	public static void main(String[] args) {

		int listSize = 1000000; // size of our list
		int numRuns = 10000; // how many times our method will be run to do the test
		System.out.println("Timing methods. List size = " + listSize + "  Number of runs = " + numRuns);

		// Below two loops are shown you can use. One times all the methods in the enum, the other times
		// specified methods. One is commented out here.  Choose which one you need and (un)comment appropriately.

		// this loop times all the methods
//		for (Methods m : Methods.values()) {
//			long t = timeMethod(m, listSize, numRuns); // our method times a given method on list
//			System.out.println("Time for " + m + ": " + t + " ms");
//		}

		// this loop times only the specified methods in the array created below
		Methods[] mList = { Methods.InsertAtTail, Methods.InsertAtHead, Methods.Insert, Methods.RemoveAtTail, Methods.RemoveAtHead, Methods.Remove, Methods.Find}; // update this to have only methods you want to time
		//Methods[] mList = {Methods.InsertAt, Methods.Get, Methods.Find };
		for ( Methods m : mList )  {			
			long t = timeMethod(m, listSize, numRuns);
			System.out.println( "Time for " + m + ": " + t);
		}

	}
	

	/*
	 * Creates a list of random non-negative Integers, then runs the given method on
	 * that list. Repeatedly runs the method the specified number of times. Times
	 * all the runs and returns that time.
	 */
	private static long timeMethod(Methods m, int listSize, int numRuns) {

		// create a list of random Integers between 0 and maxValue
		int maxValue = 1000;
		list.LinkedList<Integer> intList = new list.LinkedList<Integer>();  // note: here we say java.util.List in case student's List interface is present too
		//java.util.List<Integer> intList = new java.util.LinkedList<>();  // if you're curious, replace previous line with this one and compare times

		Random random = new Random();
		for (int i = 0; i < listSize; ++i) {
			intList.insertAtHead(random.nextInt(maxValue + 1));
		}

		Integer item; // used for a return value for list operations
		list.ListIterator iterator1 = new list.ListIterator(intList.getHead());
		list.ListIterator iterator2 = new list.ListIterator(intList.getHead().getNext());
		long startTime = System.currentTimeMillis(); // get timer when we start

		for (int i = 0; i < numRuns; ++i) {
			// Call each method identified by an enum value. Add code to call any methods
			// you add as a new case to the switch in this timing analysis. Otherwise they'll
			// be ignored and not timed
			switch (m) {
			case InsertAtTail:
				intList.insertAtTail(random.nextInt(maxValue + 1));
				break;
			case InsertAtHead:
				intList.insertAtHead(random.nextInt(maxValue + 1));
				break;
			case InsertAt:
				intList.insertAt(random.nextInt(intList.size()), random.nextInt(maxValue + 1));
				break;
			case Insert:  // does not matter where the iterator is, no for loop :D
				intList.insert(iterator1 , random.nextInt(maxValue + 1));
				break;
			case RemoveAtHead:
				item = intList.removeAtHead(); // for Java Lists, this is like removeAtHead for our Lists
				break;
			case RemoveAtTail:
				item = intList.removeAtTail(); // for Java Lists, this is like removeAtTail for our Lists
				break;
			case Remove:
				intList.remove(iterator2);
				break;
			case Find:
				item = intList.find(random.nextInt(maxValue+1));
				break;
			case Get:
				item = intList.get(random.nextInt(intList.size()));
				break;
//			default:
////				System.out.println("Warning: no code present that times method " + m); // prints every run, so...
//				; // ...let's quietly ignore this situation.  (FYI a ; by itself is a "null statement", does nothing
			}
		}
		long elapsedTime = System.currentTimeMillis() - startTime; // get end time and subtract
		return elapsedTime;
	}

}
