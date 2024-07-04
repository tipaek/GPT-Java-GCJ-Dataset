import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static ArrayList<Activity> arr;
	public static int[][] dpTable;
	public static int numActivities;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int numCases = Integer.parseInt(in.nextLine());
        
        for (int currCase = 1; currCase <= numCases; currCase++) {
        	numActivities = Integer.parseInt(in.nextLine());
        	arr = new ArrayList<Activity>();
        	StringBuffer sb = new StringBuffer();
        	
        	for (int i = 0; i < numActivities; i++) {
        		arr.add(new Solution().new Activity(in.nextLine().split(" ")));
        	}
        	
        	Collections.sort(arr);
        	
        	dpTable = new int[numActivities + 1][numActivities + 1];
        	
        	boolean something = recursor(0, 0, -1, -1);
        	
        	String currString = "";
        	int currX = 0;
        	int currY = 0;
        	
        	while (currX + currY < numActivities) {
        		if (dpTable[currY][currX] == 1) {
        			currString += "C";
        			currY++;
        		} else if (dpTable[currY][currX ] == 2)  {
        			currString += "J";
        			currX++;
        		} else {
        			currString = "IMPOSSIBLE";
        			currX = numActivities;
        		}
        	}
        	
        	System.out.println("Case #" + currCase + ": " + currString);
        	
        	
        }
	}
	
	public static boolean recursor(int c, int j, int endTimeC, int endTimeJ) {
		int next = c + j;
		if (next == numActivities) {
			return true;
		} else {
			Activity nextActivity = arr.get(next);
			boolean cBool = false;
			boolean jBool = false;
			
			if (endTimeC <= nextActivity.startTime) {
				cBool = recursor(c + 1, j, nextActivity.endTime, endTimeJ);
				if (cBool == true) {
					dpTable[c][j] = 1;
					return true;
				}
			} 
			if (endTimeJ <= nextActivity.startTime) {
				jBool = recursor(c, j + 1, endTimeC, nextActivity.endTime);
				if (jBool == true) {
					dpTable[c][j] = 2;
					return true;
				}
			} 
			
			return false;
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
			return this.startTime - other.startTime;
		}
	}
}
