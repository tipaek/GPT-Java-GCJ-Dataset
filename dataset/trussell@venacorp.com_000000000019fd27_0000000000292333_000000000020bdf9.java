import java.util.ArrayList;
import java.util.Collections;
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
			if (this.activities.isEmpty()) {
				return true;
			} else {
				return this.activities.get(this.activities.size() - 1).end <= test.start;
			}
		}
	}

	private static class Activity {
		int id;
		Integer start;
		Integer end;

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
			Collections.sort(activities, (o1, o2) -> o1.start.compareTo(o2.start));
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