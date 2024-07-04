import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String result = solveProblem(in);
		System.out.println(result);
	}

	public static String solveProblem(Scanner scanner) {
		String result = "";
		int t = scanner.nextInt();
		for (int i = 1; i <= t; ++i) {
			List<Activity> activities = new ArrayList<>();
			int n = scanner.nextInt();
			for (int j = 0; j < n; j++) {
				Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
				activities.add(activity);
			}
			result += "Case #" + i + ": " + solveCase(activities) + "\n";
		}

		return result;
	}

	public static String solveCase(List<Activity> activities) {
		String result = "";
		// On trie les activites par date de debut
		List<Activity> sortedActivities = new ArrayList<>();
		for (int i = 0; i < 24*60; i ++) {
			for(Activity activity : activities) {
				if (activity.start == i) {
					sortedActivities.add(activity);
				}
			}
		}
		int endC = 0;
		int endJ = 0;
		Map<Activity, String> assignedActivities = new HashMap<Activity, String>();
		for(Activity activity : sortedActivities) {
			if (endC <= activity.start) {
				endC = activity.end;
				assignedActivities.put(activity, "C");
			} else if (endJ <= activity.start) {
				endJ = activity.end;
				assignedActivities.put(activity, "J");
			} else {
				return "IMPOSSIBLE";
			}
		}
		for(Activity activity : activities) {
			result+=assignedActivities.get(activity);
		}
		return result;
	}

	public static class Activity {
		public int start;
		public int end;

		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public boolean isInMoment(int moment) {
			if (start <= moment && end > moment) {
				return true;
			}
			return false;
		}
	}
}
