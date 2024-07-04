import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

// A
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		new Solution();
	}

	public Solution() throws FileNotFoundException {
		FasterScanner sc = new FasterScanner(System.in);

		int amountOfTasks = sc.nextInt();
		for (int task = 1; task <= amountOfTasks; task++) {
			int n = sc.nextInt();
			String[] p = new String[n];
			for (int i = 0; i < n; i++) {
				p[i] = sc.nextString();
			}
			String longestStart = "";
			String longestEnd = "";
			for (int i = 0; i < n; i++) {
				String pattern = p[i];
				int lastAsterisk = -1;
				for (int j = 0; j < pattern.length(); j++) {
					char c = pattern.charAt(j);
					if (c == '*') {
						if (lastAsterisk == -1 && longestStart.length() < j) {
							longestStart = pattern.substring(0, j);
						}
						lastAsterisk = j;
					}
				}
				if (lastAsterisk < (pattern.length()-1) && (pattern.length()-lastAsterisk-1 > longestEnd.length())) longestEnd = pattern.substring(lastAsterisk+1);
			}
			
			boolean poss = true;
			for (int i = 0; i < n; i++) {
				String pattern = p[i];
				int lastAsterisk = -1;
				for (int j = 0; j < pattern.length(); j++) {
					char c = pattern.charAt(j);
					if (c == '*') {
						if (lastAsterisk == -1) {
							String startPattern = pattern.substring(0, j);
							if (longestStart.length() > 0 && !longestStart.substring(0, j).equals(startPattern)) poss = false;
						}
						lastAsterisk = j;
					}
				}
				if (lastAsterisk < (pattern.length()-1)) {
					String endPattern = pattern.substring(lastAsterisk+1);
					if (longestEnd.length() > 0 && !longestEnd.substring(longestEnd.length()-endPattern.length()).equals(endPattern)) poss = false;
				}
			}
			String sol = "*";
			if (poss) {
				StringBuilder sb = new StringBuilder();
				sb.append(longestStart);
				for (int i = 0; i < n; i++) {
					String pattern = p[i];
					int lastAsterisk = -1;
					int firstAsterisk = -1;
					for (int j = 0; j < pattern.length(); j++) {
						char c = pattern.charAt(j);
						if (c == '*') {
							if (firstAsterisk == -1) {
								firstAsterisk = j;
							}
							lastAsterisk = j;
						}
					}
					if (firstAsterisk != lastAsterisk) {
						for (int j = firstAsterisk+1; j < lastAsterisk; j++) {
							char c = pattern.charAt(j);
							if (c != '*') sb.append(c);
						}
					}
				}
				sb.append(longestEnd);
				sol = sb.toString();
			} 
			
			String solution = "Case #" + task + ": " + sol;
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