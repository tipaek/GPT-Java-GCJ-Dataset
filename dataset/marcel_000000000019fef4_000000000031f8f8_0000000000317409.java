import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

	private static final int MAX = (int) 1e9;

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solve(in, System.out);
		in.close();
	}

	protected static void solve(Scanner in, PrintStream out) {
		int numtests = in.nextInt();
		for (int t = 1; t <= numtests; ++t) {
			int x = in.nextInt();
			int y = in.nextInt();
			String path = in.next();
			int ret = solveLine(x, y, path);
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", t, ret < 0 ? "IMPOSSIBLE" : ret);
		}
	}

	private static int solveLine(int x, int y, String path) {
		int len = path.length();
		Pair[] pos = new Pair[len + 1];
		for (int i = 0; i < len; i++) {
			char ch = path.charAt(i);
			if (ch == 'N') y+= 1;
			else if (ch == 'S') y -= 1;
			else if (ch == 'E') x += 1;
			else x -= 1;
			pos[i + 1] = new Pair(x,y);
		}
//		System.out.println(Arrays.toString(pos));
		int ans = -1;
		int lo = 1, hi = len;
		while (lo <= hi) {
			int mid = lo + (hi -lo) / 2;
			if (dist(pos[mid]) <= mid) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return ans;
	}

	private static int dist(Pair pair) {
		return abs(pair.x) + abs(pair.y);
	}

	private static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
}
