import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

// B
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		new Solution();
	}

	public Solution() throws FileNotFoundException {
		FasterScanner sc = new FasterScanner(System.in);

		int amountOfTasks = sc.nextInt();
		/*int[][] pascal = new int[501][501];
		pascal[1][1] = 1;
		for (int i = 2; i <= 500; i++) {
			for (int j = 1; j <= i; j++) {
				if (j > 1) pascal[i][j] += pascal[i-1][j-1];
				pascal[i][j] += pascal[i-1][j];
			}
		}*/
		for (int task = 1; task <= amountOfTasks; task++) {
			int n = sc.nextInt();
			int pow = 30;
			ArrayList<String> list = new ArrayList<String>();
			boolean found = false;
			int highestPow = -1;
			boolean leftBound = true;
			while (pow >= 0) {
				int rowSum = (int) Math.pow(2, pow);
				if (!found) {
					if ((rowSum + pow) <= n) {
						highestPow = pow;
						n -= (rowSum + pow);
						if (leftBound) {
							for (int i = 1; i <= pow+1; i++) {
								list.add((pow+1) + " " + i);
							}
						} else {
							for (int i = pow+1; i >= 1; i--) {
								list.add((pow+1) + " " + i);
							}
						}
						leftBound = !leftBound;
						found = true;
					} /*else {
						if (leftBound) {
							list.add((pow+1 ) + " " + 1);
						} else {
							list.add((pow+1 ) + " " + (pow+1));
						}
					}*/
				} else {
					if ((rowSum -1) <= n) {
						n -= (rowSum - 1);
						if (leftBound) {
							for (int i = 1; i <= pow+1; i++) {
								list.add((pow+1) + " " + i);
							}
						} else {
							for (int i = pow+1; i >= 1; i--) {
								list.add((pow+1) + " " + i);
							}
						}
						leftBound = !leftBound;
					} else {
						if (leftBound) {
							list.add((pow+1 ) + " " + 1);
						} else {
							list.add((pow+1 ) + " " + (pow+1));
						}
					}
				}
				pow--;
			}
			//System.out.println(n);
			//System.out.println(list.size());
			StringBuilder sol = new StringBuilder();
			for (int i = list.size()-1; i >= 0; i--) {
				sol.append(list.get(i) + "\n");
			}
			highestPow++;
			while(n > 0) {
				highestPow++;
				sol.append(highestPow + " "  + 1 + "\n");
				n--;
			}

			String solution = "Case #" + task + ": ";
			System.out.println(solution);
			System.out.print(sol);
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