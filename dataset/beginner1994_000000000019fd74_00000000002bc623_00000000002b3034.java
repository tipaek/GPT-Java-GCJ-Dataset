import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

class Solution {

	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(in.readLine());
		for (int _t = 0; _t < t; _t++) {
			int n = Integer.parseInt(in.readLine());
			String[] arr = new String[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.readLine();
			String prefix = null;
			String suffix = null;
			boolean found = false;
			for (String s : arr) {
				int index = s.indexOf('*');
				String temp = null;
				if (index != -1) {
					temp = s.substring(index + 1);
					if (suffix == null || temp.length() > suffix.length()) {
						suffix = temp;
					}
					temp = s.substring(0,index);
					if (prefix == null || temp.length() > prefix.length()) {
						prefix = temp;
					}
				}
			}
			
			for(String s : arr){
				int index = s.indexOf('*');
				String a = s.substring(0,index);
				String b = s.substring(index+1);
				if(!prefix.startsWith(a) || !suffix.endsWith(b)){
					found=false;
					break;
				}
			}

			System.out.print("Case #" + (_t + 1) + ": ");
			if (!found)
				System.out.println(prefix+suffix);
			else
				System.out.println("*");
		}
		in.close();
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
