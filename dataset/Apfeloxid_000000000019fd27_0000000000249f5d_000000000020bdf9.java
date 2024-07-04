import java.util.Arrays;
import java.util.Scanner;

class Solution {

	static class Activity implements Comparable<Activity> {
		int start;
		int end;

		public Activity(int start, int end) {
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
				activities[i] = new Activity(startOfActivity, endOfActivity);
			}

			Arrays.sort(activities);
			
			int firstTime = 0;
			int secondTime = 0;

			StringBuilder solution = new StringBuilder();
			
			for (Activity activity: activities) {
				if (activity.start >= firstTime) {
					firstTime = activity.end;
					solution.append("C");
				} else if (activity.start >= secondTime) {
					secondTime = activity.end;
					solution.append("J");
				} else {
					solution = new StringBuilder("IMPOSSIBLE");
					break;
				}
			}

			System.out.println("Case #" + test + ": " + solution);
		}
	}
}