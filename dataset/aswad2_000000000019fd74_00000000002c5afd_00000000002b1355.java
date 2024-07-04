import java.util.*;
import java.io.*;

public class Solution {
	long[][] mat;
	boolean[][] in;
	int row, col;

	public void run() throws Exception {
		FastReader file = new FastReader();
		int times = file.nextInt();
		for (int asdf = 0; asdf < times; asdf++) {
			row = file.nextInt();
			col = file.nextInt();
			mat = new long[row][col];
			in = new boolean[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					mat[i][j] = file.nextLong();
					in[i][j] = true;
				}
			}
			int xx = 0;
			int tot = 0;
			while (true) {
				long a = 0, b = 0, c = 0, d = 0;
				int countFail = 0;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (mat[i][j] != -1) {
							tot += mat[i][j];
								a = SearchUp(i, j);
								b = SearchDown(i, j);
								c = SearchRight(i, j);
								d = SearchLeft(i, j);
							
							long sum = 0;
							long count = 0;
							if (a != -1) {
								sum += a;
								count++;
							}
							if (b != -1) {
								sum += b;
								count++;
							}
							if (c != -1) {
								count++;
								sum += c;
							}
							if (d != -1) {
								sum += d;
								count++;
							}
							
							double avg = count == 0 ? 0 : (double) sum / (double) count;
							if (mat[i][j] < avg) {
								in[i][j] = false;
								countFail++;
							}

						}
					}
				}
				// System.out.println(countFail);

				for (int i = 0; i < mat.length; i++) {
					for (int j = 0; j < mat[i].length; j++) {
						if (!in[i][j])
							mat[i][j] = -1;
					}
				}
//				if (xx == 0 || xx == 1) {
//					for (int[] tt : mat)
//						System.out.println(Arrays.toString(tt));
//					xx++;
//					System.out.println(countFail);
//				}
				if (countFail == 0)
					break;
			}
			System.out.println("Case #" + (asdf + 1) + ": " + tot);
		}
	}

	public long SearchUp(int i, int j) {
		for (int k = i - 1; k >= 0; k--) {
			if (mat[k][j] != -1)
				return mat[k][j];
		}
		return -1;
	}

	public long SearchDown(int i, int j) {
		for (int k = i + 1; k < mat.length; k++) {
			if (mat[k][j] != -1)
				return mat[k][j];
		}
		return -1;
	}

	public long SearchRight(int i, int j) {
		for (int k = j + 1; k < mat[i].length; k++) {
			if (mat[i][k] != -1)
				return mat[i][k];
		}
		return -1;
	}

	public long SearchLeft(int i, int j) {
		for (int k = j - 1; k >= 0; k--) {
			if (mat[i][k] != -1)
				return mat[i][k];
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		new Solution().run();
	}

	static class Thing implements Comparable<Thing> {
		String t;

		public Thing(String t) {
			this.t = t;
		}

		public int compareTo(Thing other) {
			return t.length() - other.t.length();
		}
	}

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pair other) {
			if (other.x == x)
				return y - other.y;
			return x - other.x;
		}

		public boolean equals(Pair other) {
			if (x == other.x && y == other.y)
				return true;
			return false;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
