import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
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
		OverexcitedFan solver = new OverexcitedFan();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class OverexcitedFan {
		PrintWriter out;
		InputReader in;
		int testcase;

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int t, i, j, tt, k;
			this.testcase = testNumber;
			this.out = out;
			this.in = in;
			pk();
			int x = in.nextInt();
			int y = in.nextInt();
			String s = in.next();
			int acx = x;
			int acy = y;
			int cc = 9999999;
			if (acx == 0 && acy == 0)
				cc = 0;
			for (i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == 'N')
					acy += 1;
				if (ch == 'S')
					acy -= 1;
				if (ch == 'E')
					acx += 1;
				if (ch == 'W')
					acx -= 1;
				if (Math.abs(acx) + Math.abs(acy) <= (i + 1))
					cc = Math.min(cc, i + 1);
			}
			if (cc == 9999999)
				pn("IMPOSSIBLE");
			else
				pn(cc);

		}

		void pn(int zx) {
			out.println(zx);
		}

		void pn(String zx) {
			out.println(zx);
		}

		void pk() {
			out.print("Case #" + (testcase) + ": ");
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

