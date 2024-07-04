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
			System.out.println(solver.solve(activities));
		}
	}
}

class Solver {
	public String solve(Activity[] activities) {
		Arrays.sort(activities);
		return solvRec(0, 0, activities, 0);
	}

	string solveRec(int cEarlyTime, int jEarlyTime, Activity[] activities, int activityNum) {
		if (activityNum == activities.length-1)	return "";

		int startTime = activities[activityNum].start;
		int endTime = activities[activityNum].end;

		if(cEarlyTime <= startTime) {
			String restString = solveRec(endTime, jEarlyTime, activities, activityNum+1);
			if("IMPOSSIBLE".equals(restString)) return "IMPOSSIBLE";
			return "C"+restString;
		}
		else if(jEarlyTime <= startTime) {
			String restString = solveRec(cEarlyTime, endTime, activities, activityNum+1);
			if("IMPOSSIBLE".equals(restString)) return "IMPOSSIBLE";
			return "J"+restString;
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