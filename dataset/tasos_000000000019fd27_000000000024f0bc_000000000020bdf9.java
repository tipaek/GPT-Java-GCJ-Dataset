import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

				activities[activityIndex] = new Activity(Integer.parseInt(rowItems[0]), Integer.parseInt(rowItems[1]));
			}
			String assignmentResult = assignActivities(activities);

			System.out.println("Case #" + caseIndex + ": " + assignmentResult);


		}
	}

	private static String assignActivities(Activity[] activities) {
		Arrays.sort(activities, (x, y)-> Integer.compare(x.start, y.start));

		Kid jamie = new Kid("J");
		Kid cameron = new Kid("C");
		StringBuilder stringBuilder = new StringBuilder();

		for(Activity activity : activities) {
			if(jamie.busyTill <= activity.start) {
				jamie.busyTill = activity.end;
				stringBuilder.append(jamie.name);
			} else {
				if(cameron.busyTill > activity.start) {
					return "IMPOSSIBLE";
				} else {
					cameron.busyTill = activity.end;
					stringBuilder.append(cameron.name);
				}
			}
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

	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
