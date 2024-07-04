import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Solution {

	static int mod = 1000000007;
	static FastReader in = new FastReader();
	//static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int _t = in.nextInt();
		outer: for(int _i=1;_i<=_t;_i++)
		{
			int n = in.nextInt();
			int k = in.nextInt();
			int[][] arr =new int[n][n];
			int shift = 0;
			int sum = 0;
			for(int i=0;i<n;i++){
				int val = 1;
				for(int j=0;j<n;j++){
					arr[i][(j+shift)%n]=val;
					val++;
				}
				sum+=arr[i][i];
				shift++;
			}
			if(sum==k){
				System.out.println("Case #"+_i+": POSSIBLE");
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++)
					System.out.print(arr[i][j]+" ");
					System.out.println();
				}
				continue outer;
			}
			
			shift = 0;
			for(int _v=0;_v < n;_v++)
			{
				shift++;
				sum = 0;
				int j = 0;
				for(int i=0;i<n;i++)
					sum+=arr[(i+shift)%n][j++];
				if(sum==k){
					System.out.println("Case #"+_i+": POSSIBLE");
					for(int i=0;i<n;i++){
						for(int _j=0;_j<n;_j++)
						System.out.print(arr[(i+shift)%n][_j]+" ");
						System.out.println();
					}
					continue outer;
				}
			}
			
			shift = 0;
			for(int _v=0;_v < n;_v++)
			{
				shift++;
				sum = 0;
				int j = 0;
				for(int i=0;i<n;i++)
				{
					sum+=arr[i][(j+shift)%n];
					j++;
				}
				
				if(sum==k){
					System.out.println("Case #"+_i+": POSSIBLE");
					for(int i=0;i<n;i++){
						for(int _j=0;_j<n;_j++)
						System.out.print(arr[i][(_j+shift)%n]+" ");
						System.out.println();
					}
					continue outer;
				}
			}
			System.out.println("Case #"+_i+": IMPOSSIBLE");
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