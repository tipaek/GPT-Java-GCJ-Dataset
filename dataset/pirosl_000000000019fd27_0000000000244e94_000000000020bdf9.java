import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static class Activity {
		int start;
		int end;
		int idx;
		char assigned;

		public Activity(int idx, int start, int end) {
			this.start = start;
			this.end = end;
			this.idx = idx;
		}
	}

	static List<Activity> activities;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			readActivities(in, n);

			process(i);
		}
	}

	static void readActivities(Scanner in, int n) {
		activities = new ArrayList<>();
		for (int i = 1; i <= n; ++i) {
			activities.add(new Activity(i, in.nextInt(), in.nextInt()));
		}
	}

	static void process(int i) {
		Comparator<Activity> startTimeComparator = new Comparator<Activity>() {
			public int compare(Activity a1, Activity a2) {
				return a1.start - a2.start;
			}
		};

		Collections.sort(activities, startTimeComparator);
		int endTimeJ = -1;
		int endTimeC = -1;
		
		for (Activity a : activities) {
			if (endTimeC <= a.start) {
				a.assigned = 'C';
				endTimeC = a.end;
			}
			else {
				if (endTimeJ <= a.start) {
					a.assigned = 'J';
					endTimeJ = a.end;
				}
				else {
					System.out.println("Case #" + i + ": IMPOSSIBLE");
					return;
				}
			}
		}
		
		Comparator<Activity> idxComparator = new Comparator<Activity>() {
			public int compare(Activity a1, Activity a2) {
				return a1.idx - a2.idx;
			}
		};
		
		
		Collections.sort(activities, idxComparator);
		
		StringBuffer sb = new StringBuffer();
		for (Activity a : activities) {
			sb.append(a.assigned);
		}
		System.out.println("Case #" + i + ": " + sb.toString());
	}

}
