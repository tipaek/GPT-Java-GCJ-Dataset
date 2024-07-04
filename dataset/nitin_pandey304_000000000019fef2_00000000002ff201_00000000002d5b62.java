import java.util.*;
import java.io.*;
public class Solution {

    //Reader from https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/?ref=rp
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
			byte[] buf = new byte[110]; // line length 
			int cnt = 0, c; 
			while ((c = read()) != -1) 
			{ 
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
			do
			{ 
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
			} 
			while ((c = read()) >= '0' && c <= '9'); 
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
			} 
			while ((c = read()) >= '0' && c <= '9'); 

			if (c == '.') 
			{ 
				while ((c = read()) >= '0' && c <= '9') 
				{ 
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
    
	//Main code starts from here
	
	private static long targetX, targetY;
	private static String recur(String curr, long x, long y, long val) {
		if(x == targetX && y == targetY) {
			return curr;
		}
		if(Math.abs(x) > 2 * Math.abs(targetX) || Math.abs(y) > 2 * Math.abs(targetY)) {
			return "IMPOSSIBLE";
		}
		// if(val > (long)(Math.pow(10, 10))) {
		// 	return "IMPOSSIBLE";
		// }
		String[] ans  = new String[4];
		ans[0] = recur(curr + "N", x, y + val, val * 2);
		ans[1] = recur(curr + "E", x + val, y, val * 2);
		ans[2] = recur(curr + "S", x, y - val, val * 2);
		ans[3] = recur(curr + "W", x - val, y, val * 2);
		String out = "IMPOSSIBLE";
		for(int i = 0 ; i < 4 ; i++) {
			if(!ans[i].equals("IMPOSSIBLE")) {
				if(out.equals("IMPOSSIBLE")) {
					out = ans[i];
				} else {
					if(out.length() > ans[i].length()) {
						out = ans[i];
					}
				}
			}
		}
		return out;
	}

    private static String solve(long x, long y) {
	   targetX = x;
	   targetY = y;
	   long val = 1;
	   return recur("", 0, 0, val);
    }

    public static void main(String[] args) throws Exception {
        Reader s=new Reader(); 
        int t = s.nextInt();
        for(int it = 0 ; it < t ; it++){ 
			long x = s.nextInt();
			long y = s.nextInt();
			String ans = solve(x, y);
			System.out.println("Case #"+(it+1)+": " +ans); 
		} 
    }
}