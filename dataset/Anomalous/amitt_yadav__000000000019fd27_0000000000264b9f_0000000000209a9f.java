import java.io.*;
import java.util.*;

public class Solution {

    static long sx = 0, sy = 0, m = (long) 1e9 + 7;
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
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);

        int t = scn.nextInt();
        for (int u = 1; u <= t; u++) {
            String s = scn.next();
            String ans = processString(s, 0, s.length() - 1, 0);
            out.println("Case #" + u + ": " + ans);
        }

        out.close();
    }

    private static String processString(String s, int si, int ei, int depth) {
        if (si > ei) return "";
        if (si == ei) {
            int tba = (s.charAt(si) - '0') - depth;
            String rs = s.charAt(si) + "";
            for (int i = 0; i < tba; i++) {
                rs = "(" + rs + ")";
            }
            return rs;
        }

        int min = 10;
        for (int i = si; i <= ei; i++) {
            min = Math.min(min, s.charAt(i) - '0');
        }

        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = si; i <= ei; i++) {
            if (s.charAt(i) - '0' == min) {
                positions.add(i);
            }
        }

        int tba = min - depth;
        String ms = processString(s, si, positions.get(0) - 1, depth + tba);
        for (int i = 1; i < positions.size(); i++) {
            ms += min;
            ms += processString(s, positions.get(i - 1) + 1, positions.get(i) - 1, depth + tba);
        }
        ms += min;
        ms += processString(s, positions.get(positions.size() - 1) + 1, ei, depth + tba);

        for (int i = 0; i < tba; i++) {
            ms = "(" + ms + ")";
        }

        return ms;
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
            byte[] buf = new byte[1000001];
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