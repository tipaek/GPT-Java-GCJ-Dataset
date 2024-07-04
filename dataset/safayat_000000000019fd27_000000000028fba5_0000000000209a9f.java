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



    public static void appendCharMultipleTimes(StringBuilder stringBuilder, char brace, int count){
        while (count-->0){
            stringBuilder.append(brace);
        }
    }
    public static void appendCharWithBraces(StringBuilder stringBuilder, char c, int braceCount){
        appendCharMultipleTimes(stringBuilder, '(', braceCount);
        stringBuilder.append(c);
        appendCharMultipleTimes(stringBuilder, ')', braceCount);
    }
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int t = reader.nextInt();
        for(int index=0;index<t;index++){
            String digit = reader.readLine();
            StringBuilder ans = new StringBuilder();
            Integer prev = null;
            for(char c : digit.toCharArray()){
                int d = c-'0';
                if(d == 0){
                    ans.append(c);
                }else {
                    if(prev == null || prev == 0){
                        appendCharWithBraces(ans, c, d);
                    }else {
                        int diff = d - prev;
                        if(diff == 0){
                            ans.insert(ans.length() - prev, c);
                        }else if(diff > 0){
                            StringBuilder sequences = new StringBuilder();
                            appendCharWithBraces(sequences,c,diff);
                            ans.insert(ans.length()-prev, sequences);
                        }else{
                            int absDiff = Math.abs(diff);
                            ans.insert(ans.length()-(prev-absDiff), c);
                        }
                    }
                }
                prev = d;
            }
            System.out.print("Case #");
            System.out.print((index+1)+": ");
            System.out.print(ans);
            System.out.println();
        }
    }




}

