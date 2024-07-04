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
		PatternMatching solver = new PatternMatching();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class PatternMatching {
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
			String s[] = new String[n];
			for (i = 0; i < n; i++) {
				s[i] = in.nextLine();
			}
			for (i = 0; i < n; i++) {
				StringBuilder sx = new StringBuilder();
				char last = ' ';
				int cp = 0;
				for (j = 0; j < s[i].length(); j++) {
					char ch = s[i].charAt(j);
					if (ch == '*') {
						cp++;
						continue;
					} else {
						if (cp > 0)
							sx.append("*");
						cp = 0;
						sx.append(ch);
					}
				}
				if (cp > 0)
					sx.append("*");
				s[i] = sx.toString();
			}
			int ind[] = new int[n];
			for (i = 0; i < n; i++) {
				ind[i] = s[i].length() - 1;
			}
			StringBuilder sb = new StringBuilder();
			boolean fl = true;
			boolean holap = true;
			while (true) {
				TreeSet<Integer> ts = new TreeSet<>();
				char op = ' ';
				int x = 0;

				for (i = 0; i < n; i++) {
					char ch = s[i].charAt(ind[i]);
					if (ch == '*')
						x++;
					else {
						ts.add(ch + 0);
						op = ch;
					}
				}
				if (x == n) {
					holap = false;
					break;
				} else {
					if (ts.size() != 1) {
						fl = false;
						break;
					}
					sb.append(op);
					for (i = 0; i < n; i++) {
						char ch = s[i].charAt(ind[i]);
						if (ch == '*')
							continue;
						ind[i]--;
					}
				}
				boolean ox = false;
				for (i = 0; i < n; i++) {
					if (ind[i] < 0)
						ox = true;
				}
				if (ox)
					break;
			}
			StringBuilder sb1 = new StringBuilder();
			if (!holap) {
				int ind1[] = new int[n];

				while (true) {
					TreeSet<Integer> ts = new TreeSet<>();
					char op = ' ';
					int x = 0;

					for (i = 0; i < n; i++) {
						char ch = s[i].charAt(ind1[i]);
						if (ch == '*')
							x++;
						else {
							ts.add(ch + 0);
							op = ch;
						}
					}
					if (x == n) {

						break;
					} else {
						if (ts.size() != 1) {
							fl = false;
							break;
						}
						sb1.append(op);
						for (i = 0; i < n; i++) {
							char ch = s[i].charAt(ind1[i]);
							if (ch == '*')
								continue;
							ind1[i]++;
						}
					}
					boolean ox = false;
					for (i = 0; i < n; i++) {
						if (ind1[i] >= s[i].length())
							ox = true;
					}
					if (ox)
						break;
				}
				for (i = 0; i < n; i++) {
					for (j = ind1[i] + 1; j < ind[i]; j++) {
						if (s[i].charAt(j) == '*')
							continue;
						sb1.append(s[i].charAt(j));
					}
				}
			}
			if (fl)
				pn(sb1.toString() + sb.reverse().toString());
			else
				pn("*");
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

		public String nextLine() {
			StringBuffer buf = new StringBuffer();
			int c = read();
			while (c != '\n' && c != -1) {
				if (c != '\r') {
					buf.appendCodePoint(c);
				}
				c = read();
			}
			return buf.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

	}
}

