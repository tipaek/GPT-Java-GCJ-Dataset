
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			int numberOfActivities = in.nextInt();
			Activity[] activityArray = new Activity[numberOfActivities];
			for (int i = 1; i <= numberOfActivities; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				activityArray[i - 1] = new Activity(start, end);
			}
			StringBuilder result = getResults(activityArray);
			System.out.println("Case #" + testCase + ": " + result.toString());
		}
		System.out.flush();
	}

	private static StringBuilder getResults(Activity[] activityArray) {
		StringBuilder result = new StringBuilder();
		Parent cameron = new Parent();
		Parent jamie = new Parent();
		boolean impossible = false;
		for (Activity activity: activityArray) {
			if (!impossible) {
				if (cameron.isAvailable(activity)) {
					result.append("C");
					cameron.addAssignment(activity);
				} else if (jamie.isAvailable(activity)) {
					result.append("J");
					jamie.addAssignment(activity);
				} else {
					result = new StringBuilder("IMPOSSIBLE");
					impossible = true;
				}
			}
		}
		return result;
	}

	private static class Activity {
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

	private static class Parent {
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
