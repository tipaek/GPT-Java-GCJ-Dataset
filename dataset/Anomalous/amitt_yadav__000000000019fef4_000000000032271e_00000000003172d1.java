import java.io.*;
import java.util.*;

public class Solution {

    static final long MOD = (long) 1e9 + 7;
    static PrintWriter out;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Reader scn = new Reader();
        out = new PrintWriter(System.out);

        int t = scn.nextInt();

        for (int u = 1; u <= t; u++) {
            int ans = -1;
            int n = scn.nextInt();
            int d = scn.nextInt();
            long[] a = scn.nextLongArray(n);
            Arrays.sort(a);

            TreeMap<Long, Integer> hm = new TreeMap<>();
            int max = 0;

            for (long x : a) {
                hm.put(x, hm.getOrDefault(x, 0) + 1);
                max = Math.max(max, hm.get(x));
            }

            if (max >= d) {
                ans = 0;
            } else if (d == 2) {
                ans = 1;
            } else {
                ans = calculateAns(n, a, hm);
            }

            out.println("Case #" + u + ": " + ans);
        }

        out.close();
    }

    private static int calculateAns(int n, long[] a, TreeMap<Long, Integer> hm) {
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return (a[1] % 2 == 0 && a[1] / 2 == a[0]) ? 1 : 2;
        } else {
            long last = hm.lastKey();
            for (long k : hm.keySet()) {
                if (hm.get(k) >= 2 && k != last) {
                    return 1;
                }
                if (k % 2 == 0 && hm.containsKey(k / 2)) {
                    return 1;
                }
            }
            return 2;
        }
    }

    private static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1000001];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) din.close();
        }
    }
}