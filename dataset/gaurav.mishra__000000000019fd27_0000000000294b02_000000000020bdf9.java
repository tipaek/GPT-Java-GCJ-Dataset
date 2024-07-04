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
            int[] arr = new int[n];
            int[] brr = new int[n];
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            Map<Integer, Integer> l = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                arr[i] = ob.nextInt();

                brr[i] = ob.nextInt();
            }
            String s = "";
            int i = 0;
            while (i < n) {
                boolean b = true;
                boolean c = true;
                for (Integer k : m.keySet()) {
                     if (brr[i] <= k || arr[i] >= m.get(k)) {
                        continue;
                    } else {
                        b = false;
                        break;
                    }

                }
                if (b == true) {
                    s = s + "C";
                    m.put(arr[i], brr[i]);
                    i++;
                    continue;
                }

                for (Integer e : l.keySet()) {
                    if (brr[i] <= e || arr[i] >= l.get(e)) {
                        continue;
                    } else {
                        c = false;
                        break;
                    }
                }
                if (c == true) {
                    s = s + "J";
                    l.put(arr[i], brr[i]);
                    i++;
                    continue;
                }
                else {
                    s = "IMPOSSIBLE";
                    break;
                }

            }
            System.out.println("Case #" + t + ": " + s);
            System.out.println();
        }
    }
}
