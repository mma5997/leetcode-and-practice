package com.practice.company.arcesium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HydrateTheNode {

	public static void main(String[] args) {
		System.out.println(hyderatedtheNode(new int[] { -1, 0, 1 }, new int[] { -1, -1, -1 }, 3, 5) == 0);
		System.out.println(hyderatedtheNode(new int[] { -1, 0, 0 }, new int[] { 1, -1, -1 }, 10, 15) == 10);
		System.out.println(hyderatedtheNode(new int[] { -1, 0, 0, 1 }, new int[] { 0, 0, 0, 0 }, 10, 15) == 0);
		System.out.println(hyderatedtheNode(new int[] { -1, 0, 1, 0, 1, 2, 2, 2, 5, 5 },
				new int[] { -1, -1, 0, -1, 0, 0, 1, 0, 0, 1 }, 2, 3) == 4);
	}

	public static int hyderatedtheNode(int[] parent, int[] water, int oh, int uh) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < parent.length; i++) {
			map.putIfAbsent(parent[i], new ArrayList<Integer>());
			map.get(parent[i]).add(i);
		}
		int[][] waterLevel = new int[parent.length][2];
		for (int[] arr : waterLevel) {
			Arrays.fill(arr, -1);
		}
		dfs(0, waterLevel, water, map);

		int ifNoWater = waterLevel[0][0] * oh + waterLevel[0][1] * uh;
		int globalMin = ifNoWater;
		for (int i = 0; i < parent.length; i++) {
			int currMax = 0;
			currMax -= waterLevel[i][1] * uh;
			globalMin = Math.min(globalMin, (ifNoWater + currMax));
		}
		return globalMin;
	}

	private static int[] dfs(int node, int[][] waterLevel, int[] water, Map<Integer, List<Integer>> map) {
		int[] total = new int[2];
		total[0] = 0; // oh
		total[1] = 0; // uh
		if (water[node] > 0) {
			total[0] += 1;
		} else if (water[node] < 0) {
			total[1] += 1;
		}

		if (waterLevel[node][0] != -1) {
			return waterLevel[node];
		}
		if (map.get(node) != null) {
			for (int i : map.get(node)) {
				int[] temp = dfs(i, waterLevel, water, map);
				total[0] += temp[0];
				total[1] += temp[1];
			}
		}

		waterLevel[node] = total;
		return total;
	}
}
