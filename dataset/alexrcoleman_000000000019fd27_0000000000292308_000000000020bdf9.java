import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t=1;t<=T;t++) {
			int n = in.nextInt();
			ArrayList<Range> ranges = new ArrayList<>();
			for (int i=0;i<n;i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				ranges.add(new Range(i, a,b));
			}
			Collections.sort(ranges);
			
			
			int C = 0;
			int J = 0;
			char[] ans = new char[n];
			boolean fail = false;
			for (Range r : ranges) {
				if (C <= r.s) {
					C = r.e;
					ans[r.i] = 'C';
				} else if(J <= r.s) {
					J = r.e;
					ans[r.i] = 'J';
				} else {
					fail = true;
					break;
				}
			}
			System.out.printf("Case #%d: %s\n", t, fail ? "IMPOSSIBLE" : new String(ans));
		}
	}
	static class Range implements Comparable<Range>{
		int s, e, i;
		public Range(int i, int s, int e) {
			this.s = s;
			this.e = e;
			this.i = i;
		}
		@Override
		public int compareTo(Range o) {
			return s-o.s;
		}
	}
}
