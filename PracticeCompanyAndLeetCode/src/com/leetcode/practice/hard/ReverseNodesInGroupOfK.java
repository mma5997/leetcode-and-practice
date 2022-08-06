package com.leetcode.practice.hard;

import com.leetcode.practice.shared.ListNode;

/*
 * LeetCode | Hard | https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInGroupOfK {
	/*
	 * Pair class to encapsulate start and end nodes of group/batch
	 */
	private class Pair {
		ListNode start;
		ListNode end;

		Pair(ListNode start, ListNode end) {
			this.start = start;
			this.end = end;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1)
			return head;
		ListNode rightEnd = head;
		ListNode leftEnd = head;
		int count = k;
		boolean firstSwapEnded = false;
		Pair prevPair = null, currPair = null;

		while (count != 0) {
			rightEnd = rightEnd.next;
			count--;
		}

		do {
			count = k;
			currPair = reverse(leftEnd, rightEnd);
			if (prevPair == null) {
				prevPair = currPair;
			} else {
				// Linking the last batch/group with the current batch.
				prevPair.end.next = currPair.start;
				prevPair = currPair;
			}
			leftEnd = rightEnd;
			if (firstSwapEnded == false) {
				// Updating the head of the final list to be returned.
				firstSwapEnded = true;
				head = currPair.start;
			}
			while (count != 0) {
				if (rightEnd == null) {
					// When total number of elements aren't multiple of k
					currPair.end.next = leftEnd;
					return head;
				}
				rightEnd = rightEnd.next;
				count--;
			}

			if (count == 0 && rightEnd == null) {
				// Total number of elements are multiple of k
				// Also note that leftEnd was earlier updated with last rightEnd
				Pair lastBatchPair = reverse(leftEnd, null);
				currPair.end.next = lastBatchPair.start;
			}

		} while (rightEnd != null);

		return head;
	}

	public Pair reverse(ListNode start, ListNode end) {
		ListNode back = start, mid = back.next, front = mid.next;
		back.next = null;
		do {
			mid.next = back;
			back = mid;

			if (front != null) {
				mid = front;
				front = front.next;
			} else
				break;

		} while (mid != end);

		// Returns back the new start and end of the reversed batch/group.
		return new Pair(back, start);
	}

	public static void main(String[] args) {
		ListNode start = new ListNode(1, null), curr = null, back = start;
		for (int i = 2; i <= 10; i++) {
			curr = new ListNode(i, null);
			back.next = curr;
			back = curr;
		}

		ReverseNodesInGroupOfK obj = new ReverseNodesInGroupOfK();
		ListNode finalList = obj.reverseKGroup(start, 2);
		System.out.println("Done");
	}
}
