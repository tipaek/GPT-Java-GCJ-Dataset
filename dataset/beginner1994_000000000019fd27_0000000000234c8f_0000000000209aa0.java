import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Solution {

	static int mod = 1000000007;
	static FastReader in = new FastReader();
	// static BufferedReader in = new BufferedReader(new
	// InputStreamReader(System.in));
	static boolean res = false;

	public static void main(String[] args) throws Exception {
		int _t = in.nextInt();
		for (int _i = 1; _i <= _t; _i++) {
			int n = in.nextInt();
			res = false;
			int k = in.nextInt();
			int[][] arr = new int[n][n];
			process(arr, 0, 0, k,_i);
			if(!res)
				System.out.println("Case #"+_i+": IMPOSSIBLE");
		}
		in.close();
	}

	private static void process(int[][] arr, int _i, int _j, int k,int index) {
		if (_i == arr.length) {
			int s = 0;
			for(int i=0;i<arr.length;i++)s+=arr[i][i];
			if (k == s && !res) {
				res = true;
				System.out.println("Case #"+index+": POSSIBLE");
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) 
						System.out.print(arr[i][j] + " ");
					System.out.println();
				}
			}
			return;
		}

		for (int a = 1; a <= arr.length; a++) {
			if (isSafe(arr, _i, _j, a)) {
				arr[_i][_j] = a;
				if (_j == arr.length - 1)
					process(arr, _i + 1, 0, k,index);
				else
					process(arr, _i, _j + 1, k,index);
				arr[_i][_j]=0;
			}
		}
	}

	private static boolean isSafe(int[][] arr, int _i, int _j, int a) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[_i][i] == a)
				return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][_j] == a)
				return false;
		}
		return true;
	}

	static class FastReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastReader(String file_name) throws IOException {
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