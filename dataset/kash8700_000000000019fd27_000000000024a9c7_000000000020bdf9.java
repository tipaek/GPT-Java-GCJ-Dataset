

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class Solution {
	static long time = 0, mp = Integer.MAX_VALUE, k = 0, cnt = 0, edge = 0, no = 0;

	static int[] goal;
	static int[] init;
	static int[] col;
	static char[][] g;
	static String sb = "";
	static ArrayList<Integer>[] a;

	static ArrayList<Integer> p = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		Reader scn = new Reader();
		int test = scn.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			sb.append("Case #" + (t + 1) + ": ");
			int[][] arr = new int[n][2];
			pair[] arr2 = new pair[n];
			int[] arv = new int[n];
			int[] dep = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i][0] = scn.nextInt();
				arr[i][1] = scn.nextInt();
				arv[i] = arr[i][0];
				dep[i] = arr[i][1];
				pair p = new pair(arr[i][0], arr[i][1], i);
				arr2[i] = p;

			}
			Arrays.sort(arr2);
			int v = minPlatforms(arv, dep);
			if (v > 2) {
				sb.append("IMPOSSIBLE");
			} else if (v == 1) {
				for (int i = 0; i < n; i++) {
					sb.append("C");
				}
			} else {
				int pre = arr2[0].end;
				int ass = 0;
				HashMap<Integer, Integer> map = new HashMap<>();
				map.put(arr2[0].ind, 0);
				for (int i = 0; i < arr2.length; i++) {
					int st = arr2[i].str;
					int end = arr2[i].end;
					if (st >= pre) {
						map.put(arr2[i].ind, ass);
					} else {
						map.put(arr2[i].ind, 1 - ass);
						ass = 1 - ass;
					}
					pre = end;
				}
				for (int i = 0; i < n; i++) {
					if (map.get(i) == 0) {
						sb.append("C");
					} else {
						sb.append("J");
					}
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static int minPlatforms(int[] arrival, int[] departure) {
		
		int count = 0;
		Arrays.sort(arrival);
		Arrays.sort(departure);

		int platforms = 0;

		
		int i = 0, j = 0;

		
		while (i < arrival.length) {
			
			if (arrival[i] < departure[j]) {
				
				platforms = Integer.max(platforms, ++count);

				
				i++;
			}

		
			else {
				count--;
				j++;
			}
		}

		return platforms;
	}

	public static class pair implements Comparable<pair> {
		int str;
		int end;
		int ind;

		public pair(int strt, int end, int in) {
			this.str = strt;
			this.end = end;
			this.ind = in;
		}

		@Override
		public int compareTo(pair o) {
			if (this.str != o.str) {
				return this.str - o.str;
			} else {
				return this.end - o.end;
			}
		}

	}

	public static PrintWriter out;

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
			byte[] buf = new byte[100000 + 1]; // line length
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

	}

}