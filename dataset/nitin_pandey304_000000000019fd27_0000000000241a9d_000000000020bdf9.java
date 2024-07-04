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
			byte[] buf = new byte[101]; // line length 
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

    private static void printArr(int[][] arr) {
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j  = 0 ; j < arr[0].length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void sort2D(int[][] arr) {
        Arrays.sort(arr, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });
    }

    private static String solve(int[][] arr) {
        sort2D(arr);
        int n = arr.length;
        int[] oc = new int[2];
        Arrays.fill(oc, -1);
        String ans = "";

        for(int i = 0; i < n ; i++) {
            if(arr[i][0] >= oc[0]) {
                ans += "C";
                oc[0] = arr[i][1];
            } else if(arr[i][0] >= oc[1]) {
                ans += "J";
                oc[1] = arr[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Reader s=new Reader(); 
        int t = s.nextInt();
        for(int k = 0 ; k < t ; k++){ 
            int n = s.nextInt();
            int[][] arr= new int[n][2];
            for(int i = 0 ; i  <  n ; i++) {
                arr[i][0] = s.nextInt();
                arr[i][1] = s.nextInt();
            }
			String ans = solve(arr);
			System.out.println("Case #"+(k+1)+": " + ans); 
		} 
    }
}