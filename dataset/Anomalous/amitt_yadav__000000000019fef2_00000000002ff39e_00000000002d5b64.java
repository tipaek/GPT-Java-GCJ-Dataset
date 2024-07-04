import java.io.*;
import java.util.*;

class Solution {

    static final long MOD = (long) 1e9 + 7;
    static final long MOD2 = (long) 1e9;
    static final int MAX_FACT_SIZE = (int) 1e6;

    static ArrayList<Integer>[] a;
    static double[][] dp;
    static long[] farr;
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static PrintWriter out;
    static long[] fact = new long[MAX_FACT_SIZE];
    static StringBuilder sb = new StringBuilder();
    static int[] col;
    static String st;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Pair> p = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);

        int t = scn.nextInt();

        for (int u = 1; u <= t; u++) {
            int r = scn.nextInt();
            int s = scn.nextInt();

            int x = r - 1;
            int y = s - 1;

            ArrayList<Pair> p = new ArrayList<>();

            while (x != 0) {
                for (int i = 0; i < y; i++) {
                    p.add(new Pair(-1, x));
                }
                x--;
            }

            x = r * (s - 1);

            for (Pair rp : p) {
                rp.a = x--;
            }

            out.println("Case #" + u + ": " + p.size());

            for (Pair rp : p) {
                out.println(rp.a + " " + rp.b);
            }
        }

        out.close();
    }

    private static class Pair implements Comparable<Pair> {
        int a, b;

        Pair(int x, int y) {
            this.a = x;
            this.b = y;
        }

        @Override
        public int compareTo(Pair o) {
            return 1;
        }
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
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
            byte[] buf = new byte[1000000 + 1]; // line length
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
            if (neg) return -ret;
            return ret;
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
            if (neg) return -ret;
            return ret;
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

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public int[][] nextInt2DArray(int m, int n) throws IOException {
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = nextInt();
                }
            }
            return arr;
        }

        public long[][] nextInt2DArrayL(int m, int n) throws IOException {
            long[][] arr = new long[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = nextInt();
                }
            }
            return arr;
        }
    }
}