import java.io.*;
import java.util.*;


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



    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int t = reader.nextInt();
        for(int index=0;index<t;index++){
            int rc = reader.nextInt();
            int[][] matrix = new int[rc][rc];
            int trace = 0;
            for(int r=0;r<rc;r++){
                for(int c=0;c<rc;c++){
                    matrix[r][c] = reader.nextInt();
                    if(r == c) trace = trace+ matrix[r][c];
                }
            }
            int rowCount = 0;
            for(int r=0;r<rc;r++){
                Map<Integer,Boolean> rowMap = new HashMap<>();
                for(int c=0;c<rc;c++){
                    if(rowMap.containsKey(matrix[r][c])){
                        rowCount++;
                        break;
                    }
                    rowMap.put(matrix[r][c], true);
                }
            }
            int colCount = 0;

            for(int c=0;c<rc;c++){
                Map<Integer,Boolean> rowMap = new HashMap<>();
                for(int r=0;r<rc;r++){
                    if(rowMap.containsKey(matrix[r][c])){
                        colCount++;
                        break;
                    }
                    rowMap.put(matrix[r][c], true);
                }
            }

            System.out.println("Case #"+(index+1)+ ":" + " " +  trace + " " + rowCount + " " + colCount);
        }
    }




}

