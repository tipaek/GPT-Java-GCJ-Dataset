import java.io.*;
import java.util.*;

public class Solution {
    static final Scanner sc = new Scanner(System.in);
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = 1_000_000_007;
    static final Reader r = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);
    static int[][] p = new int[502][502];

    private static void precompute(int[][] p) {
        p[1][1] = 1;
        for (int i = 2; i <= 501; i++) {
            for (int j = 1; j <= i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }
    }

    public static void main(final String[] args) throws IOException {
        int testcases = in.nextInt();
        precompute(p);
        for (int i = 0; i < testcases; i++) {
            out.println("Case #" + (i + 1) + ": ");
            long result = processTestCase(p);
        }
        out.flush();
        out.close();
        sc.close();
    }

    private static long processTestCase(int[][] p) throws IOException {
        int[][] saxena = new int[502][502];
        int n = in.nextInt();
        long s = 0;
        ArrayList<Integer> alr = new ArrayList<>();
        ArrayList<Integer> alc = new ArrayList<>();
        found = false;
        b = false;
        c = false;
        findPath(p, saxena, alr, alc, s, n, 1, 1);
        for (int i = 0; i < alr.size(); i++) {
            out.println(alr.get(i) + " " + alc.get(i));
        }
        return 1;
    }

    static boolean found = false, b = false, c = false;

    private static void findPath(int[][] p, int[][] saxena, ArrayList<Integer> alr, ArrayList<Integer> alc, long s,
                                 int n, int i, int j) {
        if (s == n || found) {
            found = true;
            return;
        }
        if (saxena[i][j] == 1 || p[i][j] == 0) {
            return;
        }
        if (s > n || alr.size() > 500) {
            return;
        }
        saxena[i][j] = 1;
        s += p[i][j];
        alr.add(i);
        alc.add(j);
        if (s == n) {
            found = true;
            return;
        }
        if (!b && !found) {
            if (i % 2 == 1) {
                findPath(p, saxena, alr, alc, s, n, i + 1, j);
            } else {
                findPath(p, saxena, alr, alc, s, n, i + 1, j + 1);
            }
        }
        if (!found) {
            if (!c) {
                findPath(p, saxena, alr, alc, s, n, i, j + 1);
                findPath(p, saxena, alr, alc, s, n, i + 1, j + 1);
                findPath(p, saxena, alr, alc, s, n, i - 1, j - 1);
            }
        }
        if (!found) {
            alr.remove(alr.size() - 1);
            alc.remove(alc.size() - 1);
        }
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
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
            byte[] buf = new byte[64];
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