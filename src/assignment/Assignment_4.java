package assignment;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Assignment_4 {

	
//	i)Write a Java program to reverse elements in a array list?
	protected static void reverseArray(ArrayList<String> ar){
		
//		find the midpoint index of the arraylist.
		int mid = (int)(Math.ceil(ar.size()/2));
//		swap value at each end with each other, until the midpoint.
		for (int x = 0; x < mid; x++) {
//			value of the head.
			String temp_value = ar.get(x);
//			index starting from the end of the arraylist.
			int z = ar.size() -1 - x;
//			swap value from the back to the head.
			ar.set(x, ar.get(z));
//			vice versa.
			ar.set(z, temp_value);
		}
		for (String t : ar) {			
			System.out.print (t + "  ");
		}
		
	}
//	ii) Write a Java program of swap two elements in an array list?
	protected static void swapElement(ArrayList<String> ar, int first_index, int second_index) {
//		check if index within bound
		if (first_index < 0 || first_index >= ar.size() || second_index < 0 || second_index >= ar.size()) {
			System.out.print("Error in input");
		}
		else {
//			value of the head.
			String temp_value = ar.get(first_index);
//			swap value from the back to the head.
			ar.set(first_index, ar.get(second_index));
//			vice versa.
			ar.set(second_index, temp_value);
			for (String t : ar) {			
				System.out.print (t + "  ");
			}
		}
		
	}
	
//	iii)Write a Java program to iterate through all elements in a linked list starting at the specified position?
	protected static void iterateList(LinkedList<String> list, int starting_index) {
		if (starting_index < 0 || starting_index >= list.size()) {
			System.out.print("Error in input");
		}
		else {
			System.out.println("\nList start from " + starting_index);
			Iterator<String> i = list.iterator();
//			iterate through list, only print value when index reach starting index.
			for (int x = 0; i.hasNext(); x++) {
				if (x >= starting_index) {
					System.out.print(i.next() + "  ");
				}
				else {
					i.next();
				}
			}
		}
	}
	
//	iv)Write a Java program to replace an element in a linked list?
	protected static void replaceElement(LinkedList<String> list, int index, String new_value) {
		if (index < 0 || index >= list.size()) {
			System.out.print("Error in input");
		}
		else {
			System.out.print("\nAfter version: ");
			Iterator<String> i = list.iterator();
			for (int x = 0; i.hasNext(); x++) {
				if (x == index) {
					list.set(x, new_value);
				}
				System.out.print(i.next() + "  ");
			}
		}
	}
	
	
//	v)Write a Java program to convert a hash set to an array?
	public static void convertToArray(HashSet<String> test) {
		String[] ar = new String[test.size()];
		Iterator i = test.iterator();
		for (int x = 0; x < ar.length; x++) {
			ar[x] = (String)i.next();
		}
		System.out.print("Array version" + Arrays.toString(ar));
	}
	
	public static void main (String[] args) {
//		uncomment to test prompt 1 and 2.
		ArrayList<String> test = new ArrayList<>();
		test.add("First");test.add("Second");test.add("Third");test.add("Fourth");test.add("Fifth");
//		System.out.print ("Before version: ");
//		for (String t : test) {			
//			System.out.print (t + "  ");
//		}
//		System.out.print ("\nAfter version: ");
//		reverseArray(test);
//		swapElement(test, 2,4);
		
		
//		Uncomment to test prompt 3 and 4.
		LinkedList<String> list_test = new LinkedList<>();
		list_test.add("First");list_test.add("Second");list_test.add("Third");list_test.add("Fourth");list_test.add("Fifth");
//		System.out.print ("Orginial version: ");
//		Iterator i = list_test.iterator();
//		do {
//			System.out.print(i.next() + "  ");
//		}while (i.hasNext());
//		iterateList(list_test,2);
//		replaceElement(list_test,2,"New Value");
		
		
//		Uncomment to test prompt 5.
		HashSet<String> hash_test = new HashSet<>();
		hash_test.add("First");hash_test.add("Second");hash_test.add("Third");hash_test.add("Fourth");hash_test.add("Fifth");		
//		System.out.print ("Orginial version: ");
//		for(String t: hash_test) {
//			System.out.print(t +  "   ");
//		}
//		convertToArray(hash_test);
	}
}
