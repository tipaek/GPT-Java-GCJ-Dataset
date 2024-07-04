import java.io.*;
import java.util.*;

class Solution {

    static final long MOD1 = 1_000_000_007;
    static final long MOD2 = 998244353;
    static long sx = 0, sy = 0;
    static ArrayList<Integer>[] a;
    static int[][] dp;
    static long[] farr;
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static PrintWriter out;
    static ArrayList<Integer> p = new ArrayList<>();
    static long[] fact = new long[(int) 1e6];
    static boolean b = false;
    static StringBuilder sb = new StringBuilder();
    static boolean cycle = false;
    static int[] col;
    static String s;
    static int cnt;

    public static void main(String[] args) throws IOException {
        Reader scn = new Reader();
        out = new PrintWriter(System.out);

        int t = scn.nextInt();
        for (int u = 1; u <= t; u++) {
            int n = scn.nextInt();
            int m = n;

            long[][] matrix = scn.nextLong2DArray(n, m);
            long trace = calculateTrace(matrix, n, m);
            int rowsWithDuplicates = countRowsWithDuplicates(matrix, n, m);
            int colsWithDuplicates = countColsWithDuplicates(matrix, n, m);

            out.println("Case #" + u + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }

        out.close();
    }

    private static long calculateTrace(long[][] matrix, int n, int m) {
        long trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithDuplicates(long[][] matrix, int n, int m) {
        int rowsWithDuplicates = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Long> rowSet = new HashSet<>();
            for (int j = 0; j < m; j++) {
                if (rowSet.contains(matrix[i][j])) {
                    rowsWithDuplicates++;
                    break;
                }
                rowSet.add(matrix[i][j]);
            }
        }
        return rowsWithDuplicates;
    }

    private static int countColsWithDuplicates(long[][] matrix, int n, int m) {
        int colsWithDuplicates = 0;
        for (int j = 0; j < m; j++) {
            HashSet<Long> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (colSet.contains(matrix[i][j])) {
                    colsWithDuplicates++;
                    break;
                }
                colSet.add(matrix[i][j]);
            }
        }
        return colsWithDuplicates;
    }

    private static class Pair implements Comparable<Pair> {
        int[] a = new int[26];

        Pair() {
            Arrays.fill(a, 0);
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

        public long[][] nextLong2DArray(int m, int n) throws IOException {
            long[][] arr = new long[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = nextLong();
                }
            }
            return arr;
        }
    }
}