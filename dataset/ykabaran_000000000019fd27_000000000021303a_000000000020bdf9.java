
import java.util.Arrays;
import java.util.Scanner;

/**
 * Google CodeJam 2020 Quals
 */
public class Solution {

	private static final int NONE = 0;
	private static final int C = 1;
	private static final int J = 2;

	private static class Interval {

		final int index;
		final int start;
		final int end;
		int assignee = NONE;

		public Interval(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

	}
	private final int numIntervals;
	private final Interval[] intervals;

	public Solution(Scanner scanner) {
		this.numIntervals = scanner.nextInt();
		this.intervals = new Interval[this.numIntervals];
		for (int i = 0; i < this.numIntervals; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			this.intervals[i] = new Interval(i, start, end);
		}
	}

	private void assign(int asignee) {
		int currEnd = 0;
		for (int i = 0; i < this.numIntervals; i++) {
			Interval interval = this.intervals[i];
			if (interval.assignee != NONE) {
				continue;
			}
			if (interval.start >= currEnd) {
				interval.assignee = asignee;
				currEnd = interval.end;
			}
		}
	}

	public String solve() {
		Arrays.sort(this.intervals, (a, b) -> Integer.compare(a.start, b.start));
		this.assign(C);
		this.assign(J);
		Arrays.sort(this.intervals, (a, b) -> Integer.compare(a.index, b.index));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.numIntervals; i++) {
			Interval interval = this.intervals[i];
			if (interval.assignee == NONE) {
				return "IMPOSSIBLE";
			}
			if (interval.assignee == C) {
				sb.append("C");
			} else {
				sb.append("J");
			}
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in);) {
			int T = scanner.nextInt();
			for (int i = 1; i <= T; i++) {
				String solution = new Solution(scanner).solve();
				System.out.println("Case #" + i + ": " + solution);
			}
		}
		System.exit(0);
	}

}
