import java.io.*;
import java.util.*;

public class Solution {

	static int n;
	static int[] x, y, hole, visited[];

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static class vec {
		int x, y, fac;

		vec(int a, int b) {
			int gcd = gcd(Math.abs(a), Math.abs(b));

			x = a / gcd;
			y = b / gcd;
			fac = gcd;
		}

		boolean equals(vec other) {
			return x == other.x && y == other.y;
		}

		int factor() {
			return fac;
		}
	}

	static vec getVec(int i, int j) {
		return new vec(x[j] - x[i], y[j] - y[i]);
	}

	public static int solve(int pos, int p, vec vec) {
		if (visited[pos][p] == 1)
			return 0;
		visited[pos][p]++;
		int add = visited[pos][p] + visited[pos][p ^ 1] == 1 ? 1 : 0;
		int ans = 0;
		if (p == 0) { // hole
			if (hole[pos] != -1) {
				int ret = add + solve(hole[pos], p ^ 1, vec);
				visited[pos][p]--;

				return ret;
			}
			for (int i = 0; i < n; i++) {
				if (i != pos && hole[i] == -1) {
					hole[pos] = i;
					hole[i] = pos;
					ans = Math.max(ans, solve(i, p ^ 1, vec));
					hole[pos] = -1;
					hole[i] = -1;
				}

			}
			visited[pos][p]--;
			return ans + add;
		} else {
			for (int i = 0; i < n; i++) {
				if (i == pos)
					continue;

				if (goTo(pos, vec == null ? getVec(pos, i) : vec) == i)
					ans = Math.max(ans, solve(i, p ^ 1, vec == null ? getVec(pos, i) : vec));
			}
			visited[pos][p]--;

			return ans + add;
		}

	}

	static int goTo(int pos, vec vector) {
		int ans = -1;
		int min = -1;
		for (int i = 0; i < n; i++) {
			if (i == pos)
				continue;
			vec other = getVec(pos, i);
			if (vector.equals(other))
				if (ans == -1 || other.factor() < min) {
					min = other.factor();
					ans = i;
				}

		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			out.printf("Case #%d: ", t);
			n = sc.nextInt();
			
			x = new int[n];
			y = new int[n];

			for (int i = 0; i < n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			if(n>7)
			continue;
			if (n <= 3) {
				out.println(n);
				continue;
			}
			visited = new int[n][2];
			hole = new int[n];
			Arrays.fill(hole, -1);
			int ans = 0;
			for (int pos = 0; pos < n; pos++)
				ans = Math.max(ans, solve(pos, 0, null));
			out.println(ans);

		}
		out.close();

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