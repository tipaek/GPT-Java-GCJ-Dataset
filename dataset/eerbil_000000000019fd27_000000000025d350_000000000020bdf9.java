
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numCases = Integer.parseInt(in.nextLine());
	    String[] res = new String[numCases];
	    for(int i=0; i<res.length; i++) {
	    	res[i] = "";
	    }
	    for(int i = 0; i < numCases; i++) {
	    	int numActivities = Integer.parseInt(in.nextLine());
	    	ArrayList<String> cInterval = new ArrayList<String>();
	    	ArrayList<String> jInterval = new ArrayList<String>();
	    	for(int j=0; j<numActivities; j++) {
	    		String activity = in.nextLine();
	    		if(activityPossible(cInterval, activity)) {
	    			res[i]+="C";
	    			cInterval.add(activity);
	    			
	    		}else if(activityPossible(jInterval, activity)) {
	    			res[i]+="J";
	    			jInterval.add(activity);
	    			
	    		} else {
	    			res[i] = "IMPOSSIBLE";
	    			j = numActivities;
	    		}
	    	}
	    } 
	    
	    for(int i = 0; i < numCases; i++) {
	    	System.out.println("Case #"+ (i+1) +": "+res[i]);
	    }
	    in.close();
	    
	}
	
	public static boolean activityPossible(List<String> aList, String interval) {
		for(String s : aList) {
			if(inInterval(s,interval)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean inInterval(String cur, String check) {
		int curS = Integer.parseInt(cur.substring(0,cur.indexOf(' ')));
		int curE = Integer.parseInt(cur.substring(cur.indexOf(' ')+1,cur.length()));
		int checkS = Integer.parseInt(check.substring(0,check.indexOf(' ')));
		int checkE = Integer.parseInt(check.substring(check.indexOf(' ')+1,check.length()));
		if(curS<checkS && curE <= checkS) {
			return false;
		} else if (checkS<curS && checkE <= curS) {
			return false;
		}
		return true;
	}
}