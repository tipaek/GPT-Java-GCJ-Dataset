import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Indrajit Sinha
 */
public class Solution {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Vestigium solver = new Vestigium();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class Vestigium {
		PrintWriter out;
		InputReader in;
		int testcase;
		int n;

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int t, i, j, tt, k;
			this.testcase = testNumber;
			this.out = out;
			this.in = in;
			pk();
			n = in.nextInt();
			int a[][] = new int[n][n];
			int s = 0;
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					a[i][j] = in.nextInt();
					if (i == j)
						s += a[i][j];
				}
			}
			int r = 0;
			int c = 0;
			for (i = 0; i < n; i++) {
				int fr = 0;
				int fc = 0;
				TreeSet<Integer> ts1 = new TreeSet<>();
				TreeSet<Integer> ts2 = new TreeSet<>();
				for (j = 0; j < n; j++) {
					if (ts1.contains(a[i][j]))
						fr = 1;
					if (ts2.contains(a[j][i]))
						fc = 1;
					ts1.add(a[i][j]);
					ts2.add(a[j][i]);
				}
				r += fr;
				c += fc;
			}
			p(s);
			p(r);
			p(c);
			pn("");

		}

		void pn(String zx) {
			out.println(zx);
		}

		void pk() {
			out.print("Case #" + (testcase) + ": ");
		}

		void p(int zx) {
			out.print(zx + " ");
		}

	}

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new UnknownError();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new UnknownError();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String next() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuffer res = new StringBuffer();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));

			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

	}
}

