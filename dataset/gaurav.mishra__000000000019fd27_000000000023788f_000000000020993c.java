import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

 class Solution {

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
            } while ((c = read()) >= '0' && c <= '9');
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
            } while ((c = read()) >= '0' && c <= '9');

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

    public static void main(String[] args) throws IOException {

        Reader ob = new Reader();
        int T = ob.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = ob.nextInt();
            int[][] arr = new int[n][n];
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                HashSet<Integer> m = new HashSet<Integer>();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = ob.nextInt();
                    m.add(arr[i][j]);
                }
                map.put(i, m.size());
            }
            Map<Integer, Integer> ma = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                HashSet<Integer> m = new HashSet<Integer>();
                for (int j = 0; j < n; j++) {
                    m.add(arr[j][i]);
                }
                ma.put(i, m.size());
            }
            int r = 0;
            for (int i = 0; i < n; i++) {
                int size = map.get(i);
                if (size < n) {
                    r++;
                }
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                int size = ma.get(i);
                if (size < n) {
                    c++;
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + arr[i][i];
            }

            System.out.println("Case #" + t + ": " + sum + " " + r + " " + c);

        }

    }
}
