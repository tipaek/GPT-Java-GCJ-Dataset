package codejam2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numCases = Integer.parseInt(in.nextLine());
	    String[] res = new String[numCases];
	    for(int i = 0; i < numCases; i++) {
	    	res[i] ="";
	    	int[] p1 = new int[1440];
	    	int[] p2 = new int[1440];
	    	int numActivities = in.nextInt();
	    	int[] start = new int[numActivities];
	    	int[] end = new int[numActivities];
	    	for(int j = 0; j < numActivities; j++) {
	    		start[j] = in.nextInt();
	    		end[j] = in.nextInt();
	    	}
	    	
	    	for(int j = 0; j < numActivities; j++) {
	    		if(isEmpty(p1, start[j], end[j])) {
	    			p1 = change(p1, start[j], end[j]);
	    			res[i]+="C";
	    		} else if (isEmpty(p2, start[j], end[j])) {
	    			p2 = change(p2, start[j], end[j]);
	    			res[i]+="J";
	    		} else {
	    			res[i] = "IMPOSSIBLE";
	    			break;
	    		}
	    	}
	    } 
	    
	    for(int i = 0; i < numCases; i++) {
	    	System.out.println("Case #"+ (i+1) +": "+res[i]);
	    }
	    in.close();
	}
	
	public static boolean isEmpty(int[] arr, int s, int e) {
		for(int i=s; i<e; i++) {
			if(arr[i]>0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] change(int[] arr, int s, int e) {
		for(int i=s; i<e; i++) {
			arr[i] = 1;
		}
		return arr;
	}
}
