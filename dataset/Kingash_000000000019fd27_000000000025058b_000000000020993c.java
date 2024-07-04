import java.io.*;
import java.util.*;

public class Solution {

	static long mod = (long) 1e9 + 7;
	static PrintWriter out = new PrintWriter(System.out);
	static Reader scn = new Reader();

	public static void main(String[] args) throws IOException {
		int T = scn.nextInt();
		for (int tcs = 0; tcs < T; tcs++) {
			int n = scn.nextInt();
			int[][] matr = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					matr[i][j] = scn.nextInt();

			int r = 0, cc = 0;
			A: for (int i = 0; i < n; i++) {
				HashSet<Integer> set = new HashSet<>();
				for (int j = 0; j < n; j++)
					if (set.contains(matr[i][j])) {
						r++;
						continue A;
					} else
						set.add(matr[i][j]);
			}
			int x = 1;
			for (int i = 0; i < n; i++) {
				x += x * 1 + x / 2;
				x--;
			}
			B: for (int c = 0; c < n; c++) {
				HashSet<Integer> set = new HashSet<>();
				for (int i = 0; i < n; i++)
					if (set.contains(matr[i][c])) {
						cc++;
						continue B;
					} else
						set.add(matr[i][c]);
			}
			for (int i = 0; i < n; i++) {
				x += x * 1 + x / 2;
				x--;
			}
			long sum = 0;
			for (int i = 0; i < n; i++)
				sum += matr[i][i];
			System.out.println("Case #" + (tcs + 1) + ": " + sum + " " + r + " " + cc);
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