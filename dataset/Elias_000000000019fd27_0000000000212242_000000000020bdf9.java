import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

// C
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		new Solution();
	}

	public Solution() throws FileNotFoundException {
		FasterScanner sc = new FasterScanner(System.in);

		int amountOfTasks = sc.nextInt();
		for (int task = 1; task <= amountOfTasks; task++) {
			int n = sc.nextInt();
			Pair[] pairs = new Pair[n];
			for (int i = 0; i < n; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				pairs[i] = new Pair(i, start, end);
			}
			sorting = true;
			Arrays.sort(pairs);

			boolean cTurn = true;
			int cEnd = 0;
			int jEnd = 0;
			boolean poss = true;
			for (int i = 0; i < n; i++) {
				Pair p = pairs[i];
				int s = p.start;
				int e = p.end;
				if (cTurn) {
					if (s < cEnd) poss = false;
					cEnd = e;
					p.person = 'C';
				} else {
					if (s < jEnd) poss = false;
					jEnd = e;
					p.person = 'J';
				}
				if (cEnd <= jEnd) cTurn = true;
				else cTurn = false;
			}
			
			sorting = false;
			Arrays.sort(pairs);
			String sol = "IMPOSSIBLE";
			if (poss) {
				StringBuilder sb = new StringBuilder("");
				for (int i = 0; i < n; i++) {
					sb.append(pairs[i].person);
				}
				sol = sb.toString();
			}
			
			String solution = "Case #" + task + ": " + sol;
			System.out.println(solution);
		}

		sc.close();
	}

	private boolean sorting = true;

	class Pair implements Comparable<Pair> {
		int start, end, index;
		char person;

		public Pair(int i, int s, int e) {
			start = s;
			end = e;
			index = i;
		}

		public int compareTo(Pair p) {
			if (sorting) {
				if (this.start != p.start) {
					return this.start - p.start;
				} else {
					return this.end - p.end;
				}
			} else {
				return this.index - p.index;
			}
		}
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