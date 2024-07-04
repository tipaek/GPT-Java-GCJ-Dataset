import java.util.ArrayList;
import java.util.Collections;
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
        		String[] line = in.nextLine().split(" ");
        		arr.add(new Solution().new Activity(line[0], true, i));
        		arr.add(new Solution().new Activity(line[1], false, i));
        	}
        	
        	Collections.sort(arr);
        	
        	int overlapping = 0;
        	boolean cBusy = false;
        	boolean jBusy = false;
        	
        	for (int i = 0; i < arr.size(); i++) {
        		Activity curr = arr.get(i);
        		if (curr.isStart && overlapping == 2) {
        			sb = new StringBuffer();
        			sb.append("IMPOSSIBLE");
        			break;
        		} else if (curr.isStart) {
        			overlapping += 1;
        			if (!cBusy) {
        				cBusy = true;
        				sb.append("C");
        			} else if (!jBusy) {
        				jBusy = true;
        				sb.append("J");
        			}
        		} else {
        			overlapping -= 1;
        			if (cBusy) {
        				cBusy = false;
        			} else if (jBusy) {
        				jBusy = false;
        			}
        		}
        	}
        	System.out.println("Case #" + currCase + ": " + sb.toString());
        }

	}
	
	public class Activity implements Comparable<Activity> {
		public boolean isStart;
		public int time;
		public int id;
		
		public Activity(String time, boolean isStart, int id) {
			this.time = Integer.parseInt(time);
			this.isStart = isStart;
			this.id = id;
		}

		@Override
		public int compareTo(Activity other) {
			if (this.time == other.time) {
				return !this.isStart ? -1 : 1;
			} else {
				return this.time - other.time;
			}
		}
	}
}
