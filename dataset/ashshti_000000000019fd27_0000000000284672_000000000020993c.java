import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

 class TEST {

	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int t = r.nextInt();
		for (int i = 0; i < t; i++) {
			int n = r.nextInt();
			HashMap<Integer, HashSet<Integer>> ro=new HashMap<Integer, HashSet<Integer>>();
			HashMap<Integer, HashSet<Integer>> co=new HashMap<Integer, HashSet<Integer>>();
			for (int j = 0; j < n; j++) {
				ro.put(j, new HashSet<Integer>());
				co.put(j, new HashSet<Integer>());
			}
			boolean rb[] = new boolean[n];
			boolean cb[] = new boolean[n];
			
			int s = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int v = r.nextInt();
					if (k == j)
						s += v;
					//System.out.println(j);
					if(ro.get(j).contains(v))
						rb[j]=true;
					else
						ro.get(j).add(v);
					
					if(co.get(k).contains(v))
						cb[k]=true;
					else
						co.get(k).add(v);
					
					
				}
			}
			int cs=0;
			int rs=0;
			for (int j = 0; j < n; j++) {
		if(rb[j])
			rs++;
		if(cb[j])
			cs++;
		
			}
			System.out.println(s+" "+rs +" "+cs);

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