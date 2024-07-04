import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
public class Solution
{
    public static void main(String[] args) {
        new Thread(null,null,"Rahsut",1<<25){
            public void run() {
                try{
                    solve();
                } catch(Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
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

        public int ni() throws IOException {
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

        public long nl() throws IOException {
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

        public double nd() throws IOException {
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
    static class Pair implements Comparable<Pair> {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair o) {
            if (x != o.x)
                return x - o.x;
            return this.y - o.y;
        }
        public int hashCode() {
            return (int) (1L * 10000 * x + y) % 1000000007;
        }
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair other = (Pair) o;
                return other.hashCode() == this.hashCode();
            } else return false;
        }
        public String toString() {
            return x + " " + y;
        }
    }

    static Reader sc = new Reader();
    static StringBuilder sb = new StringBuilder();
    static PrintWriter pw = new PrintWriter(System.out,true);
    static void solve()  throws IOException {
        //write Code here
        int test = sc.ni();
        for(int t =1;t<=test;t++) {
            sb.append("Case #"+t+": ");
            //code here
            int n = sc.ni();
            int arr[][] = new int[n][n];
            long ans = 0;
            for(int i =0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.ni();
                    if(i==j)
                        ans+=arr[i][j];
                }
            }
            sb.append(ans+" ");
            ans =0;
            for(int i =0;i<n;i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if(set.contains(arr[i][j])) {
                        ans++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }

            sb.append(ans+" ");
            ans =0;
            for(int j =0;j<n;j++) {
                Set<Integer> set = new HashSet<>();
                for(int i =0;i<n;i++) {
                    if(set.contains(arr[i][j])) {
                        ans++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }
            sb.append(ans+"\n");
        }
        pw.println(sb);
        pw.flush();
        pw.close();
    }
}