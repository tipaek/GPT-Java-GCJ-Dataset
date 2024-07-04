
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static final String NEWLINE = "\n";
	private static final String SPACE = " ";
	private static final String COLON = ":";
	private static final String CASE = "Case #";

	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int t = 1;
		while (t <= T) {
			StringBuilder sb = new StringBuilder();
			int u = in.nextInt();
			long range = (long)(Math.pow(10, u));
			int n = 10000;
			Pair pr[] = new Pair[n];
			long d[][] = new long[10][26];
			for (int i=0;i<10;i++) Arrays.fill(d[i], 0);
			
			for (int i=0;i<n;i++) {
				pr[i] = new Pair(in.nextLong(), in.next());
				if (pr[i].x >= 0 && pr[i].x <= range && isValid(pr[i])) {
				    long x = pr[i].x;
					for (int j=pr[i].y.length()-1;j>=0;j--) {
						int row = (int)(x%10);
						int col = pr[i].y.charAt(j)-'A';
						d[row][col]++;
					}
				}
			}
			
			char ch[] = new char[10];
			Set<Integer> set = new HashSet<Integer>();
			for (int i=0;i<10;i++) {
				int row = i, col = 26;
				int ind = 0;
				long max = 0;
				while (ind<col) {
					if (d[row][ind]>max && !set.contains(ind)) {
						max = d[row][ind];
						ch[i] = (char) ('A' + (ind-'A'));
					}
					ind++;
				}
				set.add(ch[i]-'A');
			}
//			set = new HashSet<Integer>();
//			for (int i=0;i<26;i++) {
//				int col = i, row = 10;
//				int ind = 0, ri = 0;
//				long max = 0;
//				while (ind<row) {
//					if (d[ind][col]>max && !set.contains(ind)) {
//						max = d[ind][row];
//						ch[ind] = (char)('A' + (col));
//						ri = ind;
//					}
//				}
//				set.add(ri);
//			}
			
			String ans = new String(ch);
			sb.append(CASE).append(t).append(COLON).append(SPACE).append(ans).append(NEWLINE);
			System.out.print(sb);
			t++;
		}
		in.close();
	}

	private static boolean isValid(Pair pair) {
		long x = pair.x;
		String y = pair.y;
		if (y.length() == 1 && x == 0) return true;
		int l = y.length();
		while (l != 0 && x != 0) {
			x = x/10;
			l--;
		}
		if (x == 0 && l == 0) return true;
		return false;
	}

	static class Pair {
		Long x;
		String y;
		private Pair(Long x, String y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null || !(o instanceof Pair))
				return false;
			Pair cor = (Pair)o;
			return x.equals(cor.x) && y.equals(cor.y);
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			result = result + 31*y.hashCode();
			return result;
		}
		
		static class PairComparatorX implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.x.compareTo(o2.x);
			}
			
		}

		static class PairComparatorY implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.y.length() < o2.y.length()) return -1;
				else if (o1.y.length() > o2.y.length()) return 1;
				return 0;
			}
			
		}

	}
	
	static class Reader {
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
			byte[] buf = new byte[64]; // line length
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
	}

}
