import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

// C
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		new Solution();
	}
	
	private boolean[][] memo;

	public Solution() throws FileNotFoundException {
		FasterScanner sc = new FasterScanner(System.in);

		int amountOfTasks = sc.nextInt();
		for (int task = 1; task <= amountOfTasks; task++) {
			int n = sc.nextInt();
			Pair[] pairs = new Pair[n];
			for (int i = 0; i < n; i++) {
				long x = sc.nextLong();
				long y = sc.nextLong();
				pairs[i] = new Pair(x, y);
			}
			int result = 4;
			memo = new boolean[n][n];
			if (n > 4) {
				for (int i = 0; i < n; i++) {
					for (int j = i+1; j < n; j++) {
						if (memo[i][j]) continue;
						memo[i][j] = true;
						Pair p1 = pairs[i];
						Pair p2 = pairs[j];
						long f = p2.y-p1.y;
						long s = p2.x-p1.x;
						long cd = gcd(f, s);
						f /= cd;
						s /= cd;
						long[] rico = new long[]{f,s};
						boolean[] done = new boolean[n];
						done[i] = true;
						done[j] = true;
						int evenwijdig = getAmountEvenwijdig(pairs, done, n, rico);
						result = Math.max(result, evenwijdig+2);
					}
				}
			} else result = n;
			result = Math.min(result, n);
			
			String solution = "Case #" + task + ": " + result;
			System.out.println(solution);
		}

		sc.close();
	}
	
	private int getAmountEvenwijdig(Pair[] pairs, boolean[] done, int n, long[] rico) {
		int sol = 2;
		for (int i = 0; i < n; i++) {
			if (done[i]) continue;
			for (int j = i+1; j < n; j++) {
				if (done[j]) continue;
				Pair p1 = pairs[i];
				Pair p2 = pairs[j];
				long f = p2.y-p1.y;
				long s = p2.x-p1.x;
				long cd = gcd(f, s);
				f /= cd;
				s /= cd;
				long[] cRico = new long[]{f,s};
				if (rico[0]*cRico[1] == rico[1]*cRico[0]) {
					memo[i][j] = true;
					done[i] = true;
					done[j] = true;
					//System.out.println(i + " " + j + " " + f + " " + s);
					sol += 2;
				}
			}
		}
		return sol;
	}
	
	private long gcd(long a, long b) {
		if (b==0) return a;
		else return gcd(b, a%b);
	}
	
	class Pair{
		long x;
		long y;
		public Pair(long a, long b) {
			this.x = a;
			this.y = b;
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