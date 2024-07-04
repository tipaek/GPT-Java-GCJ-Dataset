


import java.io.*;
import java.util.*;

class Solution {

	static long sx = 0, sy = 0, m = (long) (1e9 + 7);

	static ArrayList<Integer>[] a;
	static double[][] dp;
	static long[] farr;
	// static boolean b = true;
	static HashMap<Integer, Integer> hm = new HashMap<>();

	// static TreeMap<Integer, Integer> hm = new TreeMap<>();
	public static PrintWriter out;
	static long[] fact = new long[(int) 1e6];
	static boolean b = false;
	static StringBuilder sb = new StringBuilder();
	static boolean cycle = false;
	static long mod = (long) 1e9;
	static int[] col;
	static String st;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<pair> p = new ArrayList<>();
	static int n, u;
	static String[] Q;
	static String[] R;

	static long[] fix;
	static long[] max_val;
	static long[] is_prst;

	public static void main(String[] args) throws IOException {

		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// Reader scn = new Reader();

		out = new PrintWriter(System.out);

		int z = scn.nextInt();

		z: for (int o = 1; o <= z; o++) {
			Q = new String[10005];
			R = new String[10005];
			fix = new long[26];
			max_val = new long[26];
			is_prst = new long[26];

			long u = scn.nextLong();
			for (int i = 0; i < 10000; i++) {
				Q[i] = scn.next();
				R[i] = scn.next();
			}

			for (int i = 0; i < 26; i++)
				max_val[i] = 10;

			for (int i = 0; i < 10000; i++) {
				for (int j = 0; j < R[i].length(); j++) {
					is_prst[R[i].charAt(j) - 'A'] = 1;
					max_val[R[i].charAt(j) - 'A'] = 9;
				}
			}
			for (int i = 0; i < 10000; i++) {
				int m = (int) (Q[i].length());
				int n = (int) (R[i].length());
				if (m == 1 && m == n) {
					max_val[R[i].charAt(0) - 'A'] = Math.min(max_val[R[i].charAt(0) - 'A'],
							(int) (Q[i].charAt(0) - '0'));
				}
			}
			for (int sz = 2; sz <= u; sz++) {
				for (int i = 0; i < 10000; i++) {
					if (Q[i] == "-1")
						continue;
					int m = (int) (Q[i].length());
					int n = (int) (R[i].length());
					if (m == sz && m == n) {
						int f = 0;
						for (int j = 1; j < n; j++) {
							if (R[i].charAt(j) != R[i].charAt(0)) {
								f = 1;
								break;
							}
						}
						if (f != 0) {
							continue;
						}
						for (char j = '9'; j >= '1'; j--) {
							int g = 0;
							for (int k = 0; k < m; k++) {
								if (Q[i].charAt(k) > j) {
									f = 1;
									break;
								}
							}
							if (g == 0) {
								max_val[R[i].charAt(0) - 'A'] = Math.min(max_val[R[i].charAt(0) - 'A'],
										(int) (j - '0'));
								break;
							}
						}

					}
				}

			}
			for (int sz = 2; sz <= u; sz++) {
				for (int i = 0; i < 10000; i++) {
					if (Q[i] == "-1")
						continue;
					int m = (int) (Q[i].length());
					int n = (int) (R[i].length());
					if (m == sz && m == n) {
						int t = 0;
						int maxi = 0;
						while (t < n && max_val[R[i].charAt(t) - 'A'] == (int) (Q[i].charAt(t) - '0')) {
							maxi = Math.max(maxi, (int) (Q[i].charAt(t) - '0'));
							t++;
						}
						if (t < n)
							max_val[R[i].charAt(t) - 'A'] = Math.min(max_val[R[i].charAt(t) - 'A'],
									(int) (Q[i].charAt(t) - '0'));
					}
				}

			}
			String ans = "";
			for (int i = 0; i < 10; i++) {
				int j = 0;
				for (j = 0; j < 26; j++) {
					if (max_val[j] == i && is_prst[j] > 0) {
						ans += (char) ('A' + j);
						break;
					}
				}
				if (j == 26) {
					for (int k = 0; k < 26; k++) {
						if (max_val[k] == 9 && is_prst[k] > 0) {
							ans += (char) ('A' + j);
							max_val[k] = i;
							break;
						}
					}
				}
			}

			out.print("Case #" + o + ": " + ans);

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

		int a, b;

		pair(int x, int y) {
			a = x;
			b = y;
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