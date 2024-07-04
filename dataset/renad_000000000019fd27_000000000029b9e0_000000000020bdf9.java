import java.util.*;
import java.io.*;

public class Solution {
	static class Activity implements Comparable<Activity>{
		int start;
		int end;
		String handler;
		public Activity(String start, String end) {
			this.start = Integer.parseInt(start);
			this.end = Integer.parseInt(end);
		}
		public int compareTo(Activity a) {
			if(this.end == a.start)
				return -1;
			if(this.start < a.start)
				return -1;
			if(this.start > a.start)
				return 1;
			return 0;
		}
	}
    public static void main(String [] args){
    	//System.out.println("Enter username");
    	Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        sc.nextLine();
        
        for(int k = 0; k< test_cases; k++){
        	int activitiesCount = sc.nextInt();
        	sc.nextLine();
        	Activity [] activities = new Activity [activitiesCount];
        	for(int i =0; i< activitiesCount ; i++) {
        		String [] activArr = sc.nextLine().split(" ");
        		Activity activity = new Activity( activArr[0], activArr[1]);
        		activities[i] = activity;
        	}
        	Activity JHandling = null;
            Activity CHandling = null;
        	String res = "";
        	Arrays.sort(activities);
        	for(int i = 0; i< activities.length; i++) {
        		Activity acc = activities[i];
        		if(JHandling != null && JHandling.end <= acc.start)
        			JHandling = null;
        		if(CHandling != null && CHandling.end <= acc.start)
        			CHandling = null;
        		
        		if(CHandling != null && JHandling != null)
        		{
        			res = "IMPOSSIBLE";
        			break;
        		}
        		if(JHandling == null) {
        			res += "J";
        			JHandling = acc;
        		}
        		else {
        			res += "C";
        			CHandling = acc;
        		}
        	}
        	System.out.println("Case #" + k + ": " + res);
        }
    }
}