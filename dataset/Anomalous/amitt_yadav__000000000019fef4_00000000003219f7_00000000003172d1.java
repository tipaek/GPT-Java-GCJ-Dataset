import java.io.*;
import java.util.*;

class Solution {

    static long sx = 0, sy = 0, m = (long) (1e9 + 7);
    static ArrayList<Integer>[] a;
    static double[][] dp;
    static long[] farr;
    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static PrintWriter out;
    static long[] fact = new long[(int) 1e6];
    static boolean b = false;
    static StringBuilder sb = new StringBuilder();
    static boolean cycle = false;
    static long mod = (long) 1e9;
    static int[] col;
    static String st;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Pair> p = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Reader scn = new Reader();
        out = new PrintWriter(System.out);

        int t = scn.nextInt();

        for (int u = 1; u <= t; u++) {
            int ans = solveCase(scn);
            out.println("Case #" + u + ": " + ans);
        }

        out.close();
    }

    private static int solveCase(Reader scn) throws IOException {
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

        if (max >= d || d == 1) return 0;
        if (d == 2) return (n == 1 && a[0] % 2 == 1) ? 2 : 1;

        if (n == 1) return 2;
        if (n == 2) return (a[1] % 2 == 0 && a[1] / 2 == a[0]) ? 1 : 2;

        long last = hm.lastKey();
        for (long k : hm.keySet()) {
            if ((hm.get(k) >= 2 && k != last) || (k % 2 == 0 && hm.containsKey(k / 2))) {
                return 1;
            }
        }

        return 2;
    }

    private static class Pair implements Comparable<Pair> {
        int a, b;

        Pair(int x, int y) {
            a = x;
            b = y;
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

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1000000 + 1];
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
                for (int j = 0; j < n; j++)
                    arr[i][j] = nextInt();
            }
            return arr;
        }

        public long[][] nextInt2DArrayL(int m, int n) throws IOException {
            long[][] arr = new long[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    arr[i][j] = nextInt();
            }
            return arr;
        }
    }
}