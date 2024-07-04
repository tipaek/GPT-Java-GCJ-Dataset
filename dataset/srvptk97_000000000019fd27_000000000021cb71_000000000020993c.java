import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception{
		Reader sc1 = new Reader();
		int tc = sc1.nextInt();
		int ch = 1;
		StringBuilder sb = new StringBuilder();
		
	    while(ch<=tc){
	        int n = sc1.nextInt();
	        int row = 0;
	        int col = 0;
	        int trace = 0;
	        int[][] mat = new int[n][n];
	        
	        for(int i=0;i<n;i++){
	            int[] fre = new int[n+1];
	            int done = 0;
	            for(int j=0;j<n;j++){
	                mat[i][j] = sc1.nextInt();
	                if(i==j){
	                    trace += mat[i][j];
	                }
	                if(fre[mat[i][j]] > 0 && done==0){
	                    row++;
	                    done = 1;
	                }
	                fre[mat[i][j]]++;
	            }
	        }
	        
	        for(int j=0;j<n;j++){
	            int[] fre = new int[n+1];
	            int done = 0;
	            for(int i=0;i<n;i++){
	                if(fre[mat[i][j]] > 0 && done==0){
	                    col++;
	                    done = 1;
	                }
	                fre[mat[i][j]]++;
	            }
	        }
	        
	        sb.append("Case #"+ch+": "+trace+" "+row+" "+col+"\n");
	        ch++;
	    }
	    System.out.print(sb.toString());
    }
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
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
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
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
  
        public double nextDouble() throws IOException 
        { 
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
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
}
