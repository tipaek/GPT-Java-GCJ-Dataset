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
		lower = nextInt();
		higher = nextInt();
		for (int test = 1; test <= testn; test++) {
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

	final int SIZE = (int) 1e+9;
	final String CENTER = "CENTER";
	final String HIT = "HIT";
	final String MISS = "MISS";
	long lower;
	long higher;

	private void solve() {
		Random rand = new Random(12345);
		long x1 = -SIZE + lower;
		long y1 = -SIZE + lower;
		long x2 = SIZE - lower;
		long y2 = SIZE - lower;
		for (int i = 0; i < 200; i++) {
			long y = (y1 + y2) / 2;
			long xRight = Math.round((x1 + x2) / 2 + Math.sqrt(lower * lower - (y1 - y2) * (y1 - y2) / 4.0));
//			long xLeft = Math.round((x1 + x2) / 2 - Math.sqrt(lower * lower - (y1 - y2) * (y1 - y2) / 4.0));
			if (i % 2 == 0) {
				out.println(xRight + " " + y);
			} else {
				out.println(y + " " + xRight);
			}
			out.flush();
			String resp = nextToken();
			if (resp.equals(CENTER)) {
				return;
			}
			if (resp.equals(MISS)) {
				x2 = (x1 + x2) / 2 + 1;
			} else {
				x1 = xRight - lower;
			}
			long t = x1;
			x1 = y1;
			y1 = t;
			t = x2;
			x2 = y2;
			y2 = t;
		}
		System.err.println(x1 + " " + y1 + " " + x2 + " " + y2);
		for (long i = x1; i <= x2; i++) {
			for (long j = y1; j <= y2; j++) {
				out.println(i + " " + j);
				out.flush();
				String resp = nextToken();
				if (resp.equals(CENTER)) {
					return;
				}
			}
		}
	}
}
