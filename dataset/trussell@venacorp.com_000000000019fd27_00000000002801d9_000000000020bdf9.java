import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static class Owner {
		List<Activity> activities = new ArrayList<>();
		String id;

		Owner(String id) {
			this.id = id;
		}

		boolean canOwnActivity(Activity test) {
			for (Activity activity : this.activities) {
				if (test.start < activity.end && test.end > activity.start) {
					return false;
				}
			}
			return true;
		}
	}

	private static class Activity {
		int id;
		int start;
		int end;

		Activity(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] argv) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for (int i = 0; i < numCases; i++) {
			int numActivities = in.nextInt();
			List<Activity> activities = new ArrayList<>(numActivities);
			for (int j = 0; j < numActivities; j++) {
				activities.add(new Activity(j, in.nextInt(), in.nextInt()));
			}
			String result = computeSchedule(activities);
			System.out.println(String.format("Case #%d: %s", i + 1, result));
		}
	}

	public static String computeSchedule(List<Activity> activities) {
		StringBuffer result = new StringBuffer();
		Owner cameron = new Owner("C");
		Owner jamie = new Owner("J");
		for (Activity activity : activities) {
			if (cameron.canOwnActivity(activity)) {
				cameron.activities.add(activity);
			} else if (jamie.canOwnActivity(activity)) {
				jamie.activities.add(activity);
			}
		}
		for (int i = 0; i < activities.size(); i++) {
			final int activityId = i;
			if (cameron.activities.stream().anyMatch(a -> a.id == activityId)) {
				result.append(cameron.id);
			} else if (jamie.activities.stream().anyMatch(a -> a.id == activityId)) {
				result.append(jamie.id);
			} else {
				return "IMPOSSIBLE";
			}
		}
		return result.toString();
	}
}