
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			int numberOfActivities = in.nextInt();
			Activity[] activityArray = new Activity[numberOfActivities];
			for (int i = 0; i < numberOfActivities; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				activityArray[i] = new Activity(start, end);
			}
			StringBuilder result = getResults(activityArray);
			String altResult = "";
			if (!result.toString().equals("IMPOSSIBLE")) {
				for (Activity activity : activityArray) {
					altResult = altResult + activity.parent;
				}
			} else {
				altResult = result.toString();
			}
			//System.out.println("Case #" + testCase + ": " + result.toString());
			System.out.println("Case #" + testCase + ": " + altResult);
		}
		System.out.flush();
	}

	public static StringBuilder getResults(Activity[] activityArray) {
		StringBuilder result = new StringBuilder();
		Parent cameron = new Parent();
		Parent jamie = new Parent();
		boolean impossible = false;
		for (Activity activity : activityArray) {
			if (!impossible) {
				if (cameron.isAvailable(activity)) {
					result.append("C");
					activity.parent = "C";
					cameron.addAssignment(activity);
				} else if (jamie.isAvailable(activity)) {
					result.append("J");
					activity.parent = "J";
					jamie.addAssignment(activity);
				} else {
					result = new StringBuilder("IMPOSSIBLE");
					impossible = true;
				}
			}
		}
		return result;
	}

	public static class Activity {
		private int start;
		private int end;
		private String parent;

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
