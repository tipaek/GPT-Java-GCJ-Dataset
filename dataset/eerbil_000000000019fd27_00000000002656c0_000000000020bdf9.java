import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numCases = Integer.parseInt(in.nextLine());
	    String[] res = new String[numCases];
	    for(int i = 0; i < numCases; i++) {
	    	int[] p1 = new int[24*60];
	    	int[] p2 = new int[24*60];
	    	int numActivities = in.nextInt();
	    	int[] start = new int[numActivities];
	    	int[] end = new int[numActivities];
	    	
	    	for(int j = 0; j < numActivities; j++) {
	    		start[j] = in.nextInt();
	    		end[j] = in.nextInt();
	    	}
	    	
	    	String result = "";
	    	for(int j = 0; j < numActivities; j++) {
	    		if(!result.equals("IMPOSSIBLE")) {
		    		if(isEmpty(p1, start[j], end[j])) {
		    			change(p1, start[j], end[j]);
		    			result+="C";
		    		} else if (isEmpty(p2, start[j], end[j])) {
		    			change(p2, start[j], end[j]);
		    			result+="J";
		    		} else {
		    			result = "IMPOSSIBLE";
		    		}
	    		}
	    	}
	    	if(!result.equals("IMPOSSIBLE") && result.length()!=numActivities) {
	    		throw new RuntimeException("");
	    	}
	    	res[i] = result;
	    } 
	    
	    for(int i = 0; i < numCases; i++) {
	    	System.out.println("Case #"+ (i+1) +": "+res[i]);
	    }
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
			arr[i] += 1;
			if(arr[i]>1) {
	    		throw new RuntimeException("");
	    	}
		}
		return arr;
	}
}