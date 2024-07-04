import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {
	
	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			int N = in.nextInt();
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			
			int trace = 0;
			for(int i = 0; i < N; i++)
				trace += arr[i][i];
			
			int r = 0;
			for(int i = 0; i < N; i++) {
				HashSet<Integer> set = new HashSet<>();
				for(int j = 0; j < arr[i].length; j++) {
					set.add(arr[i][j]);
				}
				if(set.size() != N) {
					r++;
				}
			}
			
			int c = 0;
			for(int j = 0; j < N; j++) {
				HashSet<Integer> set = new HashSet<>();
				for(int i = 0; i < N; i++) {
					set.add(arr[i][j]);
				}
				if(set.size() != N) {
					c++;
				}
			}
			
			sb.append("Test #" + (t+1) + ": " + trace + " " + r + " " + c + "\n");
			
		}
		
		System.out.print(sb);
	}
	
	/**
	 * Source: Matt Fontaine
	 */
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int chars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (chars == -1)
				throw new InputMismatchException();
			if (curChar >= chars) {
				curChar = 0;
				try {
					chars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (chars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String next() {
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

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}

/*
3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3

Case #1: 4 0 0
Case #2: 9 4 4
Case #3: 8 0 2
*/