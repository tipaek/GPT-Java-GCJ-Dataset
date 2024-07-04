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
		int testn = nextInt();
		for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			solve();
		}
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
		int r = nextInt();
		int s = nextInt();
		int[] x = new int[r * s];
		for (int i = 0; i < x.length; i++) {
			x[i] = i % r;
		}
		ArrayList<String> ans = new ArrayList<>();
		while (!good(x, r, s)) {
			int first = x[0];
			int opA = 0;
			while (x[opA] == first) {
				opA++;
			}
			int second = x[opA];
			while (x[opA] == second) {
				opA++;
			}
			int next = opA;
			while (next + 1 < x.length && !(x[next] == first && x[next + 1] == second)) {
				next++;
			}
			int opB = 0;
			if (next + 1 >= x.length) {
				opA = opA / 2;
				opB = x.length - opA - 1;
			} else {
				opB = next + 1 - opA;
			}
			ans.add(opA + " " + opB);
			int[] y = x.clone();
			for (int i = 0; i < opB; i++) {
				y[i] = x[i + opA];
			}
			for (int i = opB; i < opA + opB; i++) {
				y[i] = x[i - opB];
			}
			x = y;
		}
		out.println(ans.size());
		for (String str : ans) {
			out.println(str);
		}
		out.flush();
	}

	private boolean good(int[] x, int r, int s) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] != i / s) {
				return false;
			}
		}
		return true;
	}
}
