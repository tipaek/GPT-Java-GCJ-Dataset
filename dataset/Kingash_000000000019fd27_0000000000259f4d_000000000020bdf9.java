import java.io.*;
import java.util.*;

public class Solution {

	static long mod = (long) 1e9 + 7;
	static PrintWriter out = new PrintWriter(System.out);
	static Reader scn = new Reader();

	public static void main(String[] args) throws IOException {
		StringBuilder king = new StringBuilder();
		int T = scn.nextInt();
		for (int t = 0; t < T; t++) {
			int n = scn.nextInt();
			king.append("Case #" + (t + 1) + ": ");
			int[][] a1 = new int[n][2];
			pair[] a2 = new pair[n];
			int[] av = new int[n];
			int[] dp = new int[n];
			for (int i = 0; i < n; i++) {
				a1[i][0] = scn.nextInt();
				a1[i][1] = scn.nextInt();
				av[i] = a1[i][0];
				dp[i] = a1[i][1];
				a2[i] = new pair(a1[i][0], a1[i][1], i);
			}
			Arrays.sort(a2);
			int v = minPlatforms(av, dp);
			if (v > 2)
				king.append("IMPOSSIBLE");
			else if (v == 1)
				for (int i = 0; i < n; i++)
					king.append("C");
			else {
				int l = a2[0].r, r = 0;
				HashMap<Integer, Integer> aaap = new HashMap<>();
				aaap.put(a2[0].xd, 0);
				for (int i = 0; i < a2.length; i++) {
					int ll = a2[i].s, rr = a2[i].r;
					if (ll >= l)
						aaap.put(a2[i].xd, r);
					else {
						aaap.put(a2[i].xd, 1 - r);
						r = 1 - r;
					}
					l = rr;
				}
				for (int i = 0; i < n; i++)
					king.append(aaap.get(i) == 0 ? "C" : "J");
			}
			king.append("\n");
		}
		out.println(king);
		out.flush();
	}

	public static int minPlatforms(int[] av, int[] dp) {
		int c = 0;
		Arrays.sort(av);
		Arrays.sort(dp);
		int p = 0, i = 0, j = 0;
		while (i < av.length) {
			if (av[i] < dp[j]) {
				p = Integer.max(p, ++c);
				i++;
			} else {
				c--;
				j++;
			}
		}
		return p;
	}

	public static class pair implements Comparable<pair> {
		int s, r, xd;

		public pair(int strt, int end, int in) {
			this.s = strt;
			this.r = end;
			this.xd = in;
		}

		public int compareTo(pair o) {
			return this.s != o.s ? this.s - o.s : this.r - o.r;
		}
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
			byte[] buf = new byte[100000 + 1];
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

			if (c == '.')
				while ((c = read()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
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
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextLong();
			return arr;
		}

		public int[][] nextInt2DArray(int m, int n) throws IOException {
			int[][] arr = new int[m][n];
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					arr[i][j] = nextInt();
			return arr;
		}
	}
}