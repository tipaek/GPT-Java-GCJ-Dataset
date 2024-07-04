import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/* **************************** */

public class Solution {
	public static final int START = 1;
	public static final int STOP = 0;

	static class Activity {
		int id, time, type;

		public Activity(int id, int time, int type) {
			this.id = id;
			this.time = time;
			this.type = type;
		}
	}

	void solve() {
		int N = scanner.nextInt();
		ArrayList<Activity> activities = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int start = scanner.nextInt();
			int stop = scanner.nextInt();
			activities.add( new Activity(i, start, START));
			activities.add( new Activity(i, stop, STOP));
		}
		activities.sort(new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				int times = Integer.compare(o1.time, o2.time);
				return times == 0 ? Integer.compare(o1.type, o2.type) : times;
			}
		});
		//System.out.println(activities);

		char[] result = new char[N];

		int c = -1;
		int j = -1;
		for (Activity a : activities) {
			if (a.type == START) {
				if (c==-1) {
					c = a.id;
					result[a.id] = 'C';
				}
				else
				if (j==-1) {
					j = a.id;
					result[a.id] = 'J';
				}
				else {
					System.out.println("IMPOSSIBLE");
					return;
				}
			}
			else {
				if (c == a.id) {
					c = -1;
				}
				if (j == a.id) {
					j = -1;
				}
			}
		}
		System.out.println(new String(result));
	}

	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 1; i <= testCases; i++) {
			System.out.print("Case #" + i + ": ");
			new Solution().solve();
		}
	}
}