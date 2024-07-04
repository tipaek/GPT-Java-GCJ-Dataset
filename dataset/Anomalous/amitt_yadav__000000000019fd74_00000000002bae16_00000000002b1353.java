import java.io.*;
import java.util.*;

class Solution {

    static long sx = 0, sy = 0, m = (long) (1e9 + 7);
    static ArrayList<Integer>[] a;
    static int[][] dp;
    static long[] farr;
    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static PrintWriter out;
    static ArrayList<Integer> p = new ArrayList<>();
    static long[] fact = new long[(int) 1e6];
    static boolean b = false;
    static StringBuilder sb = new StringBuilder();
    static boolean cycle = false;
    static long mod = 998244353;
    static int[] col;
    static String s;
    static int cnt;

    public static void main(String[] args) throws IOException {
        Reader scn = new Reader();
        out = new PrintWriter(System.out);
        int t = scn.nextInt();

        for (int u = 1; u <= t; u++) {
            ArrayList<Pair> pairs = new ArrayList<>();
            long n = scn.nextLong();

            if (n == 1) {
                pairs.add(new Pair(1, 1));
            } else if (n == 2) {
                pairs.add(new Pair(1, 1));
                pairs.add(new Pair(2, 1));
            } else if (n == 3) {
                pairs.add(new Pair(1, 1));
                pairs.add(new Pair(2, 1));
                pairs.add(new Pair(3, 1));
            } else {
                pairs.add(new Pair(1, 1));
                pairs.add(new Pair(2, 1));
                pairs.add(new Pair(3, 2));
                n -= 4;

                while (n > 0) {
                    int val = pairs.get(pairs.size() - 1).i;
                    if (n - val <= 0) break;
                    n -= val;
                    pairs.add(new Pair(val + 1, 2));
                }

                if (n != 0) {
                    int r = pairs.get(pairs.size() - 1).i;
                    int c = pairs.get(pairs.size() - 1).j - 1;
                    pairs.add(new Pair(r, c));
                    n--;
                }

                while (n != 0) {
                    int r = pairs.get(pairs.size() - 1).i + 1;
                    int c = pairs.get(pairs.size() - 1).j;
                    pairs.add(new Pair(r, c));
                    n--;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Pair rp : pairs) {
                sb.append(rp.i).append(" ").append(rp.j).append("\n");
            }

            out.println("Case #" + u + ": ");
            out.print(sb);
        }

        out.close();
    }

    private static class Pair implements Comparable<Pair> {
        int i, j;

        Pair(int a, int b) {
            i = a;
            j = b;
        }

        @Override
        public int compareTo(Pair o) {
            return 1;
        }
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