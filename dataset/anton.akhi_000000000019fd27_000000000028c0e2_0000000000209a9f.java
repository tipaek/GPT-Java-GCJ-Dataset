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
			char[] s = nextToken().toCharArray();
			int depth = 0;
			for (int i = 0; i < s.length; i++) {
				int desired = s[i] - '0';
				while (desired > depth) {
					out.print("(");
					depth++;
				}
				while (desired < depth) {
					out.print(")");
					depth--;
				}
				out.print(s[i]);
			}
			while (0 < depth) {
				out.print(")");
				depth--;
			}
			out.println();
		}
	}
}
