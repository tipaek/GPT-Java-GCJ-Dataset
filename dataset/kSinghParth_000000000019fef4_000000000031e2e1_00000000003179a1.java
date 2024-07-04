import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    

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
    public static void main(String args[]) throws IOException {
        // Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Reader sc=new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        for (int k=1;k<=t;k++) {
            int u=sc.nextInt();
            char arr[] = new char[10];
            for(int i=0;i<10;i++){
                char[] q=sc.readLine().toCharArray();
                // System.out.println(new String(q));
                int pt=(q.length-1)/2;
                for(int j=0;j<pt;j++){
                    arr[q[j]-'0']=q[j+pt+1];
                }
            }

            pw.println("Case #"+k+": "+new String(arr));
            
        }
        pw.close();

    }

  
}



// HashMap<String, ArrayList<Integer>> dp = new HashMap<>();
//             dp.put("0 1","N");
//             dp.put("0 2","IMPOSSIBLE");
//             dp.put("0 3","NN");
//             dp.put("0 4","IMPOSSIBLE");
//             dp.put("0 5","IMPOSSIBLE");
//             dp.put("0 -1","S");
//             dp.put("0 -2","IMPOSSIBLE");
//             dp.put("0 -3","SS");
//             dp.put("0 -4","IMPOSSIBLE");
//             dp.put("0 -5","IMPOSSIBLE");

//             dp.put("1 1","IMPOSSIBLE");
//             dp.put("1 2","EN");
//             dp.put("1 3","NN");
//             dp.put("1 4","IMPOSSIBLE");
//             dp.put("1 5","IMPOSSIBLE");
//             