package com.mandar.temp;

public class ShiftOperator {
	public static void main(String[] arg) {
		// 2^0 
		System.out.println(1<<0);	// 01	--> 01		--> 1
		// 2^1
		System.out.println(1<<1);	// 01	--> 010		--> 2
		// 2^2
		System.out.println(1<<2);	// 01 	--> 0100	--> 4
		
		System.out.println("=====");
		
		// power set for 2 elements in a SampleSet will have 2^2 elements(2^numberOfElementsInSampleSet)
		// ex SampleSet: {a,b} then PowerSet: {{},{a},{b},{a,b}}
		System.out.println(1 & (1<<0));	// 01 & 01  	--> 01	--> 0th index --> a
		System.out.println(1 & (1<<1));	// 01 & 10  	--> 00 
		System.out.println(1 & (1<<2));	// 001 & 100 	--> 000
		System.out.println(1 & (1<<3));	// 0001 & 1000 	--> 000
		
		
		System.out.println(2 & (1<<0));	// 10 & 01  	--> 00
		System.out.println(2 & (1<<1));	// 10 & 10  	--> 10	--> 1st index --> b
		System.out.println(2 & (1<<2));	// 010 & 100 	--> 000
		System.out.println(2 & (1<<3));	// 0010 & 1000 	--> 000
		
		System.out.println(3 & (1<<0));	// 11 & 01  	--> 01	--> 0th index --> a
		System.out.println(3 & (1<<1));	// 11 & 10  	--> 10	--> 1st index --> b
		System.out.println(3 & (1<<2));	// 011 & 100 	--> 000
		System.out.println(3 & (1<<3));	// 0011 & 1000 	--> 0000
		
		
		
		System.out.println("=====");
		
		System.out.println(5<<1);	// 101 	--> 1010	--> 10
		System.out.println(5<<2);	// 101 	--> 10100	--> 20
		System.out.println(5<<3);	// 101 	--> 101000	--> 40
		
	}
}
