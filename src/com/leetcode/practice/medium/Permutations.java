package com.leetcode.practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem
 * <a href="https://leetcode.com/problems/permutations/">Permutations</a>
 * 
 * @author mautade
 *
 */
public class Permutations {

	public static void main(String[] args) {
		Permutations pm = new Permutations();
		int nums[] = {1,2,3};
		pm.permute(nums);
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutationsList = new ArrayList();
		List<Integer> onePermutationElement = new ArrayList();
		backTrack(permutationsList, onePermutationElement, nums);
		return permutationsList;
	}

	public void backTrack(List<List<Integer>> permutationsList, List<Integer> onePermutationElement, int[] nums) {
		if (nums.length == onePermutationElement.size()) {
			permutationsList.add(new ArrayList<Integer>(onePermutationElement));
		} else {
			for (int i=0; i<nums.length; i++) {
				if(onePermutationElement.contains(nums[i]))
					continue;
				onePermutationElement.add(nums[i]);
				backTrack(permutationsList, onePermutationElement, nums);
				onePermutationElement.remove(i);
			}
		}
	}
}
