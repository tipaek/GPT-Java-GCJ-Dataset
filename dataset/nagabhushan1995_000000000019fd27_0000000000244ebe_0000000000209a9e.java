
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Solution {
	private static int n;
	private static int[] a;

	public static void main(String[] args) {
		int t = in.nextInt();
		int b = in.nextInt();
		while (t-- > 0) {
			double[] ans = new double[b+1];

			int i = 1;

			double prob = 0.25;

			for(int q=1; q<=b; q++) {

				System.out.println(i);
				System.out.flush();
//				System.err.println("QUERY: "+i);
//				System.err.flush();

				int u = ini();
//				System.err.println("RECEIVED: "+i);
//				System.err.flush();

//				if (q%10==1) {
//					prob *= 0.25;
//				} else {
//
//				}
//				System.err.println("PROB: "+prob);
//				System.err.flush();

				//nothing happend
				ans[i] += 0.25*u;

				//complement
				//ans[i] += 0.25*(1-u);

				//reverse
				//ans[b-i+1] += 0.25*u;

				//reverse and complement
				//ans[b-i+1] += 0.25*(1-u);


//				System.err.println("TRACK "+ans[i]);
//				System.err.flush();
				i++;
				if (i>b) i = 1;

//				System.err.print("ANS: ");
//				for(int j=1; j<=b; j++) {
//					System.err.print(ans[j]+" ");
//				}
//				System.err.println();
//				System.err.flush();
			}

			for(int j=1; j<=b; j++) {
				System.out.print(ans[j]>=0.25?1:0);
//				System.err.print(ans[j]+" ");
			}
			System.out.println();
			System.out.flush();


// 			for(int j=1; j<=b; j++) {
// 				System.err.print(ans[j]+" ");
// //				System.err.print(ans[j]+" ");
// 			}
// 			System.err.println();
// 			System.err.flush();

//			System.err.println();
//			System.err.flush();
//
//
//			System.err.println("----------------------------------------------------------");
//			System.err.println("----------------------------------------------------------");
//			System.err.println("----------------------------------------------------------");
//			System.err.println("----------------------------------------------------------");
//			System.err.flush();

			String res = in.readString();
			if (res.equals("N")) {
				break;
			}
		}

		out.flush();
		out.close();

	}

	//NONPROBLEM CODE

	private static InputReader in = new InputReader(System.in);
	private static PrintWriter out = new PrintWriter(System.out);

	private static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;

		public InputReader(InputStream st) {
			this.stream = st;
		}

		public int read() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
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

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

	}

	//INPUT SHORTCUTS

	private static int[] ina(int n) {
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = in.nextInt();
		}
		return temp;
	}

	private static int ini() {
		return in.nextInt();
	}

	//OTHER SHORTCUTS
	public static void sort(int[] a) {
		Arrays.sort(a);
	}

	//PRINT SHORTCUTS

	private static void println(Object... o) {
		for (Object x : o) {
			out.write(x + " ");
		}
		out.write("\n");
		out.flush();
	}

	private static void print(Object... o) {
		for (Object x : o) {
			out.write(x + " ");
		}
		out.flush();
	}

	private static void debug(Object... o) {
		for (Object x : o) {
			out.write(x + " ");
		}
		out.write("\n");
		out.flush();
	}

	private static HashMap<Integer, ArrayList<Integer>> intree(int n) {

		HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			g.get(u).add(v);
			g.get(v).add(u);
		}

		return g;
	}
}
