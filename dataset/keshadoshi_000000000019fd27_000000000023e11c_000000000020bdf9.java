import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int cases = 1; cases <= t; cases++) {
			int n = sc.nextInt();
			Activity[] act = new Activity[n];
			String output = "";
			int end_c = 0, end_j = 0;
			for (int i = 0; i < n; i++) {
				act[i] = new Activity(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(act);
			for (int i = 0; i < n; i++) {
				if (end_c <= act[i].start) {
					output += "C";
					end_c = act[i].end;
				} else if (end_j <= act[i].start) {
					output += "J";
					end_j = act[i].end;
				} else {
					output = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #" + cases + ": " + output);
		}
		sc.close();
	}

	public static class Activity implements Comparable<Activity> {
		int start = 0, end = 0;

		public Activity(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(Activity o) {
			if (this.start < o.start) {
				return -1;
			} else if (this.start > o.start) {
				return 1;
			}
			return 0;
		}
	}
}
