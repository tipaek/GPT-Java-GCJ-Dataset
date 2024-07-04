import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.TreeSet;

// C
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		new Solution();
	}

	public Solution() throws FileNotFoundException {
		FasterScanner sc = new FasterScanner(System.in);

		int amountOfTasks = sc.nextInt();
		for (int task = 1; task <= amountOfTasks; task++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			long[][] dancers = new long[r][c];
			long partSum = 0;
			TreeSet<Long> toDo = new TreeSet<Long>();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					long val = sc.nextInt();
					dancers[i][j] = val;
					toDo.add(((long) i) * 1000000L + j);
					partSum += val;
				}
			}
			boolean changed = true;
			long sum = 0;

			while (changed) {
				//System.out.println("hello");
				sum += partSum;
				changed = false;
				TreeSet<Long> newToDo = new TreeSet<Long>();
				TreeSet<Long> toChange = new TreeSet<Long>();
				for (long l : toDo) {
					int i = (int) (l / 1000000L);
					int j = (int) (l % 1000000L);
					long val = dancers[i][j];

					//sum += val;
					long neighbourSum = 0;
					long neighbourCount = 0;
					TreeSet<Long> possNew = new TreeSet<Long>();
					int index = i - 1;
					boolean found = false;
					while (index >= 0 && !found) {
						if (dancers[index][j] != -1) {
							neighbourCount++;
							neighbourSum += dancers[index][j];
							possNew.add(((long) index) * 1000000L + j);
							found = true;
						}
						index--;
					}
					index = i + 1;
					found = false;
					while (index < r && !found) {
						if (dancers[index][j] != -1) {
							neighbourCount++;
							neighbourSum += dancers[index][j];
							possNew.add(((long) index) * 1000000L + j);
							found = true;
						}
						index++;
					}
					index = j - 1;
					found = false;
					while (index >= 0 && !found) {
						if (dancers[i][index] != -1) {
							neighbourCount++;
							neighbourSum += dancers[i][index];
							possNew.add(((long) i) * 1000000L + index);
							found = true;
						}
						index--;
					}
					index = j + 1;
					found = false;
					while (index < c && !found) {
						if (dancers[i][index] != -1) {
							neighbourCount++;
							neighbourSum += dancers[i][index];
							possNew.add(((long) i) * 1000000L + index);
							found = true;
						}
						index++;
					}
					if ((neighbourCount > 0) && ((neighbourCount * val) < neighbourSum)) {
						// System.out.println("hello");
						toChange.add(l);
						partSum -= val;
						for (long k: possNew) {
							newToDo.add(k);
						}
						changed = true;
					}
				}
				for (long l: toChange) {
					int i = (int) (l / 1000000L);
					int j = (int) (l % 1000000L);
					dancers[i][j] = -1;
				}
				toDo = newToDo;

				/*changed = false;
				long[][] newDancers = new long[r][c];
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						
						 for (int k = 0; k < r; k++) { String s = ""; for (int
						 l = 0; l < c; l++) { s += " " + dancers[k][l]; }
						 System.out.println(s); }
						 
						long val = dancers[i][j];
						if (val == -1) {
							newDancers[i][j] = -1;
							continue;
						}
						sum += val;
						long neighbourSum = 0;
						long neighbourCount = 0;
						int index = i - 1;
						boolean found = false;
						while (index >= 0 && !found) {
							if (dancers[index][j] != -1) {
								neighbourCount++;
								neighbourSum += dancers[index][j];
								found = true;
							}
							index--;
						}
						index = i + 1;
						found = false;
						while (index < r && !found) {
							if (dancers[index][j] != -1) {
								neighbourCount++;
								neighbourSum += dancers[index][j];
								found = true;
							}
							index++;
						}
						index = j - 1;
						found = false;
						while (index >= 0 && !found) {
							if (dancers[i][index] != -1) {
								neighbourCount++;
								neighbourSum += dancers[i][index];
								found = true;
							}
							index--;
						}
						index = j + 1;
						found = false;
						while (index < c && !found) {
							if (dancers[i][index] != -1) {
								neighbourCount++;
								neighbourSum += dancers[i][index];
								found = true;
							}
							index++;
						}
						if ((neighbourCount > 0) && ((neighbourCount * val) < neighbourSum)) {
							// System.out.println("hello");
							changed = true;
							newDancers[i][j] = -1;
						} else {
							newDancers[i][j] = dancers[i][j];
						}
					}
				}
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						dancers[i][j] = newDancers[i][j];
					}
				}*/
			}

			String solution = "Case #" + task + ": " + sum;
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