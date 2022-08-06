package com.practice.easy;
import com.leetcode.practice.shared.ListNode;
public class MergeTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode five = new ListNode(5);
		ListNode three = new ListNode(3, five);
		ListNode one = new ListNode(1, three);
		
		ListNode five_another = new ListNode(5);
		ListNode four = new ListNode(4, five_another);
		ListNode two = new ListNode(2, four);
		
		MergeTwoLists obj = new MergeTwoLists();
		display(obj.mergeTwoLists(one, two));
	}
	
	public ListNode mergeTwoListsTest(ListNode list1, ListNode list2) {
        ListNode start1 = list1;
        ListNode start2 = list2;

        ListNode trav1 = list1;
        ListNode trav2 = list2;
        
        ListNode finalStart = null;
        
        boolean lastT1Updated = false;
        display(start1, start2);
        ListNode prev1 = null, prev2 = null;
        while (trav1 != null && trav2 != null) {
            if (trav1.val < trav2.val) {
                ListNode nextTrav1 = trav1.next;
                trav1.next = trav2;
                prev2 = trav2;
                prev2.next = null;
                trav2 = trav2.next;
                prev1 = trav1;
                trav1 = nextTrav1;
                trav1.next = null;
                display(start1, start2);
                if(finalStart == null)
                	finalStart = start1;
            } else if (trav1.val > trav2.val) {
                ListNode nextTrav2 = trav2.next;
                trav2.next = trav1;
                prev1 = trav1;
                prev1.next = null;
                trav1 = trav1.next;
                prev2 = trav2;
                trav2 = nextTrav2;
                trav2.next = null;
                display(start1, start2);
                if(finalStart == null)
                	finalStart = start2;
            } else {
            	if(prev1 == null || prev1.next == trav1) {
            		ListNode nextTrav11 = trav1.next;
            		trav1.next = trav2;
            		prev1 = trav1;
            		trav1.next = null;
            		trav1 = nextTrav11;
            		if(finalStart == null)
            			finalStart = start1;
            	} else {
            		ListNode nextTrav22 = trav2.next;
            		trav2.next = trav1;
            		prev2 = trav2;
            		trav2.next = null;
            		trav2 = nextTrav22;
            		if(finalStart == null)
            			finalStart = start2;
            	}
            }
        }
        
        display(start1, start2);
        if (trav1 == null) {
        	if(prev1 != null)
        		prev1.next = trav2;
        	else
        		return start2;
        	return start1;
        } else if(trav2 == null) {
        	if(prev2 != null)
        		prev2.next = trav1;
        	else
        		return start1;
        	return start2;
        }
        
        return null;
    }
    
    public void display(ListNode start1, ListNode start2){
        System.out.println("Start=======================");
        while(start1!=null){
            System.out.println(start1.val + " ");
            start1 = start1.next;
        }
        System.out.println("=======================");
        while(start2!=null){
            System.out.println(start2.val + " ");
            start2 = start2.next;
        }
        System.out.println("End=======================");
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	ListNode startOfResult = null, list3 = null ,iterationNode = null;
    	while(list1!=null && list2!=null) {
    		if (list1.val < list2.val) {
    			iterationNode = list1;
    			list1 = list1.next;
    		} else if (list1.val > list2.val) {
    			iterationNode = list2;
    			list2 = list2.next;
    		} else {
    			ListNode node1 = list1;
				ListNode node2 = list2;
				list1 = list1.next;
				list2 = list2.next;
				
    			if(startOfResult == null) {
    				startOfResult = node1;
    			} else {
    				list3.next = node1;
    			}
    			node1.next = node2;
    			list3 = node2;
    		}
    		
    		if (iterationNode != null) {
    			if (startOfResult == null) {
    				startOfResult = iterationNode;
    				list3 = iterationNode;
    			} else {
    				list3.next = iterationNode;
    				list3 = iterationNode;
    			}
    			iterationNode = null;
    		}
    		
    	}
    	
    	if (list1 != null) {
    		list3.next = list1;
    	}
    	
    	if (list2 != null) {
    		list3.next = list2;
    	}
    	
    	return startOfResult;
    }
    
    public static void display(ListNode start){
        System.out.println("ResultStart=======================");
        while(start!=null){
            System.out.println(start.val + " ");
            start = start.next;
        }
        System.out.println("ResultEnd=======================");
    }

}
