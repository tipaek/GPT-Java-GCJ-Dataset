import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class Solution {

    private static final int MAXN = 5000;
    private static final String NO = "NO";
    private static final String YES = "YES";
    private static final long MOD = 1000000007L;
    private static final int MAX = 200000;

    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int Q = ni();
        for (int q = 1; q <= Q; q++) {
            int N = ni();
            int[][] intervals = new int[N][4];
            for (int i = 0; i < N; i++) {
                intervals[i][0] = ni();
                intervals[i][1] = ni();
                intervals[i][2] = i;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int[] last = {-1, -1};
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                if (last[0] == -1 || isCompatible(intervals, i, last[0])) {
                    last[0] = i;
                } else if (last[1] == -1 || isCompatible(intervals, i, last[1])) {
                    intervals[i][3] = 1;
                    last[1] = i;
                } else {
                    out.println("Case #" + q + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Arrays.sort(intervals, Comparator.comparingInt(a -> a[2]));
                StringBuilder result = new StringBuilder();
                for (int[] interval : intervals) {
                    result.append(interval[3] == 0 ? 'C' : 'J');
                }
                out.println("Case #" + q + ": " + result.toString());
            }
        }
    }

    private boolean isCompatible(int[][] intervals, int current, int last) {
        return intervals[last][1] <= intervals[current][0];
    }

    long power(long base, long exp) {
        long result = 1;
        long modBase = base % MOD;
        while (exp > 0) {
            if (exp % 2 != 0) {
                result = (result * modBase) % MOD;
            }
            modBase = (modBase * modBase) % MOD;
            exp /= 2;
        }
        return result;
    }

    private long gcd(long a, long b) {
        while (a != 0) {
            long temp = b % a;
            b = a;
            a = temp;
        }
        return b;
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        long startTime = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) {
            System.out.println((System.currentTimeMillis() - startTime) + "ms");
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n) {
            if (!isSpaceChar(b)) buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = ns(m);
        }
        return map;
    }

    private int[] na(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = ni();
        }
        return array;
    }

    private List<Integer> na2(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(ni());
        }
        return list;
    }

    private int[][] na(int n, int m) {
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) {
            array[i] = na(m);
        }
        return array;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long[] nl(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nl();
        }
        return array;
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}