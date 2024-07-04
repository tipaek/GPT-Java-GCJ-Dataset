import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for (int curCase = 1; curCase <= numCases; curCase++) {
			int lastC = 0;
			int lastJ = 0;
			int numActivities = in.nextInt();
			ArrayList<Activity> activities = new ArrayList<Activity>();
			for (int job = 0; job < numActivities; job++) {
				Activity curActivity = new Activity(in.nextInt(), in.nextInt(), job);
				activities.add(curActivity);
			}
			Collections.sort(activities);
			int i = 0;
			for (; i < activities.size(); i++) {
				Activity curActivity = activities.get(i);
				if (curActivity.start >= lastC) {
					curActivity.doneByC = true;
					lastC = curActivity.end;
				} else if (curActivity.start >= lastJ) {
					lastJ = curActivity.end;
				} else {
					break;
				}
			}
			if (i != activities.size())
				System.out.println("Case #" + curCase + ": IMPOSSIBLE");
			else {
				char[] res = new char[numActivities];
				for (Activity activity: activities) {
					res[activity.originalPosition] = activity.doneByC ? 'C' : 'J';
				}
				System.out.println("Case #" + curCase + ": " + new String(res));
			}
//			System.out.println("Case #" + curCase + ": " + trace + " " + r + " " + c);
		}
	}
	
	static class Activity implements Comparable<Activity> {
		int start;
		int end;
		int originalPosition;
		boolean doneByC;
		
		public Activity(int start, int end, int position) {
			this.start = start;
			this.end = end;
			this.doneByC = false;
			this.originalPosition = position;
		}

		@Override
		public int compareTo(Activity o) {
			return this.start - o.start;
		}
	}
}
