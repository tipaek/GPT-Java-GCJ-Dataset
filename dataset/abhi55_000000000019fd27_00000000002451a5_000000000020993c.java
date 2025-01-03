import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Reader rd = new Reader();
		int t = rd.ni();
		int x = 0;
		while(x < t) {
			x++;
			int n = rd.ni();
			int r=0;
			int trace=0;
			int c=0;
			int[][] arr = new int[n][n];
			for(int i=0;i<n;i++) {
				HashSet<Integer> hs = new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					arr[i][j] = rd.ni();
					hs.add(arr[i][j]);
				}
				if(hs.size()!=n) {
					r++;
				}
			}
			for(int i=0;i<n;i++) {
				trace += arr[i][i];
			}
			for(int i=0;i<n;i++) {
				HashSet<Integer> hs = new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					hs.add(arr[j][i]);
				}
				if(hs.size()!=n) {
					c++;
				}
			}
			System.out.println("Case #"+x+": "+trace+" "+r+" "+c);
		}
	}

////////////////////////////////////fast reader
////////////////////////////////////starts/////////////////////////////////////
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

		public int[] nia(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = ni();
			}
			return arr;
		}

		public long[] nla(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nl();
			}
			return arr;
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

		public int ni() throws IOException {
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

		public long nl() throws IOException {
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

		public double nd() throws IOException {
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
