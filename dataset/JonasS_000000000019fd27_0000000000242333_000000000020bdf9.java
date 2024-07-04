import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		String out = "";

		for (int i = 0; i < T; i++) {
			out += "Case #" + (i + 1) + ": " + testCase(in) + "\n";
		}

		System.out.print(out);
	}

	public static String testCase(Scanner in) {
		int N = in.nextInt();
		String res = "";
		Interval[] intervals = new Interval[N];

		for (int j = 0; j < N; j++) {
			intervals[j] = new Interval(in.nextInt(), in.nextInt());
		}

		Interval[] orig = intervals.clone();
		Arrays.sort(intervals);

		int J = 0;
		int C = 0;
		for (int j = 0; j < N; j++) {
			if (intervals[j].start >= C) {
				C = intervals[j].end;
				intervals[j].person = "C";
			} else if (intervals[j].start >= J) {
				J = intervals[j].end;
				intervals[j].person = "J";
			} else {
				return "IMPOSSIBLE";
			}
		}

		for (int j = 0; j < N; j++) {
			res += orig[j].person;
		}

		return res;
	}

	public static class Interval implements Comparable<Interval> {

		public int start;
		public int end;
		public String person;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval o) {
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return person + ": [" + start + ", " + end + "]";
		}

	}

}
