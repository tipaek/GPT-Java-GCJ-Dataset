import java.util.*;
import java.io.*;
 
 
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
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();
            for(int q = 1;q<=tc;q++){
                int N = sc.nextInt();
                int[][] works = new int[N][3];
                for(int i = 0;i<N;i++){
                    works[i][0] = sc.nextInt();
                    works[i][1] = sc.nextInt();
                    works[i][2] = i;
                }
                Arrays.sort(works, new Comparator<int[]>(){
                    @Override
                    public int compare(final int[] a,final int[] b){
                        return a[0] - b[0];
                    }
                });
                char[] dis = new char[N];
                int je = -1; int ce = -1;
                boolean flag = false;
                for(int i = 0;i<N;i++){
                    if(je<=works[i][0]){
                        dis[works[i][2]] = 'J';
                        je = works[i][1];
                    }else if(ce<=works[i][0]){
                        dis[works[i][2]] = 'C';
                        ce = works[i][1];
                    }else{
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    System.out.println("Case #"+q+": IMPOSSIBLE");
                }else{
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0;i<N;i++){
                        sb.append(dis[i]);
                    }
                    System.out.println("Case #"+q+": "+sb.toString());
                }
            }
              
    }
}