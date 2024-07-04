
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			int numberOfActivities = in.nextInt();
			List<Activity> activityList = new ArrayList<>();;
			for (int i = 0; i < numberOfActivities; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				activityList.add(new Activity(start, end));
			}
			System.out.println("Case #" + testCase + ": " + getResults(activityList).toString());
		}
		System.out.flush();
	}

	public static String getResults(List<Activity> activityArray) {
		StringBuilder result = new StringBuilder();
		Parent cameron = new Parent();
		Parent jamie = new Parent();
		for (Activity activity : activityArray) {
			if (cameron.isAvailable(activity)) {
				result.append("C");
				cameron.addAssignment(activity);
			} else if (jamie.isAvailable(activity)) {
				result.append("J");
				jamie.addAssignment(activity);
			} else {
				return "IMPOSSIBLE";
			}
		}
		return result.toString();
	}

	public static class Activity {
		private int start;
		private int end;

		Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}

		boolean isOverlap(Activity other) {
			return Math.max(this.start, other.start) < Math.min(this.end, other.end);
		}

	}

	public static class Parent {
		private List<Activity> assignments = new ArrayList<>();

		void addAssignment(Activity assignment) {
			this.assignments.add(assignment);
		}

		boolean isAvailable(Activity assignment) {
			for (Activity currAssignment : assignments) {
				if (assignment.isOverlap(currAssignment)) {
					return false;
				}
			}
			return true;
		}
	}
}
