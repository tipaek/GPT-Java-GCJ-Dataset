import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		String[] outputs = new String[testCases];
		for (int i = 1; i <= testCases; ++i) {
			int numActivities = Integer.parseInt(in.nextLine());

			List<Activity> activities = new ArrayList<>();

			for (int j = 0; j < numActivities; j++) {
				activities.add(new Activity(in.nextLine().split(" "), j));
			}
			outputs[i - 1] = processActivities(activities);
		}
		in.close();
		
		for (int i = 1; i <= testCases; i++) {
			System.out.println("Case #" + i + ": " + outputs[i - 1]);
		}
	}

	private static String processActivities(List<Activity> activities) {
		activities.sort((a, b) -> a.startTime - b.startTime);

		int lastAssignedEndTime = 0;
		for (Activity activity : activities) {
			if (activity.startTime >= lastAssignedEndTime) {
				activity.assigned = "J";
				lastAssignedEndTime = activity.endTime;
			}
		}
		lastAssignedEndTime = 0;
		// Now Assigned to C
		for (Activity activity : activities) {
			if (activity.assigned == null && activity.startTime >= lastAssignedEndTime) {
				activity.assigned = "C";
				lastAssignedEndTime = activity.endTime;
			}
		}

		for (Activity activity : activities) {
			if (activity.assigned == null) {
				return "IMPOSSIBLE";
			}
		}

		activities.sort((a, b) -> a.index - b.index);

		StringBuilder result = new StringBuilder();
		for (Activity activity : activities) {
			result.append(activity.assigned);
		}
		return result.toString();

	}

}

class Activity {
	public int index;
	public int startTime;
	public int endTime;
	public String assigned;

	public Activity(String[] arr, int index) {
		startTime = Integer.parseInt(arr[0]);
		endTime = Integer.parseInt(arr[1]);
		this.index = index;
	}

}
