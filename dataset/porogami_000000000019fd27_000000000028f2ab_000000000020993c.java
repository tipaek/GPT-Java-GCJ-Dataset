import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.lang.Math.*;

public class vestigium {
	public static void main(String[] args) throws Exception {
		int t = i();
		for (int tt = 0; tt < t; tt++) {
			int n = i();
			int mat[][] = new int[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					mat[r][c] = i();
				}
			}

			int trace = 0;
			for (int i = 0; i < n; i++) {
				trace += mat[i][i];
			}

			int rows = 0, cols = 0;
			for (int r = 0; r < n; r++) {
				TreeSet<Integer> s = new TreeSet<>();
				for (int c = 0; c < n; c++) {
					s.add(mat[r][c]);
				}

				if (s.size() < n) rows++;
			}
			for (int c = 0; c < n; c++) {
				TreeSet<Integer> s = new TreeSet<>();
				for (int r = 0; r < n; r++) {
					s.add(mat[r][c]);
				}

				if (s.size() < n) cols++;
			}

			out.printf("Case #%d: %d %d %d%n", tt + 1, trace, rows, cols);
		}

		out.close();
	}

	static BufferedReader in;
	static StringTokenizer st = new StringTokenizer("");
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static {
		try {
			in = Files.newBufferedReader(Paths.get("test.in"));
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	static void check() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
	}
	static String s() throws Exception { check(); return st.nextToken(); }
	static int i() throws Exception { return Integer.parseInt(s()); }
	static long l() throws Exception { return Long.parseLong(s()); }
	static double d() throws Exception { return Double.parseDouble(s()); }
}
