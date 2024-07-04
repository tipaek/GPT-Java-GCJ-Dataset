import java.io.*;
import java.util.*;

public class Solution {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = (int) (1e9 + 7);
    static final int MODFFT = 998244353;
    static final Reader r = new Reader();
    static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    
    int[] level, p;
    List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        int testcases = hasTestCases ? ni() : 1;
        for (int i = 0; i < testcases; i++) {
            out.print("Case #" + (i + 1) + ": ");
            long result = new Solution().solve();
            if (hasPrint) {
                if (hasBooleanPrint) {
                    out.println(result == 0 ? "no" : "yes");
                } else {
                    out.println(result);
                }
            }
        }
        out.flush();
    }

    static final boolean hasTestCases = true;
    static final boolean fastIO = false;
    static final boolean hasPrint = false;
    static final boolean hasBooleanPrint = false;
    static final int LINE_LENGTH = 1000002;

    private long solve() throws Exception {
        int x = ni();
        int y = ni();
        String m = nln().trim();
        for (int i = 0; i < m.length(); i++) {
            char ch = m.charAt(i);
            switch (ch) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                pn(i + 1);
                return -1;
            }
            if (x + y < i + 1) {
                int temp = i + 1 - x - y;
                if (temp % 2 == 0) {
                    pn(i + 1);
                    return -1;
                }
            }
        }
        pn("IMPOSSIBLE");
        return 1;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static String n() throws Exception {
        return fastIO ? r.next() : in.next();
    }

    static int[] na(int n) throws Exception {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    static String nln() throws Exception {
        return fastIO ? r.readLine() : in.nextLine();
    }

    static int ni() throws Exception {
        return fastIO ? r.nextInt() : in.nextInt();
    }

    static long nl() throws Exception {
        return fastIO ? r.nextLong() : in.nextLong();
    }

    static double nd() throws Exception {
        return fastIO ? r.nextDouble() : in.nextDouble();
    }

    static void p(Object o) {
        out.print(o);
    }

    static void pn(Object o) {
        out.println(o);
    }

    static void pn() {
        out.println();
    }

    static void pni(Object o) {
        out.println(o);
        out.flush();
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 19;
        private final DataInputStream din;
        private final BufferedReader br;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        private StringTokenizer st;

        public Reader() {
            din = new DataInputStream(System.in);
            br = new BufferedReader(new InputStreamReader(System.in));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            br = new BufferedReader(new FileReader(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws Exception {
            return br.readLine();
        }

        public String readLine() throws IOException {
            int cnt = 0, c;
            byte[] buf = new byte[LINE_LENGTH];
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

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            return neg ? -ret : ret;
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