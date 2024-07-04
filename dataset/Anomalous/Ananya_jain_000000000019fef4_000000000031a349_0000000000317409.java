import java.io.*;
import java.util.*;

public class Solution {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = (int) (1e9 + 7);
    static final int MODFFT = 998244353;
    static final Reader reader = new Reader();
    static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    int[] level, parent;
    List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        int testCases = hasTestCases ? readInt() : 1;
        for (int i = 0; i < testCases; i++) {
            out.print("Case " + (i + 1) + ": ");
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

    static final boolean hasTestCases = true, fastIO = false;
    static final boolean hasPrint = false, hasBooleanPrint = false;
    static final int LINE_LENGTH = 1000002;

    private long solve() throws Exception {
        int x = readInt();
        int y = readInt();
        String moves = readLine().trim();
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            if (Math.abs(x) + Math.abs(y) <= i + 1) {
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
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static String readString() throws Exception {
        return fastIO ? reader.next() : in.next();
    }

    static int[] readIntArray(int n) throws Exception {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        return arr;
    }

    static String readLine() throws Exception {
        return fastIO ? reader.readLine() : in.nextLine();
    }

    static int readInt() throws Exception {
        return fastIO ? reader.nextInt() : in.nextInt();
    }

    static long readLong() throws Exception {
        return fastIO ? reader.nextLong() : in.nextLong();
    }

    static double readDouble() throws Exception {
        return fastIO ? reader.nextDouble() : in.nextDouble();
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
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws Exception {
            return br.readLine();
        }

        private static final byte[] buf = new byte[LINE_LENGTH];

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