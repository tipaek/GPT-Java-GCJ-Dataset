
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numCases = Integer.parseInt(in.nextLine());
	    String[] res = new String[numCases];
	    for(int i = 0; i < numCases; i++) {
	    	int[] p1 = new int[1440];
	    	int[] p2 = new int[1440];
	    	
	    	int numActivities = in.nextInt();
	    	int[] start = new int[numActivities];
	    	int[] end = new int[numActivities];
	    	TreeMap<Integer, Integer> sorted = new TreeMap<>();
	    	
	    	for(int j = 0; j < numActivities; j++) {
	    		start[j] = in.nextInt();
	    		end[j] = in.nextInt();
	    		sorted.put(start[j], j);
	    	}
	    	int[] sortedStart = new int[numActivities];
	    	int[] sortedEnd = new int[numActivities];
	    	
	    	int count = 0; 
	    	for(int a : sorted.values()) {
	    		sortedStart[count]=start[a];
	    		sortedEnd[count]=end[a];
	    		count++;
	    	}
	    
	    	
	    	String result = "";
	    	for(int j = 0; j < numActivities; j++) {
	    		if(!result.equals("IMPOSSIBLE")) {
		    		if(isEmpty(p1, sortedStart[j], sortedEnd[j])) {
		    			change(p1, sortedStart[j], sortedEnd[j]);
		    			result+="C";
		    		} else if (isEmpty(p2, sortedStart[j], sortedEnd[j])) {
		    			change(p2, sortedStart[j], sortedEnd[j]);
		    			result+="J";
		    		} else {
		    			res[i] = "IMPOSSIBLE";
		    			result = "IMPOSSIBLE";
		    		}
	    		}
	    	}
	    	ArrayList<Integer> list = new ArrayList<>();
	    	
	    	Object[] arr = sorted.values().toArray();
	    	
	    	
    	    	for(int j = 0; j<numActivities; j++) {
    	    	    if (sorted.values().toArray()[j] instanceof Integer)
                    {
    	    		list.add((int)sorted.values().toArray()[j]);
    	    	
                    } 
                    }
	    	
	    	String finalResult = "";
	    	if(!result.equals("IMPOSSIBLE")) {
		    	for(int j = 0; j < numActivities; j++) {
		    	    if(list.indexOf(j)!=-1){
		    	        finalResult+=result.charAt(list.indexOf(j));
		    	    } else {
		    	        finalResult+="C";
		    	    }
		    	}
		    	res[i] = finalResult;
	    	}
	    	else {
	    		res[i] = "IMPOSSIBLE";
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
	
	public static boolean change(int[] arr, int s, int e) {
		for(int i=s; i<e; i++) {
			arr[i] += 1;
			if(arr[i]>2) {
	    		return false;
	    	}
		}
		
		return true;
	}
}