

import java.io.*;
import java.util.*;

class Solution {

	static long sx = 0, sy = 0, m = (long) (1e9 + 7);

	static ArrayList<Integer>[] a;
	static int[][] dp;
	static long[] farr;
	// static boolean b = true;
	static HashMap<Integer, Integer> hm = new HashMap<>();

	// static TreeMap<Integer, Integer> hm = new TreeMap<>();
	public static PrintWriter out;
	static ArrayList<Integer> p = new ArrayList<>();
	static long[] fact = new long[(int) 1e6];
	static boolean b = false;
	static StringBuilder sb = new StringBuilder();
	static boolean cycle = false;
	static long mod = 998244353;
	static int[] col;
	static String s;
	static int cnt;

	public static void main(String[] args) throws IOException {

		// Scanner scn = new Scanner(new BufferedReader(new
		// InputStreamReader(System.in)));
		Reader scn = new Reader();

		out = new PrintWriter(System.out);

		int t = scn.nextInt();

		z: for (int u = 1; u <= t; u++) {

			int r = scn.nextInt(), c = scn.nextInt();

			long[][] a = scn.nextInt2DArrayL(r, c);

			TreeSet<Integer>[] row = new TreeSet[r];
			TreeSet<Integer>[] col = new TreeSet[c];

			for (int i = 0; i < r; i++) {
				row[i] = new TreeSet<>();
				for (int j = 0; j < c; j++)
					row[i].add(j);
			}

			for (int j = 0; j < c; j++) {
				col[j] = new TreeSet<>();
				for (int i = 0; i < r; i++)
					col[j].add(i);
			}

			long ans = 0, sum = 0;

			for (int i = 0; i < r; i++)
				for (int j = 0; j < c; j++)
					sum += a[i][j];

			ans = 0;

			while (true) {

				ArrayList<pair> p = new ArrayList<>();

				ans += sum;

				for (int i = 0; i < r; i++) {

					for (int j = 0; j < c; j++) {

						double tot = 0, cnt = 0, avg = 0;

						if (a[i][j] != 0) {
							
							if (row[i].higher(j) != null) {
								cnt++;
								tot += a[i][row[i].higher(j)];
							}

							if (row[i].lower(j) != null) {
								cnt++;
								tot += a[i][row[i].lower(j)];
							}

							if (col[j].lower(i) != null) {
								cnt++;
								tot += a[col[j].lower(i)][j];
							}

							if (col[j].higher(i) != null) {
								cnt++;
								tot += a[col[j].higher(i)][j];
							}

							if (cnt != 0)
								avg = tot / cnt;

							if (a[i][j] < avg)
								p.add(new pair(i, j));
						}
					}
				}

				if (p.size() == 0)
					break;

				for (pair rp : p) {

					sum -= a[rp.i][rp.j];
					a[rp.i][rp.j] = 0;

					row[rp.i].remove(rp.j);
					col[rp.j].remove(rp.i);
					

				}

			}

			out.println("Case #" + u + ": " + ans);
		}

		out.close();
	}

	// _________________________TEMPLATE_____________________________________________________________

	// private static int gcd(int a, int b) {
	// if (a == 0)
	// return b;
	//
	// return gcd(b % a, a);
	// }

	// static class comp implements Comparator<Integer> {
	//
	// @Override
	// public int compare(Integer o1, Integer o2) {
	// if (b[o1])
	// return -1;
	// else if (b[o2])
	// return 1;
	// else
	// return (int) (a[o2].size() - a[o1].size());
	// }
	//
	// }

	// public static long pow(long a, long b) {
	//
	// if(b<0)return 0;
	// if (b == 0 || b == 1)
	// return (long) Math.pow(a, b);
	//
	// if (b % 2 == 0) {
	//
	// long ret = pow(a, b / 2);
	// ret = (ret % mod * ret % mod) % mod;
	// return ret;
	// }
	//
	// else {
	// return ((pow(a, b - 1) % mod) * a % mod) % mod;
	// }
	// }

	private static class pair implements Comparable<pair> {

		int sum = 0;
		int i, j;

		pair(int a, int b) {
			i = a;
			j = b;
		}

		@Override

		public int compareTo(pair o) {
			return 1;
		}

	}

	private static String reverse(String s) {

		return new StringBuilder(s).reverse().toString();
	}

	public static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[1000000 + 1]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		public int[][] nextInt2DArray(int m, int n) throws IOException {
			int[][] arr = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = nextInt();
			}
			return arr;
		}

		public long[][] nextInt2DArrayL(int m, int n) throws IOException {
			long[][] arr = new long[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = nextInt();
			}
			return arr;
		}
		// kickstart - Solution
		// atcoder - Main
		// out.print("Case #" + u + ": ");
	}

}