import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static class Range implements Comparable<Range> {
		public int start;
		public int end;
		public char res;

		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Range o) {
			return this.start < o.start ? -1 : 1;
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for (int tc = 1; tc <= t; ++tc) {
			int n = in.nextInt();
			Range[] rl = new Range[n];
			Range[] rlo = new Range[n];

			for (int i = 0; i < n; ++i) {
				int s = in.nextInt();
				int e = in.nextInt();
				rl[i] = new Range(s, e);
				rlo[i] = rl[i];
			}
			Arrays.sort(rl);

			Range rc = null;
			Range rj = null;
			boolean p = true;

			for (int i = 0; i < n; ++i) {
				if (rc == null || rc.end <= rl[i].start) {
					rc = rl[i];
					rc.res = 'C';
				} else if (rj == null || rj.end <= rl[i].start) {
					rj = rl[i];
					rj.res = 'J';
				} else {
					p = false;
					break;
				}
			}
			System.out.print("Case #" + tc + ": ");
			if (p) {
				for (int i = 0; i < n; ++i) {
					System.out.print(rlo[i].res);
				}
			} else {
				System.out.print("IMPOSSIBLE");
			}
			System.out.println();
		}
	}

}
