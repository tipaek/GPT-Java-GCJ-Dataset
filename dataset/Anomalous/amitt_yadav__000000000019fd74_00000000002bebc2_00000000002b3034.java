import java.io.*;
import java.util.*;

public class Solution {

    static long sx = 0, sy = 0, m = 1_000_000_007L;
    static ArrayList<Integer>[] a;
    static int[][] dp;
    static long[] farr;
    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static PrintWriter out;
    static ArrayList<Integer> p = new ArrayList<>();
    static long[] fact = new long[1_000_000];
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
            int n = scn.nextInt();
            String[] str = new String[n];

            for (int i = 0; i < n; i++) {
                str[i] = scn.next();
            }

            String pref = "";
            String suff = "";
            int maxi = 0;

            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < str[i].length(); j++) {
                    if (str[i].charAt(j) == '*') break;
                    cnt++;
                }
                if (cnt > maxi) {
                    maxi = cnt;
                    pref = str[i].substring(0, cnt);
                }
            }

            boolean isInvalid = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < str[i].length() && j < pref.length(); j++) {
                    if (str[i].charAt(j) == '*') break;
                    if (str[i].charAt(j) != pref.charAt(j)) {
                        isInvalid = true;
                        break;
                    }
                }
                if (isInvalid) break;
            }

            if (isInvalid) {
                out.println("Case #" + u + ": *");
                continue;
            }

            maxi = 0;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = str[i].length() - 1; j >= 0; j--) {
                    if (str[i].charAt(j) == '*') break;
                    cnt++;
                }
                if (cnt > maxi) {
                    maxi = cnt;
                    suff = str[i].substring(str[i].length() - cnt);
                }
            }

            isInvalid = false;
            for (int i = 0; i < n; i++) {
                int k = suff.length() - 1;
                for (int j = str[i].length() - 1; j >= 0 && k >= 0; j--, k--) {
                    if (str[i].charAt(j) == '*') break;
                    if (str[i].charAt(j) != suff.charAt(k)) {
                        isInvalid = true;
                        break;
                    }
                }
                if (isInvalid) break;
            }

            if (isInvalid) {
                out.println("Case #" + u + ": *");
                continue;
            }

            out.println("Case #" + u + ": " + pref + suff);
        }

        out.close();
    }

    private static class Pair implements Comparable<Pair> {
        int sum = 0;
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

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1_000_001];
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