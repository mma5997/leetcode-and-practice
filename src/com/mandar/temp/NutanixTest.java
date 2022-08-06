package com.mandar.temp;
import java.util.*;
import java.io.*;
import java.lang.*;

public class NutanixTest {

	public NutanixTest() {
		// TODO Auto-generated constructor stub
	}
	
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = 1;//sc.nextInt();
        
        while(t-- > 0) {
            int A =1;//sc.nextInt();
            int B =10;//sc.nextInt();
            int C =2;//sc.nextInt();
            int D =4;//sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int A, int B, int C, int D) { 
        //code here
        int count=0;
        while (A*B > C*D) {
        	
        	if (A==1) {
        		if (B==1)
        			return count;	//which will not come here IMO
        		else {
        			B/=2;
        			count++;
        			continue;
        		}
        	}
        	
        	if (B==1) {
        		if (A==1)
        			return count;	//which will not come here IMO
        		else {
        			A/=2;
        			count++;
        			continue;
        		}
        	}
        	
        		
            if ((A/2 * B) > (A* B/2))
                B/=2;
            else
                A/=2;
            count++;
        }
        
        if ((A*B < C*D) && ((A>C && A>D) || (B>C && B>D))) {
            if ((A>C && A>D) /*&& (B<D && B<C)*/) {
                while (A>C && A>D) {
                    A/=2;
                    count++;
                }
            } else if ((B>C && B>D) /*&& (A<D && A<C)*/) {
                while (B>C && B>D) {
                    B/=2;
                    count++;
                }
            }
        }
        
        return count;
    }

}
