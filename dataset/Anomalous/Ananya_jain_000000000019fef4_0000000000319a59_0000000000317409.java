import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Solution {
    static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = 1_000_000_007;
    static final int MODFFT = 998_244_353;
    static final Reader reader = new Reader();
    static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final boolean HAS_TEST_CASES = true;
    static final boolean FAST_IO = false;
    static final boolean HAS_PRINT = false;
    static final boolean HAS_BOOLEAN_PRINT = false;
    static final int LINE_LENGTH = 1_000_002;

    int[] level, parent;
    List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        int testcases = HAS_TEST_CASES ? nextInt() : 1;
        for (int i = 0; i < testcases; i++) {
            out.print("Case " + (i + 1) + ": ");
            long result = new Solution().solve();
            if (HAS_PRINT) {
                if (HAS_BOOLEAN_PRINT) {
                    out.println(result == 0 ? "no" : "yes");
                } else {
                    out.println(result);
                }
            }
        }
        out.flush();
    }

    private long solve() throws Exception {
        int x = nextInt();
        int y = nextInt();
        String directions = nextLine().trim();
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);
            switch (direction) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            if (abs(x) + abs(y) <= i + 1) {
                println(i + 1);
                return -1;
            }
            if (x + y < i + 1) {
                int temp = i + 1 - x - y;
                if (temp % 2 == 0) {
                    println(i + 1);
                    return -1;
                }
            }
        }
        println("IMPOSSIBLE");
        return 1;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static String next() throws Exception {
        return FAST_IO ? reader.next() : scanner.next();
    }

    static int[] nextIntArray(int n) throws Exception {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    static String nextLine() throws Exception {
        return FAST_IO ? reader.readLine() : scanner.nextLine();
    }

    static int nextInt() throws Exception {
        return FAST_IO ? reader.nextInt() : scanner.nextInt();
    }

    static long nextLong() throws Exception {
        return FAST_IO ? reader.nextLong() : scanner.nextLong();
    }

    static double nextDouble() throws Exception {
        return FAST_IO ? reader.nextDouble() : scanner.nextDouble();
    }

    static void print(Object o) {
        out.print(o);
    }

    static void println(Object o) {
        out.println(o);
    }

    static void println() {
        out.println();
    }

    static void printAndFlush(Object o) {
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

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            br = new BufferedReader(new FileReader(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        public String nextLine() throws Exception {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
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