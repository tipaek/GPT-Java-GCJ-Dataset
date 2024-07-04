import java.io.*;
import java.util.*;

public class Solution {

    private static final long MOD = 1000000007L;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private InputStream is;
    private PrintWriter out;
    private String INPUT = "";

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private void solve() {
        int Q = readInt();
        for (int q = 1; q <= Q; q++) {
            int N = readInt();
            int[][] intervals = new int[N][4];
            for (int i = 0; i < N; i++) {
                intervals[i][0] = readInt();
                intervals[i][1] = readInt();
                intervals[i][2] = i;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

            int[] lastEnd = {-1, -1};
            boolean possible = true;
            for (int i = 0; i < N; i++) {
                if (lastEnd[0] == -1 || canAssign(intervals, i, lastEnd[0])) {
                    lastEnd[0] = i;
                } else if (lastEnd[1] == -1 || canAssign(intervals, i, lastEnd[1])) {
                    intervals[i][3] = 1;
                    lastEnd[1] = i;
                } else {
                    out.println("Case #" + q + ": " + IMPOSSIBLE);
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

    private boolean canAssign(int[][] intervals, int current, int last) {
        return intervals[last][1] <= intervals[current][0];
    }

    private long power(long a, long b) {
        long result = 1;
        long base = a;
        while (b > 0) {
            if (b % 2 != 0) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            b /= 2;
        }
        return result % MOD;
    }

    private long gcd(long a, long b) {
        while (a != 0) {
            long temp = b % a;
            b = a;
            a = temp;
        }
        return b;
    }

    private void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        long startTime = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) {
            System.out.println((System.currentTimeMillis() - startTime) + "ms");
        }
    }

    private byte[] buffer = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return buffer[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private String readString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private int readInt() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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

    private long readLong() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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