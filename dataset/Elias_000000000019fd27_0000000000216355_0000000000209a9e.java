import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

// D
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		new Solution();
	}

	public Solution() throws FileNotFoundException {
		FasterScanner sc = new FasterScanner(System.in);

		int amountOfTasks = sc.nextInt();
		int b = sc.nextInt();
		for (int task = 1; task <= amountOfTasks; task++) {
			int[] array = new int[b];
			int[] same = new int[b]; // same == 1, diff == 2
			Arrays.fill(array, -1);
			for (int i = 1; i <= 5; i++) {
				System.out.println(i);
				array[i - 1] = sc.nextInt();
			}
			for (int i = 1; i <= 5; i++) {
				System.out.println(b - i + 1);
				array[b - i] = sc.nextInt();
			}
			int sameIndex = -1;
			int diffIndex = -1;
			for (int i = 0; i < 5; i++) {
				if (array[i] == array[b - i - 1]) {
					same[i] = 1;
					same[b - i - 1] = 1;
					if (sameIndex == -1) {
						sameIndex = i;
					}
				} else {
					if (diffIndex == -1) {
						diffIndex = i;
					}
					same[i] = 2;
					same[b - i - 1] = 2;
				}
			}

			int index = 6;
			int nextIndex = 6;
			while (nextIndex*2 <= b) {
				if (index % 5 == 1) {
					int[] newArray = (int[]) array.clone();
					if (sameIndex != -1) {
						System.out.println(sameIndex + 1);
						int val = sc.nextInt();
						boolean change = val != array[sameIndex];
						if (change) {
							for (int i = 0; i < b; i++) {
								if (same[i] == 1) {
									newArray[i] = 1-array[i];
								}
							}
						}
					} else {
						System.out.println(1);
						sc.nextInt();
					}
					if (diffIndex != -1) {
						System.out.println(diffIndex + 1);
						int val = sc.nextInt();
						boolean change = val != array[diffIndex];
						if (change) {
							for (int i = 0; i < b; i++) {
								if (same[i] == 2) {
									newArray[i] = 1-array[i];
								}
							}
						}
					} else {
						System.out.println(1);
						sc.nextInt();
					}
					array = newArray;
				} else {
					System.out.println(nextIndex);
					int val1 = sc.nextInt();
					System.out.println(b-nextIndex+1);
					int val2 = sc.nextInt();
					array[nextIndex-1] = val1;
					array[b-nextIndex] = val2;
					if (val1 == val2) {
						if (sameIndex == -1) {
							sameIndex = nextIndex-1;
						}
						same[nextIndex-1] = 1;
						same[b-nextIndex] = 1;
					} else {
						if (diffIndex == -1) {
							diffIndex = nextIndex-1;
						}
						same[nextIndex-1] = 2;
						same[b-nextIndex] = 2;
					}
					nextIndex++;
				}
				index++;
			}
			StringBuilder sol = new StringBuilder("");
			for (int i = 0; i < b; i++) {
				sol.append(array[i]);
			}
			System.out.println(sol);
			String verdict = sc.nextString();
			if (verdict.equals("N")) {
				break;
			}
			//String solution = "Case #" + task + ": ";
			//System.out.println(solution);
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