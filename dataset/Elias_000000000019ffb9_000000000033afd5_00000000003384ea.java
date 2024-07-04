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
			long l = sc.nextLong();
			long r = sc.nextLong();
			long n = 0;
			
			//BS
			long diff = Math.abs(l-r);
			long first_amount = (long) Math.sqrt(2*diff);
			n += first_amount;
			long first_total = first_amount*(first_amount+1)/2;
			if (l >= r) {
				l -= first_total;
				if (l < 0) {
					l += first_amount;
					n--;
				}
			} else {
				r -= first_total;
				if (r < 0) {
					r += first_amount;
					n--;
				}
			}
			//System.out.println(n + " " + l + " " + r);
			
			//L
			long nextVal = first_amount+1;
			if (l < r) {
				nextVal++;
			} 
			long[] result = getVal(nextVal, l);
			long newL = result[0];
			n += result[1];
			
			//R
			nextVal = first_amount+1;
			if (l >= r) {
				nextVal++;
			}
			result = getVal(nextVal, r);
			long newR = result[0];
			n += result[1];
					
			String solution = "Case #" + task + ": " + n + " " + newL + " " + newR;
			System.out.println(solution);
		}

		sc.close();
	}
	
	private long[] getVal(long start, long total) {
		long[] result = new long[2];
		long min = 0;
		long max = (long)Math.sqrt(total)*4+4;
		long mid = 0;
		while(min < max) {
			mid = (min+max+1)/2;
			if (mid*mid + (start-1)*mid <= total) {
				min = mid;
			} else {
				max = mid-1;
			}
		}
		mid = min;
		//System.out.println(min + " " + max);
		//System.out.println(start + " " + total + " " + mid);
		result[0] = total - start*mid - mid*(mid-1);
		result[1] = mid;
		return result;
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