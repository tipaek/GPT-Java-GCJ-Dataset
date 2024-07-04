import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;

class Solution {
    
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
            byte[] buf = new byte[64];
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
    
    
    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();
        int test = sc.nextInt();
        int caseno = 1;
        while(test-->0){
            int tasks = sc.nextInt();
            int eq = tasks;
            String ans = "";
            Parents jamie = new Parents();
            Parents cameron = new Parents();
            while(tasks-->0){
                int start = sc.nextInt();
                int end = sc.nextInt();
                if(jamie.ifFree(start, end)){
                    ans = ans + "J";
                } else if (cameron.ifFree(start, end)){
                    ans = ans + "C";
                } else {
                    break;
                }
            }

            if(ans.length() == eq){
                System.out.println("Case #" + caseno++ + ": " + ans);
            } else {
                System.out.println("Case #" + caseno++ + ": IMPOSSIBLE");
            }
            ans = "";
        }
    }
}

class Parents {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

    public boolean ifFree(int start, int end){
        for(Integer k : this.map.keySet()){
            if(this.map.size() == 0){
                return true;
            }
            if(k <= start && start < map.get(k)){
                return false;
            }
            if(k <= end && end < map.get(k)){
                return false;
            }
            if((k <= start && start < map.get(k)) && (k <= end && end < map.get(k))){
                return false;
            }
        }
        this.map.put(start, end);
        return true;
    }
}