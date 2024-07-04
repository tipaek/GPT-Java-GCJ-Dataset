import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();
        int T = sc.nextInt();
        for(int x = 1 ; x <= T ; x++) {
            int N = sc.nextInt();
            ArrayList<Integer>[] B = new ArrayList[24*60+1];
            int c = 0, j = 0;
            char[] S = new char[N];
            for(int i = 0 ; i < N ; i++) {
                Scanner s = new Scanner(sc.nextLine());
                int index = s.nextInt();
                B[index] = B[index] == null ? new ArrayList<Integer>() : B[index];
                B[index].add((i + 1) * -1);
                index = s.nextInt();
                B[index] = B[index] == null ? new ArrayList<Integer>() : B[index];
                B[index].add(i + 1);
                s.close();
            }
            for(int i = 0 ; i < B.length; i++) {
                if(B[i] == null)
                    continue;
                Collections.sort(B[i], Collections.reverseOrder());
                for(int p : B[i]) {
                    if(p < 0) {
                        if(c == 0) {
                            S[p * -1 - 1] += 'C';
                            c = p;
                        }
                        else if(j == 0) {
                            S[p * -1 - 1] += 'J';
                            j = p;
                        }
                        else
                            break;
                    }
                    else if(p > 0) {
                        if(p + c == 0)
                            c = 0;
                        else
                            j = 0;
                    }
                }
            }
            String str = new String(S).replaceAll("\u0000", "");
            System.out.printf("Case #%d: %s%n", x, str.length() == N ? str : "IMPOSSIBLE");
        }
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

        public String nextLine() throws IOException
        {
            byte[] buf = new byte[100000]; // line length 
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