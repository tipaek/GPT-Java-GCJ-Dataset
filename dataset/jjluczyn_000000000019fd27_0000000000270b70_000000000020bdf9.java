import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

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
            ArrayList<Interval> intervalos = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervalos.add(new Interval(i,start,end));
            }
            Collections.sort(intervalos,(i1, i2) -> Integer.compare(i1.start,i2.start));
            char[] sol = new char[N];
            boolean can = true;
            PriorityQueue<LastJob> pq = new PriorityQueue<>(2,(lj1, lj2) -> Integer.compare(lj1.end,lj2.end));
            pq.add(new LastJob(-1,'C'));
            pq.add(new LastJob(-1,'J'));
            for (Interval intervalo : intervalos) {
                if (pq.peek().end>intervalo.start){
                    can = false;
                    break;
                } else {
                    LastJob aux = pq.remove();
                    pq.add(new LastJob(intervalo.end,aux.name));
                    sol[intervalo.id] = aux.name;
                }
            }
            pw.printf("Case #%d: ",test+1);
            if (can) pw.println(new String(sol));
            else pw.println("IMPOSSIBLE");
        }
        pw.flush();
        pw.close();
    }

    static class LastJob {
        int end;
        char name;

        public LastJob(int end, char name) {
            this.end = end;
            this.name = name;
        }
    }

    static class Interval {
        int id, start, end;

        public Interval(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
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