
import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * @author Julian Paniagua
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int numberOfActivities = scanner.nextInt();
			Activity[] activities = new Activity[numberOfActivities];
			char[] charset = new char[numberOfActivities];
			for (int i = 0; i < numberOfActivities; i++) {
				charset[i] = '@';
				int nextStart = scanner.nextInt();
				int nextEnd = scanner.nextInt();
				activities[i] = new Activity(nextStart, nextEnd, i);
			}
			List<Activity> temp = Arrays.asList(activities);
			temp.sort(Comparator.comparingInt(o -> o.startMinute));
			int start = 0;
			int end = 0;
			for (Activity activity : temp) {
				if (activity.startMinute >= end || activity.endMinute <= start) {
					charset[activity.originalIndex] = 'C';
					start = activity.startMinute;
					end = activity.endMinute;
				}
			}
			start = 0;
			end = 0;
			for (Activity activity : temp) {
				if (charset[activity.originalIndex] != 'C' && (activity.startMinute >= end || activity.endMinute <= start)) {
					charset[activity.originalIndex] = 'J';
					start = activity.startMinute;
					end = activity.endMinute;
				}
			}
			String result = new String(charset);
			if (result.contains("@")) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + t + ": " + result);
			}
		}
	}

	public static class Activity {
		public final int startMinute;
		public final int endMinute;
		public final int originalIndex;

		public Activity(int start, int end, int index) {
			startMinute = start;
			endMinute = end;
			originalIndex = index;
		}
	}

}