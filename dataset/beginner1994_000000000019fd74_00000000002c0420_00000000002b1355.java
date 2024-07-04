import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class Solution {

	static FastReader in = new FastReader();

	static class Node{
		int i;
		int j;
		
		Node(int a,int b){
			i=a;
			j=b;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int t = in.nextInt();
		for (int _t = 0; _t < t; _t++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int[][] arr = new int[a][b];
			for (int i = 0; i < a; i++)
				for (int j = 0; j < b; j++)
					arr[i][j] = in.nextInt();

			long val = 0;
			while (true) {
				List<Node> data = new LinkedList<>();
				for (int i = 0; i < a; i++) {
					for (int j = 0; j < b; j++) {
						if(arr[i][j]==-1)continue;
						val+=arr[i][j];
						int c = 0;
						int v = 0;
						
						int i1 = i-1;
						while(i1>=0){
							if (i1 >= 0 && arr[i1][j]!=-1) {
								c++;
								v += arr[i1][j];
								break;
							}
							i1--;
						}
						
						int j1 = j-1;
						while(j1>=0){
							if (j1 >= 0 && arr[i][j1]!=-1) {
								c++;
								v += arr[i][j1];
								break;
							}
							j1--;
						}
						
						i1 = i+1;
						while(i1<a){
							if (i1 < a && arr[i1][j]!=-1) {
								c++;
								v += arr[i1][j];
								break;
							}
							i1++;
						}
						
						j1 = j+1;
						while(j1<b){
							if (j1 < b && arr[i][j1]!=-1) {
								c++;
								v += arr[i][j1];
								break;
							}
							j1++;
						}
						
						if(c!=0)
						{
							double temp = (double)v/c;
							if((double)arr[i][j] < temp){
								data.add(new Node(i,j));
								//System.out.println(i+" "+j);
							}
						}
					}
				}
				if (data.isEmpty())
					break;
				else{
					for(Node n : data)
						arr[n.i][n.j]=-1;
				}
			}
			System.out.println("Case #" + (_t + 1) + ": " + val);
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
