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
		NestingDepth solver = new NestingDepth();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class NestingDepth {
		PrintWriter out;
		InputReader in;
		int testcase;

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int t, i, j, tt, k;
			this.testcase = testNumber;
			this.out = out;
			this.in = in;
			pk();
			String s = in.next();
			int curr = 0;
			StringBuilder sb = new StringBuilder();
			for (i = 0; i < s.length(); i++) {
				int ch = s.charAt(i) - '0';
				while (curr > ch) {
					sb.append(")");
					curr--;
				}
				while (curr < ch) {
					sb.append("(");
					curr++;
				}
				sb.append(s.charAt(i));
			}
			while (curr != 0) {
				sb.append(")");
				curr--;
			}
			pn(sb.toString());

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

