package com.leetcode.practice.easy;

/**
 * Problem <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">MinCostClimbingStairs</a>
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int minCost = 0;
        int minCostStairOneBefore = cost[1];
        int minCostStairTwoBefore = cost[0];
        /*
            lets build the minCost for each stair starting with 3rd stair to check whats is the min cost to reach it 
            and then when we find the minCost for 3rd stair, advance to 4th and so on till the last stair.
            Keep in mind to keep track of secondLast stair's minCost, because if its less than the minCost for the last stair,
            then final minCost to be returned is minCost till secondLast stair and not the last one.
        */
        for (int stair = 2; stair < cost.length; stair++) {
            minCost = Math.min(minCostStairOneBefore, minCostStairTwoBefore) + cost[stair];
            minCostStairTwoBefore = minCostStairOneBefore;
            minCostStairOneBefore = minCost;
        }
        minCost = Math.min(minCostStairOneBefore, minCostStairTwoBefore);
        return minCost;
    }
    
    public static void main(String[] args) {
    	MinCostClimbingStairs obj = new MinCostClimbingStairs();
		int[] arr = {1,100,1,1,1,100,1,1,100,1};
		System.out.println(obj.minCostClimbingStairs(arr));
	}
}
