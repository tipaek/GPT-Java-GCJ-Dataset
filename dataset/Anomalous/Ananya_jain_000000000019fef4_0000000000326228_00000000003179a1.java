import java.io.*;
import java.util.*;

public class cf {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = (int) (1e9 + 7);
    static final int MODFFT = 998244353;
    static final Reader r = new Reader();
    static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    int[] level, p;
    List<Integer>[] adj;

    public static void main(final String[] args) throws Exception {
        final int testcases = hasTestCases ? ni() : 1;
        for (int i = 0; i < testcases; i++) {
            out.print("Case #" + (i + 1) + ": ");
            final long an = new cf().solve();
            if (hasPrint) {
                if (hasBooleanPrint) {
                    out.println(an == 0 ? "no" : "yes");
                } else {
                    out.println(an);
                }
            }
        }
        out.flush();
    }

    static final boolean hasTestCases = true, fastIO = false;
    static final boolean hasPrint = false, hasBooleanPrint = false;
    static final int lineLength = 1000002;

    private long solve() throws Exception {
        int u = ni();
        int[] f = new int[10];
        char[] c = new char[10];
        Arrays.fill(c, 'q');
        Arrays.fill(f, 10);
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int y = ni();
            String m = nln().trim();
            if (y == -1) {
                continue;
            }
            if (Math.log10(y) > m.length()) {
                continue;
            }
            int ii = 0;
            char ch;
            for (int jj = 0; jj < m.length(); jj++) {
                ch = m.charAt(jj);
                int j = 0;
                while (c[j] != 'q' && c[j] != ch) {
                    j++;
                }
                if (c[j] == 'q') {
                    c[j] = ch;
                }
            }
            ch = m.charAt(ii);
            while (y > 10) {
                y /= 10;
            }
            int j = 0;
            while (c[j] != 'q' && c[j] != ch) {
                j++;
            }
            if (c[j] == 'q') {
                c[j] = ch;
            }
            f[j] = Math.min(f[j], y);
        }
        for (int i = 0; i < c.length; i++) {
            int min = 100, mini = -1;
            for (int j = 0; j < c.length; j++) {
                if (min > f[j]) {
                    min = f[j];
                    mini = j;
                }
            }
            p(c[mini]);
            f[mini] = 10000;
        }
        return 1;
    }

    static int gcd(final int a, final int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static String n() throws Exception {
        return fastIO ? r.next() : in.next();
    }

    static int[] na(final int n) throws Exception {
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

    static void p(final Object o) {
        out.print(o);
    }

    static void pn(final Object o) {
        out.println(o);
    }

    static void pn() {
        out.println("");
    }

    static void pni(final Object o) {
        out.println(o);
        out.flush();
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 19;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        private StringTokenizer st;
        private final BufferedReader br;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public Reader(final String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            br = new BufferedReader(new FileReader(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (final IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        public String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }

        private static final byte[] buf = new byte[lineLength];

        public String readLine() throws IOException {
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
            final boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            final boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            final boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) return -ret;
            return ret;
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
            if (din == null) return;
            din.close();
        }
    }
}