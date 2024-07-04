import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solver solver = new Solver();

		int testCases = sc.nextInt();

		for (int testCase =0; testCase<testCases; testCase++) {
			int n = sc.nextInt();
			Activity[] activities = new Activity[n];

			for (int i =0; i<n; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				activities[i] = new Activity(start, end);
			}
			System.out.println(solver.solve(activities, testCase+1));
		}
	}
}

class Solver {

	Activity[] activities;

	public String solve(Activity[] activities, int t) {
		this.activities = activities;
		Arrays.sort(this.activities);
		return "Case #"+t+": "+solveRec(0, 0, 0);
	}

	String solveRec(int cEarlyTime, int jEarlyTime, int activityNum) {
		if (activityNum == activities.length)	return "";

		int startTime = this.activities[activityNum].start;
		int endTime = this.activities[activityNum].end;

		int minTime = Math.min(cEarlyTime, jEarlyTime);
		if (minTime > startTime)	return "IMPOSSIBLE";

		else {
			if (minTime == cEarlyTime) {
				String restString = solveRec(endTime, jEarlyTime, activityNum+1);
				if("IMPOSSIBLE".equals(restString)) return "IMPOSSIBLE";
				return "C"+restString;				
			}
			else {
				String restString = solveRec(cEarlyTime, endTime, activityNum+1);
				if("IMPOSSIBLE".equals(restString)) return "IMPOSSIBLE";
				return "J"+restString;					
			}
		}
	}
}

class Activity implements Comparable<Activity>{
	int start;
	int end;

	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Activity activity) {
		return this.start - activity.start;
	}

}