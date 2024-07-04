

import java.io.*;
import java.util.*;

class codeJamQ1 {
    public static void main(String s[]) throws Exception {
        Reader r = new Reader();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = r.nextInt();
        for(int t=1;t<=T;t++){
            int n=r.nextInt();
            int mat[][]=new int[n][n];
            //int row=0,col=0;
            long sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    mat[i][j]=r.nextInt();
                sum+=mat[i][i];
            }
            HashMap<Integer,HashSet<Integer>> rows=new HashMap<Integer, HashSet<Integer>>();
            HashMap<Integer,HashSet<Integer>> cols=new HashMap<Integer, HashSet<Integer>>();
            for(int i=0;i<n;i++){
                rows.put(i,new HashSet<Integer>());
                cols.put(i,new HashSet<Integer>());
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    rows.get(i).add(mat[i][j]);
                    cols.get(j).add(mat[i][j]);
                }
            }
            int rc=0,cc=0;
            Iterator<Integer> itr=rows.keySet().iterator();
            Iterator<Integer> itc=cols.keySet().iterator();
            while (itc.hasNext()){
                if(cols.get(itc.next()).size()<n)
                    cc++;
            }
            while (itr.hasNext()){
                if(rows.get(itr.next()).size()<n)
                    rc++;
            }
            System.out.println("Case #"+t+": "+sum+" "+rc+" "+cc);
        }


    }

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
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c;
            while ((c = read()) != -1) {
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
            do {
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

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
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
}
