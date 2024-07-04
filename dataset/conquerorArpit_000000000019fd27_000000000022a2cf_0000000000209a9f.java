import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
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

		public int[] intArray(int n) {
			Reader r = new Reader();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = r.nextInt();
			}
			return arr;
		}

		public long[] longArray(int n) {
			Reader r = new Reader();
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = r.nextInt();
			}
			return arr;
		}

		public void printArray(int arr[]) {
			PrintWriter out = new PrintWriter(System.out);
			for (int i = 0; i < arr.length; i++) {
				if (i == arr.length - 1)
					out.println(arr[i]);
				else
					out.print(arr[i] + " ");
			}
			out.close();
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

			String s = r.next();

			int arr[] = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				arr[i] = s.charAt(i) - '0';
			}

			StringBuilder res = new StringBuilder();

			int prev = 0;

			for (int i = 0; i < arr.length; i++) {

				int diff = arr[i] - prev;

				if (diff == 0) {
					res.append(arr[i]);
				} else if (diff > 0) {
					res.append(String.join("", Collections.nCopies(diff, "("))).append(arr[i]);
				} else {
					res.append(String.join("", Collections.nCopies(-diff, ")"))).append(arr[i]);
				}

				prev = arr[i];

			}

			if (prev > 0) {
				res.append(String.join("", Collections.nCopies(prev, ")")));
			}

			ans.append("Case #").append(j++).append(": ").append(res).append("\n");
		}

		System.out.print(ans);

	}

}