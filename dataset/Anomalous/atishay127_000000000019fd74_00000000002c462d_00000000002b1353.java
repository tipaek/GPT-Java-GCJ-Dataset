import java.io.*;
import java.util.*;

public class Solution {
    static final Scanner sc = new Scanner(System.in);
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = (int) (1e9 + 7);
    static final Reader reader = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);
    static final int MAX_SIZE = 500 + 2;
    static int[][] p = new int[MAX_SIZE][MAX_SIZE];
    static boolean found = false;

    public static void main(final String[] args) throws IOException {
        int testcases = in.nextInt();
        precomputePascalTriangle(p);
        for (int i = 0; i < testcases; i++) {
            out.println("Case #" + (i + 1) + ": ");
            solveTestCase(p);
        }
        out.flush();
        out.close();
        sc.close();
    }

    private static void precomputePascalTriangle(int[][] p) {
        p[1][1] = 1;
        for (int i = 2; i < MAX_SIZE; i++) {
            for (int j = 1; j <= i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }
    }

    private static void solveTestCase(int[][] p) throws IOException {
        int[][] visited = new int[MAX_SIZE][MAX_SIZE];
        int n = in.nextInt();
        long sum = 0;
        ArrayList<Integer> alr = new ArrayList<>();
        ArrayList<Integer> alc = new ArrayList<>();
        found = false;
        calculatePath(p, visited, alr, alc, sum, n, 1, 1);
        for (int i = 0; i < alr.size(); i++) {
            out.println(alr.get(i) + " " + alc.get(i));
        }
    }

    private static void calculatePath(int[][] p, int[][] visited, ArrayList<Integer> alr, ArrayList<Integer> alc, long sum, int n, int i, int j) {
        if (sum == n || found) {
            found = true;
            return;
        }
        if (visited[i][j] == 1 || p[i][j] == 0 || sum > n || alr.size() > 500) {
            return;
        }
        visited[i][j] = 1;
        sum += p[i][j];
        alr.add(i);
        alc.add(j);
        if (sum == n) {
            found = true;
            return;
        }
        if (!found) {
            if (i % 2 == 1) {
                calculatePath(p, visited, alr, alc, sum, n, i + 1, j);
            } else {
                calculatePath(p, visited, alr, alc, sum, n, i + 1, j + 1);
            }
        }
        if (!found) {
            calculatePath(p, visited, alr, alc, sum, n, i, j + 1);
            calculatePath(p, visited, alr, alc, sum, n, i + 1, j + 1);
            calculatePath(p, visited, alr, alc, sum, n, i - 1, j - 1);
        }
        if (!found) {
            alr.remove(alr.size() - 1);
            alc.remove(alc.size() - 1);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(final String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
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