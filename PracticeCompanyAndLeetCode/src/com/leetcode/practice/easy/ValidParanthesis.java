package com.leetcode.practice.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @Problem https://leetcode.com/problems/valid-parentheses/submissions/
 */
public class ValidParanthesis {

	public static Character OPENING_CIRLE  = '(';
	public static Character OPENING_CURLY  = '{';
	public static Character OPENING_SQUARE = '[';
	public static Character CLOSING_CIRLE  = ')';
	public static Character CLOSING_CURLY  = '}';
	public static Character CLOSING_SQUARE = ']';

	public static boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < s.length(); i++) {
			Character ch = new Character(s.charAt(i));
			if ((ch.equals(OPENING_CIRLE)) || (ch.equals(OPENING_CURLY)) || (ch.equals(OPENING_SQUARE)))
				stack.push(ch);
			else if ((ch.equals(CLOSING_CIRLE)) || (ch.equals(CLOSING_CURLY)) || (ch.equals(CLOSING_SQUARE))) {
				if ((ch.equals(CLOSING_CIRLE) && stack.peek().equals(OPENING_CIRLE))
						|| (ch.equals(CLOSING_CURLY) && stack.peek().equals(OPENING_CURLY))
						|| (ch.equals(CLOSING_SQUARE) && stack.peek().equals(OPENING_SQUARE))) {
					stack.pop();
					continue;
				} else
					return false;
			}
		}

		if (stack.peek() != null)
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("(]"));
	}

}
