import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	private void solve() {
		int testn = nextInt();
		for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			int l = nextInt();
			int r = nextInt();
			int last = 0;
			for (int i = 1; i <= Math.max(l, r); i++) {
				if (r > l) {
					r -= i;
				} else {
					l -= i;
				}
				last = i;
			}
			out.println(last + " " + l + " " + r);
		}
	}
}
