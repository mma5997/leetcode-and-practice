package com.practice.company.arcesium;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/product-of-the-maximums-of-all-subsets-of-an-array/
 * https://leetcode.com/discuss/interview-question/1430807/ArcesiumorSSEorHyderabadorOffer
 */
public class ProductOfMaxOfAllSubsets {
	public static final long MOD_CONST = 1000000007;

	public static long getMax(int[] arr) {
		long result = 1;
		// STEP 1 - Sort the i/p array
		Arrays.sort(arr);

		// STEP 2 - Pre calculate powers of 2 for each i ranging from 0 to arr.length-1
		long[] powerOfTwo = getPowerOfTwo(arr.length);

		// STEP 3 - The arr[i] number will be ending up as maximum in power[i] times
		// from all of the subsets
		// So calculate the result by multiplying the arr[i] that many times
		// Repeat this for each of the elements in arr BUT NOT TILL 0th
		// The reason being 0th elem will be maximum only once
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j <= powerOfTwo[i] - 1; j++) {
				result = ((result % MOD_CONST) * arr[i]) % MOD_CONST;
			}
		}

		// result = ((result % MOD_CONST) * arr[0]) % MOD_CONST;

		return result;
	}

	public static long[] getPowerOfTwo(int size) {
		long[] powerOfTwo = new long[size];
		long val = 1;
		powerOfTwo[0] = val;
		for (int i = 1; i < size; i++) {
			val = (2 * (val % MOD_CONST)) % MOD_CONST;
			powerOfTwo[i] = val;
		}
		return powerOfTwo;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3 };
		System.out.println(getMax(arr));
	}
}
