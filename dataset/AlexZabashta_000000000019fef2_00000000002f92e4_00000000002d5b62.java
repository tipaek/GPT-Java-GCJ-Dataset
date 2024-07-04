import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class Solution {

	Random random = new Random();

	String solve(long x, long y, int d) {
		StringBuilder builder = new StringBuilder();

		while (--d >= 0) {
			long ax = abs(x);
			long ay = abs(y);

			long step = 1L << d;

			if (ax > ay) {
				if (x < 0) {
					x += step;
					builder.append('W');
				} else {
					x -= step;
					builder.append('E');
				}
			} else {
				if (y < 0) {
					builder.append('S');
					y += step;
				} else {
					builder.append('N');
					y -= step;
				}
			}
		}

		if (x == 0 && y == 0) {
			return builder.reverse().toString();
		} else {
			return null;
		}
	}

	String solve(int x, int y) {
		for (int d = 1; d <= 50; d++) {
			String string = solve(x, y, d);
			if (string != null) {
				return string;
			}
		}
		return null;
	}

	void run(Interactor interactor) {

		int tests = interactor.nextInt();
		for (int test = 1; test <= tests; test++) {
			int x = interactor.nextInt();
			int y = interactor.nextInt();

			String ans = solve(x, y);
			if (ans == null) {
				ans = "IMPOSSIBLE";
			}
			interactor.printf(Locale.ENGLISH, "Case #%d: %s%n", test, ans);
		}

	}

	static class Interactor extends PrintWriter {

		final BufferedReader reader;

		StringTokenizer tokenizer = new StringTokenizer("");

		public Interactor(InputStream inputStream, OutputStream outputStream) {
			super(outputStream);
			this.reader = new BufferedReader(new InputStreamReader(inputStream));
		}

		@Override
		public void close() {
			super.close();
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		boolean hasNext() {
			while (!tokenizer.hasMoreTokens()) {
				String line = nextLine();
				if (line == null) {
					return false;
				}
				tokenizer = new StringTokenizer(line);
			}
			return true;
		}

		String next() {
			while (!tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(nextLine());
			return tokenizer.nextToken();
		}

		int[] nextArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}
			return array;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException err) {
				return null;
			}
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		int[][] nextMatrix(int n, int m) {
			int[][] matrix = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					matrix[i][j] = nextInt();
			return matrix;
		}

		boolean skip() {
			while (hasNext()) {
				next();
			}
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		try (Interactor interactor = new Interactor(System.in, System.out)) {
			new Solution().run(interactor);
		}
	}

}