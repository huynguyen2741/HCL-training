package assignment;

import java.util.*;

public class Assignment_2 {
	Scanner s = new Scanner(System.in);
	
	void fibonacciNumber() {
//		get the input from user
		System.out.print("Enter one number: ");
		int limit = s.nextInt();
		
//		previous value of i;;
		int pre = 0;
		
//		display the Fib series.
		for (int i=0; i <limit;) {
			if (i == 0) { 
				System.out.print(i++ + " ");
			}
			else {
				System.out.print(i + " ");
				i += pre;				
				pre = i;
			}
		}
	}
	
	void primeNumber() { 
		System.out.print("Enter number: ");
		int lim = s.nextInt();
//		if less than 2, no prime
		if (lim < 2) {
			System.out.print("no prime number");
		}
		else {
			boolean prime = true;
//			loop through each number
			for (int i = 2; i <= lim ;i++) {
//				check if the number can be divided by any other number
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						prime = false;
						break;
					}
				}	
				if (prime) {
					System.out.print(i + " ");					
				}
				prime =true;
			}
		}
	}
	
	void swapVariables() {
		double  first = 0.32;
		double second = 7.28;
		
		System.out.println("Before: First= " + first + " Second ="+ second);
		
		double old_first = first;
		first = second;
		second = old_first;
		
		System.out.print("After: First= " + first + " Second ="+ second);
	}
	
	void checkSum() {
		int[] list = new int[3];
		
		System.out.print("enter first nuber: ");
		list[0] = s.nextInt();
		
		System.out.print("enter second nuber: ");		
		list[1] = s.nextInt();
		
		System.out.print("enter third nuber: ");
		list[2] = s.nextInt();
		
//		sort the array
		for(int i =1; i< list.length; i++){
			int k = i;
			while(k > 0 && list[k] < list[k-1] ){
				int temp = list[k-1]; 
				list[k-1] = list[k]; 
				list[k] = temp; 
				k--;
			}
		}
		
		int sum = list[0] + list[1];
		String result = sum == list[2] ? "sum equals third": "Not";
		System.out.print(result);
	}
	
	void reverseWord() {
		System.out.print("enter the string: ");
		String input = s.next();
		char [] v = input.toCharArray();
		for (int i = v.length - 1; i >= 0; i--) {
			System.out.print(v[i]);
		}
	}
	
	public static void main(String[] args) {
		Assignment_2 a = new Assignment_2();
//		a.fibonacciNumber();
//		a.primeNumber();
//		a.swapVariables();
//		a.checkSum();
//		a.reverseWord();
	}
}
