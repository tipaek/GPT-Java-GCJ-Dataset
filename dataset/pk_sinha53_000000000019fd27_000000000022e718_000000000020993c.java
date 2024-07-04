import java.util.*;
import java.io.*;
 
 
class Main {
    
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
            byte[] buf = new byte[1000001]; // line length 
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
    public static void print(boolean[] arr){
            for(int i = 0 ;i<arr.length;i++){
                System.out.print((arr[i])+" ");
            }
            System.out.println("");
    }
    public static void printlist(ArrayList<Integer> arr){
            for(int i = 0 ;i<arr.size();i++){
                System.out.print((arr.get(i)+1)+" ");
            }
            System.out.println("");
    }
    
        
    public static void main(String[] args) throws IOException {
            Reader sc = new Reader();
            int tc = sc.nextInt();
            for(int q = 1;q<=tc;q++){
                int N = sc.nextInt();
                HashSet<Integer> hs = new HashSet<>();
                int[][] arr = new int[N][N];
                for(int i = 0;i<N;i++){
                    for(int j = 0;j<N;j++){
                        arr[i][j] = sc.nextInt();
                    }
                }
                int trace = 0;
                for(int i = 0;i<N;i++){
                    trace += arr[i][i];
                }
                int row = 0,col = 0;
                for(int i = 0;i<N;i++){
                    hs.clear();
                    for(int j = 0;j<N;j++){
                        if(hs.contains(arr[i][j])){
                            row++;
                            break;
                        }
                        hs.add(arr[i][j]);
                    }
                }
                for(int i = 0;i<N;i++){
                    hs.clear();
                    for(int j = 0;j<N;j++){
                        if(hs.contains(arr[j][i])){
                            col++;
                            break;
                        }
                        hs.add(arr[j][i]);
                    }
                }
                System.out.println("Case #"+q+": "+trace+" "+row+" "+col);
            }
              
    }
}