import java.io.*;
import java.util.*;

public class Solution {

	static char[] ans, best;

	static char[] dir = "SWEN".toCharArray();
	static int INF = (int) 1e9;

	static PrintWriter out = new PrintWriter(System.out);

	static ArrayList<String> cand;

	static int offset = 1030;
	static int[][][] memo;

	static int dp(int idx, int x, int y) {
		if (x == 0 && y == 0)
			return 0;

		if (idx == 10)
			return INF;
		if (memo[idx][x + offset][y + offset] != -1)
			return memo[idx][x + offset][y + offset];
		int ans = INF;
		int val = 1 << idx;
		for (char c : dir) {
			int x2 = x, y2 = y;

			if (c == 'S')
				y2 += val;
			else if (c == 'N')
				y2 -= val;
			else if (c == 'E')
				x2 -= val;
			else if (c == 'W')
				x2 += val;
			ans = Math.min(1 + dp(idx + 1, x2, y2), ans);
		}
		return memo[idx][x + offset][y + offset] = ans;
	}

	static void print(int idx, int x, int y) {
		if (x == 0 && y == 0)
			return;

		int ans = dp(idx, x, y);
		int val = 1 << idx;
		for (char c : dir) {
			int x2 = x, y2 = y;

			if (c == 'S')
				y2 += val;
			else if (c == 'N')
				y2 -= val;
			else if (c == 'E')
				x2 -= val;
			else if (c == 'W')
				x2 += val;
			if (ans == 1 + dp(idx + 1, x2, y2)) {
				out.print(c);
				print(idx + 1, x2, y2);
				break;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		int tc = sc.nextInt();
		memo = new int[10][2 * offset + 1][2 * offset + 1];
		for (int[][] x2 : memo)
			for (int[] x : x2)
				Arrays.fill(x, -1);
		for (int t = 1; t <= tc; t++) {

			out.printf("Case #%d: ", t);
			int x = sc.nextInt(), y = sc.nextInt();
			int ans = dp(0, x, y);
			if (ans >= INF)
				out.println("IMPOSSIBLE");
			else {
				print(0, x, y);
				out.println();
			}

		}
		out.close();

	}

	private static boolean solve(String s, int x, int y) {
		for (int i = 0; i < s.length(); i++) {
			int val = 1 << i;
			if (s.charAt(i) == 'S')
				y += val;
			else if (s.charAt(i) == 'N')
				y -= val;
			else if (s.charAt(i) == 'E')
				x -= val;
			else if (s.charAt(i) == 'W')
				x += val;

		}
		return x == 0 && y == 0;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

		int[] nxtArr(int n) throws IOException {
			int[] ans = new int[n];
			for (int i = 0; i < n; i++)
				ans[i] = nextInt();
			return ans;
		}

	}

	static void sort(int[] a) {
		shuffle(a);
		Arrays.sort(a);
	}

	static void shuffle(int[] a) {
		int n = a.length;
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int tmpIdx = rand.nextInt(n);
			int tmp = a[i];
			a[i] = a[tmpIdx];
			a[tmpIdx] = tmp;
		}
	}

}