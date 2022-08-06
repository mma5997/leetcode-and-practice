package com.leetcode.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 */
public class TwoSum {
	public TwoSum() {
	}

	public static void main(String[] args) {
		TwoSum test1 = new TwoSum();
		int[] output = test1.twoSum(new int[] {-3,4,3,90}, 0);
		if(output != null)
			System.out.println("Output : " + output[0] + "," + output[1]);
		else
			System.out.println("Output is null");
	}
	
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i=0 ; i < nums.length; i++) {
        	// check if i'th num has a counterpart in map already and return both's indices
            if((numToIndex.get(target - nums[i]) != null) && (numToIndex.get(target - nums[i]) != i)) {
                return new int[] {i, numToIndex.get(target - nums[i])};
            }
            
    		// mapping number to its indices
            numToIndex.put(nums[i], i);
        }
        return null;
    } 

}
