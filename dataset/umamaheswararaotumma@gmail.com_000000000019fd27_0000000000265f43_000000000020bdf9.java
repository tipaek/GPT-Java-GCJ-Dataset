import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseNo = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			boolean isPossible = true;
			List<Activity> cActivities = new ArrayList<>();
			List<Activity> jActivities = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				Activity activity = new Solution().new Activity(sc.nextInt(), sc.nextInt());
				if (canITakeThisActivity(cActivities, activity)) {
					cActivities.add(activity);
					sb.append("C");
				} else if (canITakeThisActivity(jActivities, activity)) {
					jActivities.add(activity);
					sb.append("J");
				} else {
					System.out.println("Case #" + caseNo++ + ": IMPOSSIBLE");
					isPossible = false;
					break;
				}
			}
			if (isPossible)
				System.out.println("Case #" + caseNo++ + ": " + sb.toString());
		}
		sc.close();
	}

	private static boolean canITakeThisActivity(List<Activity> cActivities, Activity pair) {
		for (Activity activity : cActivities) {
			if (activity.isInBtw(pair)) {
				return false;
			}
		}

		return true;
	}

	public class Activity {

		public int start;
		public int end;

		public Activity(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public boolean isInBtw(Activity activity) {
			return start >= activity.end || activity.start >= end ? false : true;
		}
	}

}
