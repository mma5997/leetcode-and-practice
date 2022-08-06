package com.leetcode.practice.easy;
/**
 * Problem <a href="https://leetcode.com/problems/longest-common-prefix/">LongestCommonPrefix </a>
 * TODO: need to make the logic simple
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String input[] = { "flower", "flow", "flight" };
		System.out.println("Longest Common Prefix : " + lcp.longestCommonPrefix(input));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 1)
			return strs[0];

		StringBuilder prefix = new StringBuilder();

		int len = strs[0].length() > strs[1].length() ? strs[1].length() : strs[0].length();
		for (int i = 0; i < len; i++) {
			if (strs[0].charAt(i) == strs[1].charAt(i))
				prefix.append(strs[0].charAt(i));
			else
				break;
		}

		if (prefix.length() == 0) {
			return "";
		} else {
			for (int j = 2; j < strs.length; j++) {
				boolean start = false, brokeFromLoop = false;
				int innerLen = strs[j].length() > prefix.length() ? prefix.length() : strs[j].length();
				if (innerLen == 0)
					return "";
				for (int index = 0; index < innerLen; index++) {
					if (strs[j].charAt(index) != prefix.charAt(index)) {
						if (start == false)
							return "";
						else {
							prefix = prefix.delete(index, prefix.length());
							brokeFromLoop = true;
							break;
						}
					}

					if (index == 0)
						start = true;
				}

				if (!brokeFromLoop && innerLen < prefix.length()) {
					prefix = prefix.delete(innerLen, prefix.length());
				}
			}
		}
		return prefix.toString();
	}

}
