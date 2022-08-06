package com.practice.company.arcesium;
/*
 * https://leetcode.com/discuss/interview-question/1346478/arcesium-online-assessment-sse-role-july-2021
 */
public class WierdStock {
	public static int func(int n, int m, int count) {
		if (n == m)
			return count;
		else if (n > m) {
			// just return the diff by which n exceeds m
			// no need to recursive call this and increase the stack computations
			return (count + n - m);
			// return func(--n, m, ++count);
		} else {
			// ...n...m/2...m
			if (n <= (m / 2)) {
				// keep doubling until crosses m/2
				return func(n * 2, m, ++count);
			} else {
				// ...m/2...n...m
				// so n is between m/2 and m and we have 2 ways as below
				if ((n - (m / 2) + 1) < (2 * n + 1 - m)) {
					// ...m/2..n....m
					// so will keep minusing 1 until matches m/2 and then double
					return (count + n - (m / 2) + 1);
				} else {
					// ...m/2....n..m
					// so will double and then keep minusing 1
					// TBH I don't think this is possible because usually the gap widens on doubling
					// best option always falls for the way above.
					return (2 * n + 1 - m);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(func(4, 20, 0));
	}
}
