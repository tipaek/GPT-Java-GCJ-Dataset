import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class Solution {

	int limit = 1_000_000_000;

	static class TheEnd extends Exception {
		final boolean wa;

		public TheEnd(boolean wa) {
			this.wa = wa;
		}
	}

	boolean hit(Interactor interactor, long x, long y) throws TheEnd {
		if (abs(x) > limit || abs(y) > limit) {
			return false;
		}
		interactor.print(x);
		interactor.print(' ');
		interactor.print(y);
		interactor.println();
		interactor.flush();

		String result = interactor.next();

		if (result.equals("CENTER")) {
			throw new TheEnd(false);
		}

		if (result.equals("HIT")) {
			return true;
		}
		if (result.equals("MISS")) {
			return false;
		}

		if (result.equals("WRONG")) {
			throw new TheEnd(true);
		}

		throw new IllegalStateException(result);
	}

	Random random = new Random();

	long left(Interactor interactor, long x, long y) throws TheEnd {
		long l = -limit, r = x;
		if (hit(interactor, l, y)) {
			return l;
		}
		while (r - l > 1) {
			long c = (l + r) / 2;

			if (hit(interactor, c, y)) {
				r = c;
			} else {
				l = c;
			}
		}
		return r;
	}

	long right(Interactor interactor, long x, long y) throws TheEnd {
		long l = x, r = +limit;

		if (hit(interactor, r, y)) {
			return r;
		}
		while (r - l > 1) {
			long c = (l + r) / 2;

			if (hit(interactor, c, y)) {
				l = c;
			} else {
				r = c;
			}
		}
		return l;
	}

	long up(Interactor interactor, long x, long y) throws TheEnd {
		long l = y, r = +limit;

		if (hit(interactor, x, r)) {
			return r;
		}
		while (r - l > 1) {
			long c = (l + r) / 2;

			if (hit(interactor, x, c)) {
				l = c;
			} else {
				r = c;
			}
		}
		return l;
	}

	long down(Interactor interactor, long x, long y) throws TheEnd {
		long l = -limit, r = y;
		if (hit(interactor, x, l)) {
			return l;
		}
		while (r - l > 1) {
			long c = (l + r) / 2;

			if (hit(interactor, x, c)) {
				r = c;
			} else {
				l = c;
			}
		}
		return r;
	}

	void solve(Interactor interactor, long min, long max) throws TheEnd {
		long x = 0, y = 0;

		while (hit(interactor, x, y) == false) {
			x = random.nextInt(2 * limit) - limit;
			y = random.nextInt(2 * limit) - limit;
		}

		long lx = left(interactor, x, y);
		long rx = right(interactor, x, y);
		x = (lx + rx) / 2;

		long dy = down(interactor, x, y);
		long uy = up(interactor, x, y);
		y = (dy + uy) / 2;

		lx = left(interactor, x, y);
		rx = right(interactor, x, y);
		x = (lx + rx) / 2;

		for (long[] point : delta) {
			hit(interactor, x + point[0], y + point[1]);
		}

	}

	int m = 10;
	long[][] delta = new long[(2 * m + 1) * (2 * m + 1)][];

	void run(Interactor interactor) {

		{
			int index = 0;
			for (long dx = -m; dx <= m; dx++) {
				for (long dy = -m; dy <= m; dy++) {
					delta[index++] = new long[] { dx, dy };
				}
			}
			Arrays.sort(delta, Comparator.comparingLong(point -> abs(point[0] * point[0] + point[1] * point[1])));
		}

		int tests = interactor.nextInt();

		long min = interactor.nextInt();
		long max = interactor.nextInt();

		for (int test = 1; test <= tests; test++) {
			try {
				solve(interactor, min, max);
			} catch (TheEnd e) {
				if (e.wa) {
					return;
				}
			}
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