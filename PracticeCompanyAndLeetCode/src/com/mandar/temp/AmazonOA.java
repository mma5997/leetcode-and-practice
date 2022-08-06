package com.mandar.temp;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AmazonOA {

	public static void main(String[] args) {
		List<Integer> rank = new ArrayList<Integer>();
		rank.add(1);
		rank.add(-1);
		rank.add(-1);
		rank.add(-1);
		rank.add(1);
		rank.add(1);

		//findTotalImbalance(rank);
		System.out.println(maxSubarrayLength(rank));
	}

	public static long findTotalImbalance(List<Integer> rank) {
		long imbalance = 0;
		int total_students = rank.size();
		if (total_students < 2)
			return 0;

		for (int group_count = 2; group_count <= total_students; group_count++) {
			for (int start_group_index = 0; start_group_index < total_students - group_count; start_group_index ++) {
				int index = start_group_index;

				List<Integer> sorted_ranks = new ArrayList<>();

				while (index < start_group_index + group_count) {
					sorted_ranks.add(rank.get(index));
					index++;
				}

				Collections.sort(sorted_ranks);

				index = 1;
				while (index < group_count) {
					if (sorted_ranks.get(index) - sorted_ranks.get(index - 1) > 1)
						imbalance++;
					index++;
				}
			}
		}

		return imbalance;
	}
	
	public static int maxSubarrayLength(List<Integer> badges) {
	    // Write your code here
	        int res_len = 0;
	        for(int size = 2; size < badges.size(); size ++) {
	            for(int i=0; i<=badges.size() - size ; i++) {
	                int mul=1;
	                for(int j = i; j< i+size; j++){
	                    mul*=badges.get(j);
	                }
	                if(mul==1 && size>res_len) {
	                    res_len = size;
	                    break;
	                }
	            }
	        }
	        return res_len;
	    }

}
