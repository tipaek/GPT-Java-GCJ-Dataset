import java.util.*;
import java.io.*;
import java.text.*;

public class Vestigium {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		int tc = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int trace = 0;
			HashSet<Integer>[] rows = new HashSet[n];
			HashSet<Integer>[] cols = new HashSet[n];
			for (int i = 0; i < cols.length; i++) {
				rows[i] = new HashSet<Integer>();
				cols[i] = new HashSet<Integer>();
			}
			for (int i = 0; i < cols.length; i++) {
				for (int j = 0; j < cols.length; j++) {
					rows[i].add(arr[i][j]);
					cols[j].add(arr[i][j]);
					if (i == j)
						trace += arr[i][j];
				}
			}
			int r = 0, c = 0;
			for (int i = 0; i < cols.length; i++) {
				if (rows[i].size() != n)
					r++;
				if (cols[i].size() != n)
					c++;

			}
			pw.printf("Case #%d: %d %d %d%n", tc++, trace, r, c);
		}
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = nextInt();
			return arr;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
