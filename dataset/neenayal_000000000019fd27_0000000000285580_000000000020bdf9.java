import java.util.*;
import java.io.*;

public class Solution {

	static class Activity {
		int idx;
		int start;
		int end;

		public Activity(int idx, int start, int end) {
			this.idx = idx;
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = in.nextInt();
		for (int test = 1; test <= tc; ++test) {
			int num = in.nextInt();

			List<Activity> activityList = new ArrayList<>();
			for (int idx = 0; idx < num; idx++) {
				int start = in.nextInt();
				int end = in.nextInt();

				Activity activity = new Activity(idx, start, end);
				activityList.add(activity);
			}

			Collections.sort(activityList, new Comparator() {
				public int compare(Object o1, Object o2) {
					Activity a1 = (Activity) o1;
					Activity a2 = (Activity) o2;
					return (a1.start - a2.start);
				}
			});

			int availForC = 0;
			int availForJ = 0;
			boolean isResultPossible = true;
			char result[] = new char[num];

			for (int idx = 0; idx < num; idx++) {
				Activity activity = activityList.get(idx);
				int start = activity.start;
				if (availForC <= start) {
					result[activity.idx] = 'C';
					availForC = activity.end;
				} else if (availForJ <= start) {
					result[activity.idx] = 'J';
					availForJ = activity.end;
				} else {
					isResultPossible = false;
				}
			}

			if (isResultPossible) {
				StringBuilder resultStr = new StringBuilder();
				for (int idx = 0; idx < num; idx++) {
					resultStr.append(result[idx]);
				}
				System.out.println("Case #" + test + ": " + resultStr.toString());
			} else {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
			}
		}
	}
}