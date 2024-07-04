import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static class P implements Comparable<P> {
		int i, j, cost;

		public P(int ii, int jj, int c) {
			i = ii;
			j = jj;
			cost = c;
		}

		@Override
		public int compareTo(P arg0) {
			if (i == arg0.i)
				return j - arg0.j;
			return i - arg0.i;
		}
	}

	static boolean[][] vis;
	static int[] dx = { -1, -1, 0, 0, 1, 1 };
	static int[] dy = { -1, 0, -1, +1, 0, +1 };
	static int target;
	static long[][] nCr;
	static Stack<Point> stack;
	static Stack<Point> res;
	static boolean solved = false;

	static boolean go(int i, int j, long sum) {
		if (solved)
			return true;
		if (sum > target)
			return false;
		if (sum == target) {
			while (!stack.isEmpty()) {
				res.add(stack.pop());
			}
			solved = true;
			return true;
		}
		for (int k = 0; k < dx.length; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			if (ni >= 0 && nj >= 0 && nj <= ni && ni < max && nj < max
					&& !vis[ni][nj]) {
				stack.push(new Point(ni, nj));
				vis[i][j] = true;
				boolean can = go(ni, nj, sum + nCr[ni][nj]);
				if (can)
					return true;
				stack.pop();
				vis[ni][nj] = false;
			}
		}
		return false;
	}

	static int max = 1000;
	static long extra = (long) (1e9 + 50);

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int T = r.nextInt();
		int test = 1;
		nCr = new long[max][max];
		nCr[0][0] = 1;
		for (int i = 1; i < nCr.length; i++) {
			nCr[i][0] = 1;
			nCr[i][i] = 1;
			for (int j = 1; j < i; j++) {
				nCr[i][j] = nCr[i - 1][j] + nCr[i - 1][j - 1];
				if (nCr[i][j] > extra)
					nCr[i][j] = extra;
			}
		}
		Random rand = new Random();
		while (T-- > 0) {
			target = r.nextInt();
//			target = Math.abs(rand.nextInt())%1000000000;
//			target++;
//			System.out.println(target);
			stack = new Stack<Point>();
			stack.push(new Point(0, 0));
			vis = new boolean[max][max];
			vis[0][0] = true;
			res = new Stack<Point>();
			solved = false;
			go(0, 0, 1);
			System.out.printf("Case #%d:\n", test++);
			while (!res.isEmpty()) {
				Point p = res.pop();
				System.out.println(p.x + 1 + " " + (p.y + 1));
			}
		}
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
