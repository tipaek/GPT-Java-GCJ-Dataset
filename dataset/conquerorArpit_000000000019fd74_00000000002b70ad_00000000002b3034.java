import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {

	static class Reader {

		private InputStream mIs;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public Reader() {
			this(System.in);
		}

		public Reader(InputStream is) {
			mIs = is;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();

			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = mIs.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String next() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}

	public static void main(String[] args) throws IOException {

		Reader r = new Reader();

		int t = r.nextInt();
		int j = 1;
		StringBuilder ans = new StringBuilder();

		while (t-- > 0) {

			int n = r.nextInt();

			String st[] = new String[n];

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st[i] = r.next();
				if (st[i].length() > max) {
					max = st[i].length();
				}
			}

			char str[][] = new char[n][max];
			for (int i = 0; i < n; i++) {
				int l = 0;
				for (; l < (max - st[i].length()); l++) {
					str[i][l] = '*';
				}
				for (int k = 0; k < st[i].length(); k++) {
					str[i][l++] = st[i].charAt(k);
				}
			}

			String res = "";
			for (int i = 0; i < max; i++) {
				HashSet<Character> occ = new HashSet<Character>();
				for (int l = 0; l < n; l++) {
					occ.add(str[l][i]);
				}

				if (occ.size() > 2) {
					res = "*";
					break;
				} else {

					if (occ.contains('*')) {
						occ.remove('*');
					}

					if (occ.size() > 1) {
						res = "*";
						break;
					} else if (occ.size() == 1) {
						for (Character character : occ) {
							res += character;
						}
					} else {
						res += 'A';
					}

				}
			}

			ans.append("Case #").append(j++).append(": ").append(res).append("\n");
		}

		System.out.print(ans);

	}

}