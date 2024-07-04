
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Solution{
	static int mod = 1000000007;
	static ArrayList<Integer>[] g;

	public static void main(String[] args) {

		Scanner nik = new Scanner(System.in);

		int t = nik.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {

			int n = nik.nextInt();
			long sum = 0;

			pair[] p = new pair[n];
			boolean b = true;
			StringBuilder st = new StringBuilder();

			for (int i = 0; i < n; i++) {
				p[i] = new pair(nik.nextInt(), nik.nextInt());
			}

			Arrays.sort(p);

			int c = 0;
			int j = 1;

			st.append("CJ");
			for (int i = 2; i < n; i++) {

				if (p[i].x >= p[c].y) {
					st.append('C');
					c = i;
				} else if (p[i].x >= p[j].y) {
					st.append('J');
					j = i;
				} else {
					b = false;
					break;
				}
			}
			sb.append("Case #" + tc + ": ");
			if (!b) {
				sb.append("IMPOSSIBLE\n");
			} else {
				sb.append(st + "\n");
			}
		}
		System.out.println(sb);
	}

	private static class pair implements Comparable<pair> {

		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(pair o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}
}