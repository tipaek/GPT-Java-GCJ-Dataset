import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {

	static int mod = 1000000007;
	//static FastReader in = new FastReader();
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static class Wrapper{
		long start;
		long end;
		
		Wrapper(long a,long b){
			start=a;
			end = b;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int _t = Integer.parseInt(in.readLine());
		outer: for(int _i=1;_i<=_t;_i++)
		{
			int n = Integer.parseInt(in.readLine());
			long[][] result = new long[n][2];
			List<Wrapper> cList = new ArrayList<>();
			List<Wrapper> jList = new ArrayList<>();
			StringBuilder sb = new StringBuilder("");
			for(int i=0;i<n;i++){
				String[] s = in.readLine().split(" ");
				result[i][0]=Integer.parseInt(s[0]);
				result[i][1]=Integer.parseInt(s[1]);
			}
			
			for(int i=0;i<n;i++){
				long start = result[i][0];
				long end = result[i][1];
				if(isAllowed(cList,start,end))
				{
					cList.add(new Wrapper(start,end));
					sb.append("C");
				}
				else if(isAllowed(jList,start,end))
				{
					jList.add(new Wrapper(start,end));
					sb.append("J");
				}
				else
				{
					System.out.println("Case #"+_i+": IMPOSSIBLE");
					continue outer;
				}
			}
			System.out.println("Case #"+_i+": "+sb.toString());
		}
		in.close();
	}
	
	private static boolean isAllowed(List<Wrapper> data,long start,long end){
		for(Wrapper w : data){
			if(w.end<=start)continue;
			if(w.start>=end)continue;
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