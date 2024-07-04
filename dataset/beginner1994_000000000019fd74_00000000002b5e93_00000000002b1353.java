import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {

	static FastReader in = new FastReader();
	static boolean[] primes = null;

	void sieve(int n) {
		primes = new boolean[n + 1];
		for (int p = 2; p * p <= n; p++) {
			if (!primes[p]) {
				for (int i = p * p; i <= n; i += p)
					primes[i] = true;
			}
		}
	}

	static class Node{
		long a;
		long b;
		
		Node(long x,long y){
			a=x;
			b=y;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		int t = in.nextInt();
		for(int _t=0;_t<t;_t++){
			long n = in.nextInt();
			long r = 1;
			long c = 1;
			long value = 1;
			List<Node> data = new ArrayList<>();
			boolean first = false;
			while(n > 0){
				data.add(new Node(r,c));
				n = n-value;
				if(n==0)break;
				if(n >= r){
					r++;
					value = r-1;
					c=r-1;
				}
				else{
					if(!first){
						data.add(new Node(r,c+1));
						n-=1;
						first=true;
					}
					if(n==0)break;
					value=1;
					r++;
					c=r;
				}
			}
			System.out.print("Case #"+(_t+1)+": ");
			for(Node x : data){
				System.out.println(x.a+" "+x.b);
			}
		}
		in.close();
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
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
