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
		int lower = nextInt();
		int higher = nextInt();
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
	final int RAD = SIZE / 2;
	final String CENTER = "CENTER";
	final String HIT = "HIT";
	final String MISS = "MISS";

	private void solve() {
		Random rand = new Random(12345);
		double sx = 0;
		double sy = 0;
		int hits = 0;
		for (int i = 0; i < 500 - 81; i++) {
			int side = rand.nextInt(4);
			int x = SIZE - rand.nextInt(51);
			int y = rand.nextInt(2 * SIZE + 1) - SIZE;
			if (side % 2 == 0) {
				x = -x;
			}
			if (side / 2 == 0) {
				int t = x;
				x = y;
				y = t;
			}
			out.println(x + " " + y);
			out.flush();
			String token = nextToken();
			if (token.equals(CENTER)) {
				return;
			}
			if (token.equals(HIT)) {
				sx += x;
				sy += y;
				hits++;
			}
		}
		int cx = (int) Math.round(sx / hits);
		int cy = (int) Math.round(sy / hits);
		for (int x = cx - 4; x <= cx + 4; x++) {
			for (int y = cy - 4; y <= cy + 4; y++) {
				out.println(x + " " + y);
				out.flush();
				String token = nextToken();
				if (token.equals(CENTER)) {
					return;
				}
			}
		}
	}
}
