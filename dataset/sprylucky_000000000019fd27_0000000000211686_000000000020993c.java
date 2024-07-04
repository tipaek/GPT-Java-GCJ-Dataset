import java.util.*;
import java.io.*;

public class Solution {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		for (int z = 1; z <= test; ++z) {
			int n = t.nextInt();
			int[][] a = new int[n][n];
			HashSet<Integer> mapr[] = new HashSet[n];
			HashSet<Integer> mapc[] = new HashSet[n];
			int countr = 0, countc = 0, trace = 0;

			for (int i = 0; i < n; ++i) {
				mapr[i] = new HashSet<>();
				mapc[i] = new HashSet<>();
			}

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					a[i][j] = t.nextInt();

					mapr[i].add(a[i][j]);
					mapc[j].add(a[i][j]);

					if (i == j)
						trace += a[i][j];
				}
			}

			for (int i = 0; i < n; ++i) {
				if (mapr[i].size() != n)
					countr++;

				if (mapc[i].size() != n)
					countc++;
			}

			o.println("Case #" + z + ": " + trace + " " + countr + " " + countc);
		}
		o.flush();
		o.close();
	}
}