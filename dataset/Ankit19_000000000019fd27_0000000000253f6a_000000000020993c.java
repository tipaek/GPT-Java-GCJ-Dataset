/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Solution {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		int r = 1;
		while(r<=t) {
		    int n = s.nextInt();
		    int arr[][] = new int[n][n];
		    int sum = 0;
		    for (int i =0 ;i<n ; i++) {
		        for (int j = 0 ; j<n ;j++) {
		            
		            arr[i][j] =s.nextInt();
		            if(i==j) {
		                sum = sum+arr[i][j];
		            }
		        }
		    }
		    int row = checkrow(arr);
		    int col = checkcol(arr);
		    System.out.println("Case #"+r+": "+sum+" "+row+" "+col);
		    
		    r++;
		}
	}
    static int checkrow  (int arr[][]) {
        int count  = 0;
	    for (int  i =0 ; i<arr.length ; i++) {
	       HashSet<Integer> hs = new HashSet();
	       int flag = 0;
	       for (int j = 0 ; j<arr.length ;j++) {
	           if(!hs.contains(arr[i][j])) {
	               hs.add(arr[i][j]);
	           }
	           else {
	                flag=1;
	               break;
	           }
	       }
	        if(flag==1) 
	       count++;
	    }
	    return count;
	}
	static int checkcol  (int arr[][]) {
        int count  = 0;
	    for (int  i =0 ; i<arr.length ; i++) {
	       HashSet<Integer> hs = new HashSet();
	       int flag = 0;
	       for (int j = 0 ; j<arr.length ;j++) {
	           if(!hs.contains(arr[j][i])) {
	               hs.add(arr[j][i]);
	           }
	           else {
	               flag=1;
	               break;
	           }
	       }
	       if(flag==1) 
	       count++;
	    }
	    return count;
	}
}