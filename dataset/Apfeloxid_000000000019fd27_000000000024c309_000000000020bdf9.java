import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

	static class Activity implements Comparable<Activity> {
		int start;
		int end;
		int index;
		char assignedPerson;

		public Activity(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Activity o) {
			return this.start- o.start;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testAmount = scan.nextInt();

		for (int test = 1; test <= testAmount; test++) {
			int activitiesAmount = scan.nextInt();

			Activity[] activities = new Activity[activitiesAmount];

			for (int i = 0; i < activitiesAmount; i++) {
				int startOfActivity = scan.nextInt();
				int endOfActivity = scan.nextInt();
				activities[i] = new Activity(i, startOfActivity, endOfActivity);
			}

			Arrays.sort(activities);

			int firstTime = 0;
			int secondTime = 0;

			StringBuilder solution = new StringBuilder();

			for (Activity activity: activities) {
				if (activity.start >= firstTime) {
					firstTime = activity.end;
					activity.assignedPerson = 'C';
				} else if (activity.start >= secondTime) {
					secondTime = activity.end;
					activity.assignedPerson = 'J';
				} else {
					solution = new StringBuilder("IMPOSSIBLE");
					break;
				}
			}
			if (solution.toString().equals("IMPOSSIBLE")) {
				System.out.println("Case #" + test + ": " + solution);
				continue;
			}

			Arrays.sort(activities, new Comparator<Activity>() {
				@Override
				public int compare(Activity o1, Activity o2) {
					return o1.index - o2.index;
				}
			});
			
			for (Activity activity: activities) {
				solution.append(activity.assignedPerson);
			}
			System.out.println("Case #" + test + ": " + solution);
		}
	}
}