import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int numCases = Integer.parseInt(in.nextLine());
        
        for (int currCase = 1; currCase <= numCases; currCase++) {
        	int numActivities = Integer.parseInt(in.nextLine());
        	ArrayList<Activity> arr = new ArrayList<Activity>();
        	StringBuffer sb = new StringBuffer();
        	
        	for (int i = 0; i < numActivities; i++) {
        		
        		arr.add(new Solution().new Activity(in.nextLine().split(" ")));
        	}
        	
        	PriorityQueue<Activity> pq = new PriorityQueue<Activity>(arr);
        	
        	if (numActivities >= 1) {
        		sb.append("C");
        	} 
        	if (numActivities >= 2) {
        		sb.append("J");
        	}
        	if (numActivities > 2) {
	        	Activity cameronActivity = pq.poll();
	        	Activity jamieActivity = pq.poll();
	        	
	        	while (!pq.isEmpty()) {
	        		Activity nextActivity = pq.poll();
	        		if (cameronActivity.endTime > jamieActivity.endTime) {
	        			if (cameronActivity.endTime <= nextActivity.startTime) {
	        				sb.append("C");
	        				cameronActivity = nextActivity;
	        			} else if (jamieActivity.endTime <= nextActivity.startTime){
	        				sb.append("J");
	        				jamieActivity = nextActivity;
	        			} else {
	        				sb = new StringBuffer();
	        				sb.append("IMPOSSIBLE");
	        				break;
	        			}
	        		} else {
	        			if (jamieActivity.endTime <= nextActivity.startTime) {
	        				sb.append("J");
	        				jamieActivity = nextActivity;
	        			} else if (cameronActivity.endTime <= nextActivity.startTime) {
	        				sb.append("C");
	        				cameronActivity = nextActivity;
	        			} else {
	        				sb = new StringBuffer();
	        				sb.append("IMPOSSIBLE");
	        				break;
	        			}
	        		}
	        	}
        	}
        	
        	System.out.println("Case #" + currCase + ": " + sb.toString());
        }

	}
	
	public class Activity implements Comparable<Activity> {
		public int startTime;
		public int endTime;
		
		
		public Activity(String[] times) {
			startTime = Integer.parseInt(times[0]);
			endTime = Integer.parseInt(times[1]);
		}

		@Override
		public int compareTo(Activity other) {
			return this.endTime - other.endTime;
		}
	}
}