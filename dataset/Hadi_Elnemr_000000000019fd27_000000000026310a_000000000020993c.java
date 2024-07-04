import java.util.*;
import java.io.*;

public class Solution {
	static int memo[][];
	static int n, v, m, e, t;
	static ArrayList[] edgeList;
	static int[][] matrix;
	static int[][] a;
	final static int Infinity = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		t = sc.nextInt();

    	for (int x = 0; x < t; x++) {
			n = sc.nextInt();
			a = new int[n][n];
			boolean[] row, col;
			int k = 0, r = 0, c = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
					if (i == j)
						k += a[i][j];
				}
			row: for (int i = 0; i < n; i++) {
				row = new boolean[n + 1];
				for (int j = 0; j < n; j++)
					if (row[a[i][j]]) {
						r++;
						continue row;
					} else
						row[a[i][j]] = true;
			}
			col: for (int i = 0; i < n; i++) {
				col = new boolean[n + 1];
				for (int j = 0; j < n; j++)
					if (col[a[j][i]]) {
						c++;
						continue col;
					} else
						col[a[j][i]] = true;
			}
			pw.println("Case #"+(x+1)+": "+k+" "+r+" "+c);
		}

		pw.flush();
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}