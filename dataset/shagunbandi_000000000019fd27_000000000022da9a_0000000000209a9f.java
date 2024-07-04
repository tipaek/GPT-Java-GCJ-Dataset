import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
  
public class Solution 
{ 
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
            byte[] buf = new byte[100]; // line length 
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

    public static String gob(int n) {
        if(n==1) {
            return "(";
        }
        else if(n==2) {
            return "((";
        }
        else if(n==3) {
            return "(((";
        }
        else if(n==4) {
            return "((((";
        }
        else if(n==5) {
            return "(((((";
        }
        else if(n==6) {
            return "((((((";
        }
        else if(n==7) {
            return "(((((((";
        }
        else if(n==8) {
            return "((((((((";
        }
        else if(n==9) {
            return "(((((((((";
        }
        return "";
    }

    public static String gcb(int n) {
        if(n==1) {
            return ")";
        }
        else if(n==2) {
            return "))";
        }
        else if(n==3) {
            return ")))";
        }
        else if(n==4) {
            return "))))";
        }
        else if(n==5) {
            return ")))))";
        }
        else if(n==6) {
            return "))))))";
        }
        else if(n==7) {
            return ")))))))";
        }
        else if(n==8) {
            return "))))))))";
        }
        else if(n==9) {
            return ")))))))))";
        }
        return "";
    }
    
    public static String solution(String str) {

        StringBuilder sb = new StringBuilder();
        int b = 0;
        for(int i=0;i<str.length();i++){
        	// System.out.println(i);
            int n = Character.getNumericValue(str.charAt(i));  
            // System.out.println("Numeric Value");
            // System.out.println("Appending Closing");
            if(n<b) {
                sb.append(gcb(b-n));
            }
            // System.out.println("Appending Opening");
            if(n>b){
                sb.append(gob(n-b));
            }
            
            sb.append(str.charAt(i));
            b=n;
        }
        sb.append(gcb(b));
        
        return sb.toString();

        
    }
  
    public static void main(String[] args) throws IOException 
    { 
    	// System.out.println("Reading");
        Reader s=new Reader(); 
        // System.out.println("Getting t");
        int t = s.nextInt(); 
        int cnt=1;
        while (cnt<=t) 
        {
        	// System.out.println("Reading Line");
            String str = s.readLine();
            
            // System.out.println("Calling Function");
            String sol = solution(str);
            System.out.println("Case #"+cnt+": " + sol);
            cnt++;
               
        } 
    } 
} 
