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

    // HashMap<String, Intger> path1 = new HashMap<>();
    private static HashSet<String> path;
    private static long maxT ;

    private static int dfs(long x, long y, long time) {
        if(time > maxT) {
            return Integer.MAX_VALUE;
        }
        String key = x + "_" + y + "_" + time;
        if(path.contains(key)) {
            // System.out.println(time + " **");
            return (int)time;
        }

        //go north
        int ans = dfs(x, y+1, time+1);
        ans = Math.min(ans, dfs(x, y-1, time+1));
        ans = Math.min(ans, dfs(x+1, y, time+1));
        ans = Math.min(ans, dfs(x-1, y, time+1));
        ans = Math.min(ans, dfs(x, y, time+1));

        return ans;
    }

    private static String solve(long x, long y, String s) {
       long t = 0;
       path  = new HashSet<>();
       path.add(x + "_" + y + "_" + t);
        for(Character c: s.toCharArray()) {
            if(c == 'N') {
                y++;
            } else if(c == 'S') {
                y--;
            } else if(c == 'E') {
                x++;
            } else {
                x--;
            }
            t++;
            String key = x + "_" + y + "_" + t;
            path.add(key);
        }
        maxT = t;
        int ans = dfs(0, 0, 0);
        // System.out.println(ans);
        return ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : Integer.toString(ans);
    }

    public static void main(String[] args) throws Exception {
        Reader s=new Reader(); 
        int t = s.nextInt();
        for(int it = 0 ; it < t ; it++){ 
			long x = s.nextInt();
            long y = s.nextInt();
            String str = s.readLine();
			String ans = solve(x, y, str);
			System.out.println("Case #"+(it+1)+": " +ans); 
		} 
    }
}
