import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

// D
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		new Solution();
	}

	public Solution() throws FileNotFoundException {
		FasterScanner sc = new FasterScanner(System.in);

		int amountOfTasks = sc.nextInt();
		for (int task = 1; task <= amountOfTasks; task++) {
			int k = sc.nextInt();
			int q = sc.nextInt();
			String s = sc.nextString();
			for (int i = 0; i < k; i++) {
				sc.nextInt();
			}
			for (int i = 0; i < k; i++) {
				sc.nextInt();
			}
			for (int i = 0; i < k; i++) {
				sc.nextInt();
			}
			int[] start = new int[q];
			int[] end = new int[q];
			for (int i = 0; i < q; i++) {
				start[i] = sc.nextInt()-1;
			}
			for (int i = 0; i < q; i++) {
				end[i] = sc.nextInt()-1;
			}
			int[] sums = new int[k];
			int sum = 0;
			for (int i = 0; i < k; i++) {
				char c = s.charAt(i);
				if (c == '(') {
					sum++;
				} else sum--;
				sums[i] = sum;
			}
			int total = 0;
			for (int i = 0; i < q; i++) {
				//System.out.println(start[i]);
				int diff = Math.abs(sums[start[i]]-sums[end[i]]);
				if (start[i] != end[i] && diff == 0) {
					diff+=2;
				}
				total += diff;
			}
			
			String solution = "Case #" + task + ": " + total;
			System.out.println(solution);
		}

		sc.close();
	}

	public class FasterScanner {
		private InputStream mIs;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FasterScanner() {
			this(System.in);
		}

		public FasterScanner(InputStream is) {
			mIs = is;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = mIs.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
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

		public void close() {
			try {
				mIs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}