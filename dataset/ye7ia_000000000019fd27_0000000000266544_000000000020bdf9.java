import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static class Interval implements Comparable<Interval> {
		int start, end, index;
		public Interval(int s, int e, int i) {
			start = s;
			end = e;
			index = i;
		}
		public int compareTo(Interval o) {
			if (this.start == o.start) {
				return Integer.compare(end, o.end);
			}
			return Integer.compare(start, o.start);
		}
		public boolean overlaps(Interval o) {
			return !(o.start >= this.end || o.end <= this.start);
		}
		public String toString() {
			return start + " " + end;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = in.nextInt();
			Interval[] intervals = new Interval[n];
			for (int i = 0; i < n; i++) {
				intervals[i] = new Interval(in.nextInt(), in.nextInt(), i);
			}
			Arrays.sort(intervals);
			char[] ans = new char[n];

			boolean hasSolution = true;
			Interval lastJ = new Interval(-1, -1, -1), lastC = new Interval(-1, -1, -1);
			for (int i = 0; hasSolution && i < n; i++) {
				if (!intervals[i].overlaps(lastC)) {
					ans[intervals[i].index] = 'C';
					lastC = intervals[i];
				} else if (!intervals[i].overlaps(lastJ)) {
					ans[intervals[i].index] = 'J';
					lastJ = intervals[i];
				} else {
					hasSolution = false;
				}
			}
			
			String sol = hasSolution ? new String(ans) : "IMPOSSIBLE";
			System.out.printf("Case #%d: %s\n", tc, sol);
		}
		in.close();

	}
}
