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

	class Pair {
		public Pair(int x2, int y2) {
			x = x2;
			y = y2;
		}

		public Pair(int i, int y2, Pair p, String n) {
			x = i;
			y = y2;
			prev = p;
			dir = n;
		}

		int x, y;
		Pair prev = null;
		String dir = null;
	}

	private void solve() {
		int x = nextInt();
		int y = nextInt();
		String N = y > 0 ? "N" : "S";
		String S = y < 0 ? "N" : "S";
		String E = x > 0 ? "E" : "W";
		String W = x < 0 ? "E" : "W";
		x = Math.abs(x);
		y = Math.abs(y);
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(x, y));
		Pair ans = null;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			if (x == 0 && y == 0) {
				ans = p;
				break;
			}
			if (x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0) {
				continue;
			}
			if (x % 2 != 0) {
				q.add(new Pair((x - 1) / 2, y / 2, p, E));
				q.add(new Pair((x + 1) / 2, y / 2, p, W));
			} else {
				q.add(new Pair(x / 2, (y - 1) / 2, p, N));
				q.add(new Pair(x / 2, (y + 1) / 2, p, S));
			}
		}
		if (ans == null) {
			out.println("IMPOSSIBLE");
			return;
		}

		StringBuilder sb = new StringBuilder();
		while (ans.dir != null) {
			sb.append(ans.dir);
			ans = ans.prev;
		}
		out.println(sb.reverse().toString());
	}
}
