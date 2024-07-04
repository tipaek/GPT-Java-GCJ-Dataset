import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 * Parenting Partnering Returns
 * 
 * If 3 activities overlap, then IMPOSSIBLE
 * 
 */
public class Solution {

	private static Scanner sc;

	private static Activity[] activities = new Activity[1000];

	static {
		for (int i = 0; i < activities.length; i++) {
			activities[i] = new Activity();
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; ++t) {
			solve(t);
		}

		sc.close();
	}

	private static void solve(int t) {

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			activities[i].setTime(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(activities, 0, N);

		// for (int i = 0; i < N; i++)
		// 	System.out.println(activities[i]);
		
		activities[0].user = 'C';
		activities[1].user = 'J';
		StringBuilder answer = new StringBuilder("CJ");

		for (int i = 2; i < N; i++) {
			if (activities[i].start < activities[i-1].end &&
					activities[i].start < activities[i-2].end) {
				out.printf("Case #%d: IMPOSSIBLE\n", t);
				return;
			}
			activities[i].user = activities[i-2].user;
			answer.append(activities[i-2].user);
		}

		out.printf("Case #%d: %s\n", t, answer.toString());
	}

	static class Activity implements Comparable<Activity> {
		int start;
		int end;
		char user;

		void setTime(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Activity other) {

			if (start < other.start)
				return -1;
			if (other.start < start)
				return 1;

			if (end < other.end)
				return -1;
			if (other.end < end)
				return 1;

			return 0;
		}

		@Override
		public String toString() {
			return start + " to " + end;
		}
	}
}
