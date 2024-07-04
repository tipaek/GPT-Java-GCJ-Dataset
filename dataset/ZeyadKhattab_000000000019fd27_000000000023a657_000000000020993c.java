import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nxtArr(n);
			long trace = 0;
			for (int i = 0; i < n; i++)
				trace += a[i][i];
			int rows = 0;
			int[] cnt = new int[n + 1];
			for (int i = 0; i < n; i++) {
				Arrays.fill(cnt, 0);
				boolean distinct = true;
				for (int x : a[i])
					if (++cnt[x] > 1)
						distinct = false;
				if (!distinct)
					rows++;

			}
			int cols = 0;
			for (int j = 0; j < n; j++) {
				Arrays.fill(cnt, 0);
				boolean distinct = true;
				for (int i = 0; i < n; i++)
					if (++cnt[a[i][j]] > 1)
						distinct = false;
				if (!distinct)
					cols++;
			}
			out.printf("Case #%d: %d %d %d\n", t, trace, rows, cols);
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