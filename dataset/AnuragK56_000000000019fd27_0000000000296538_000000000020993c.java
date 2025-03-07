// Working program using Reader Class 
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.* ;

public class Solution {
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer,
		bytesRead;

		public Reader() {
			din = new DataInputStream(System. in );
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
			int cnt = 0,
			c;
			while ((c = read()) != -1) {
				if (c == '\n') break;
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
			if (neg) c = read();
			do {
				ret = ret * 10 + c - '0';
			} while (( c = read ()) >= '0' && c <= '9');

			if (neg) return - ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
			c = read();
			boolean neg = (c == '-');
			if (neg) c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while (( c = read ()) >= '0' && c <= '9');
			if (neg) return - ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0,
			div = 1;
			byte c = read();
			while (c <= ' ')
			c = read();
			boolean neg = (c == '-');
			if (neg) c = read();

			do {
				ret = ret * 10 + c - '0';
			}
			while (( c = read ()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg) return - ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1) buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead) fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null) return;
			din.close();
		}
	}

	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		int test,
		i,
		j,
		k = 0;
	
		// Scanner Obj=new Scanner(System.in);
		test = sc.nextInt();
		for (k = 0; k < test; k++)
		{
		int n=sc.nextInt();
		int temp=0;
		int arr[][]=new int[n][n];
		for(i=0;i<n;i++)
		    {
		        temp=(i+1)^temp;
	    	    for(j=0;j<n;j++)
		        {  
		        arr[i][j]=sc.nextInt();
		        }   
		    }
		    int sum=0;
		    for(i=0;i<n;i++)
		    {
		        sum+=arr[i][i];
		    }
		    int c=0,r=0;
		    for(i=0;i<n;i++)
		    {
		         int temp2=0;
		        for(j=0;j<n;j++)
		        {
		            temp2=temp2^arr[i][j];
		        }
		        if(temp2!=temp)
		        r++;
		    }
		     for(i=0;i<n;i++)
		    {
		        int temp2=0;
		        for(j=0;j<n;j++)
		        {
		            temp2=temp2^arr[j][i];
		        }
		        if(temp2!=temp)
		        c++;
		    }
		       System.out.println("Case #"+(k+1)+":"+" "+sum+" "+r+" "+c);
		}
}
}