import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class Solution {

    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        //Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tests = sc.nextInt();
        for (int test = 0; test < tests; test++) {
            int N = sc.nextInt();
            HashSet<Integer>[] rowSet = new HashSet[N];
            HashSet<Integer>[] colSet = new HashSet[N];
            for (int i = 0; i < N; i++) {
                rowSet[i] = new HashSet<>();
                colSet[i] = new HashSet<>();
            }
            int trace = 0;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    int val = sc.nextInt();
                    if (row==col)trace+=val;
                    rowSet[row].add(val);
                    colSet[col].add(val);
                }
            }
            pw.printf("Case #%d:",test+1);
            pw.print(" "+trace);
            int rowsBad = 0;
            for (int i = 0; i < N; i++) {
                if (rowSet[i].size()!=N)rowsBad++;
            }
            int colsBad = 0;
            for (int i = 0; i < N; i++) {
                if (colSet[i].size()!=N)colsBad++;
            }
            pw.print(" "+rowsBad);
            pw.println(" "+colsBad);
        }
        pw.flush();
        pw.close();
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