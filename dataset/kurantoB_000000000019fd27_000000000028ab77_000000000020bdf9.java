import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= numCases; i++) {
			System.out.println("Case #" + i + ": " + processProblem(in));
		}
		in.close();
	}

	private static String processProblem(Scanner in) {
		int numActivities = in.nextInt();
		Activity[] activities = new Activity[numActivities];
		for (int i = 0; i < numActivities; i++) {
			activities[i] = new Activity();
			activities[i].start = in.nextInt();
			activities[i].end = in.nextInt();
		}
		return solve(numActivities, activities);
	}
	
	public static String solve(int numActivities, Activity[] activities) {
		Map<String, Integer> activityPosMap = new HashMap<>();
		for (int i = 0; i < activities.length; i++) {
			activityPosMap.put(activities[i].start + " " + activities[i].end, i);
		}
		Map<String, Character> activityDoerMap = new HashMap<>();
		Arrays.sort(activities);
		Activity JActivity = null;
		Activity CActivity = null;
		for (Activity a: activities) {
			if (JActivity == null || JActivity.end <= a.start) {
				JActivity = a;
				activityDoerMap.put(a.start + " " + a.end, 'J');
			} else if (CActivity == null || CActivity.end <= a.start) {
				CActivity = a;
				activityDoerMap.put(a.start + " " + a.end, 'C');
			} else {
				return "IMPOSSIBLE";
			}
		}
		char[] assignees = new char[activities.length];
		for (String activityID: activityDoerMap.keySet()) {
			assignees[activityPosMap.get(activityID)] = activityDoerMap.get(activityID);
		}
		StringBuilder returnStr = new StringBuilder();
		for (char c: assignees) {
			returnStr.append(c);
		}
		return returnStr.toString();
	}
	
	static class Activity implements Comparable<Activity> {
		int start;
		int end;
		@Override
		public int compareTo(Activity other) {
			return ((Integer)start).compareTo(other.start);
		}
	}

}
