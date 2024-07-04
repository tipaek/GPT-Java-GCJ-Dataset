import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
public class Solution {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();
			
			if(N == 2) {
				if(K == 2) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("1 2");
					System.out.println("2 1");
					continue;
				}
				else if(K == 3) {
					System.out.println("Case #" + (1+t) + ": IMPOSSIBLE");
					continue;
				}
				else {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("2 1");
					System.out.println("1 2");
					continue;
				}
			}
			else if(N == 3) {
				if(K == 3) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("1 2 3");
					System.out.println("3 1 2");
					System.out.println("2 3 1");
					
				}
				else if(K == 4) {
					System.out.println("Case #" + (1+t) + ": IMPOSSIBLE");
					
				}
				else if(K == 5) {
					System.out.println("Case #" + (1+t) + ": IMPOSSIBLE");
					
				}
				else if(K == 6) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("2 1 3");
					System.out.println("3 2 1");
					System.out.println("1 3 2");
				}
				else if(K == 7) {
					System.out.println("Case #" + (1+t) + ": IMPOSSIBLE");
					
				}
				else if(K == 8) {
					System.out.println("Case #" + (1+t) + ": IMPOSSIBLE");
					
				}
				else {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("3 1 2");
					System.out.println("2 3 1");
					System.out.println("1 2 3");
				}
			}
			else if(N == 4) {
				if(K == 4) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("1 2 3 4");
					System.out.println("3 1 4 2");
					System.out.println("2 4 1 3");
					System.out.println("4 3 2 1");
				}
				else if(K == 8) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("2 4 1 3");
					System.out.println("1 2 3 4");
					System.out.println("4 3 2 1");
					System.out.println("3 1 4 2");
				}
				else if(K == 12) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("3 1 4 2");
					System.out.println("4 3 2 1");
					System.out.println("1 2 3 4");
					System.out.println("2 4 1 3");
				}
				else if(K == 16) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("4 3 2 1");
					System.out.println("2 4 1 3");
					System.out.println("3 1 4 2");
					System.out.println("1 2 3 4");
				}
				else {
					System.out.println("Case #" + (1+t) + ": IMPOSSIBLE");
					
				}
			}
			else if(N == 5) {
				if(K == 5) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("1 2 3 4 5");
					System.out.println("5 1 4 3 2");
					System.out.println("4 5 1 2 3");
					System.out.println("2 3 5 1 4");
					System.out.println("3 4 2 5 1");
				}
				else if(K == 10) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("2 3 5 1 4");
					System.out.println("1 2 3 4 5");
					System.out.println("3 4 2 5 1");
					System.out.println("4 5 1 2 3");
					System.out.println("5 1 4 3 2");
				}
				else if(K == 15) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("3 4 2 5 1");
					System.out.println("2 3 5 1 4");
					System.out.println("1 2 3 4 5");
					System.out.println("5 1 4 3 2");
					System.out.println("4 5 1 2 3");
				}
				else if(K == 20) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("4 5 1 2 3");
					System.out.println("3 4 2 5 1");
					System.out.println("5 1 4 3 2");
					System.out.println("1 2 3 4 5");
					System.out.println("2 3 5 1 4");
				}
				else if(K == 25) {
					System.out.println("Case #" + (1+t) + ": POSSIBLE");
					System.out.println("5 1 4 3 2");
					System.out.println("4 5 1 2 3");
					System.out.println("2 3 5 1 4");
					System.out.println("3 4 2 5 1");
					System.out.println("1 2 3 4 5");
				}
				else {
					System.out.println("Case #" + (1+t) + ": IMPOSSIBLE");
					
				}
			}
			else {
				System.out.println("Case #" + (1+t) + ": IMPOSSIBLE");
			}
		}

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
2
3 6
2 3

  
Case #1: POSSIBLE
2 1 3
3 2 1
1 3 2
Case #2: IMPOSSIBLE
*/