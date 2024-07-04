import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static final String VALUES_TO_SKIP = "(\r\n|[\n\r\u2028\u2029\u0085])?";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		in.skip(VALUES_TO_SKIP);

		for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
			int matrixSize = in.nextInt();
			in.skip(VALUES_TO_SKIP);

			Activity[] activities = new Activity[matrixSize];
			for(int activityIndex = 0; activityIndex < matrixSize; activityIndex++) {

				String[] rowItems = in.nextLine().split(" ");
				in.skip(VALUES_TO_SKIP);

				activities[activityIndex] = new Activity(Integer.parseInt(rowItems[0]), Integer.parseInt(rowItems[1]), activityIndex);
			}
			String assignmentResult = assignActivities(activities);

			System.out.println("Case #" + caseIndex + ": " + assignmentResult);


		}
	}

	private static String assignActivities(Activity[] activities) {
		Arrays.sort(activities, (x, y)-> Integer.compare(x.start, y.start));

		Kid jamie = new Kid("J");
		Kid cameron = new Kid("C");

		List<Assignment> assignments = new ArrayList<>();

		for(Activity activity : activities) {
			if(jamie.busyTill <= activity.start) {
				jamie.busyTill = activity.end;
				assignments.add(new Assignment(activity.order, jamie.name));
			} else {
				if(cameron.busyTill > activity.start) {
					return "IMPOSSIBLE";
				} else {
					cameron.busyTill = activity.end;
					assignments.add(new Assignment(activity.order, cameron.name));
				}
			}
		}

		assignments.sort((a1, a2) -> Integer.compare(a1.activityId, a2.activityId));

		StringBuilder stringBuilder = new StringBuilder();
		for(Assignment assignment : assignments) {
			stringBuilder.append(assignment.asigneeName);
		}
		return stringBuilder.toString();
	}
}

class Kid {
	final String name;
	int busyTill;

	public Kid(String name) {
		this.name = name;
		busyTill = 0;
	}
}

class Activity {
	final int start;
	final int end;
	final int order;

	public Activity(int start, int end, int order) {
		this.start = start;
		this.end = end;
		this.order = order;
	}
}

class Assignment {
	final int activityId;
	final String asigneeName;

	public Assignment(int activityId, String name) {
		this.activityId = activityId;
		this.asigneeName = name;
	}
}