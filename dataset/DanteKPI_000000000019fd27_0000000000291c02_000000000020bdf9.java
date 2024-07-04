import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
private static final char C = "C".charAt(0);
	private static final char J = "J".charAt(0);

	static class Interval {
		int pos;
		int start;
		int end;

		public Interval(int pos, int start, int end) {
			super();
			this.pos = pos;
			this.start = start;
			this.end = end;
		}

	}

	public static String solve(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.compare(o1.start, o2.start);
			}
		});

		int c = 0;
		int j = 0;
			
		char[] result = new char[intervals.size()];

		for (Interval interval : intervals) {
			if (c <= interval.start) {
				c = interval.end;
				result[interval.pos] = C;
				
				continue;
			} else if (j <= interval.start) {
				j = interval.end;
				result[interval.pos] = J;
				
				continue;
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(result);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();

		for (int test = 1; test < tests + 1; test++) {
			int total = in.nextInt();
			ArrayList<Interval> intervals = new ArrayList<Interval>(total);

			for (int i = 0; i < total; i++) {
				Interval interval = new Interval(i, 0, 0);
				interval.start = in.nextInt();
				interval.end = in.nextInt();
				intervals.add(interval);
			}
			System.out.println("Case #" + test + ": " + solve(intervals));
		}

	}
}
