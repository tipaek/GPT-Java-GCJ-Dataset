import java.util.Objects;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/N3";

    FastScanner in;
    PrintWriter out;

    class Ans {
        final long N;
        final long L;
        final long R;

        public Ans(long n, long l, long r) {
            N = n;
            L = l;
            R = r;
        }

        @Override
        public String toString() {
            return "Ans{" +
                    "N=" + N +
                    ", L=" + L +
                    ", R=" + R +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ans ans = (Ans) o;
            return N == ans.N &&
                    L == ans.L &&
                    R == ans.R;
        }

        @Override
        public int hashCode() {
            return Objects.hash(N, L, R);
        }
    }

    public void solve() {
        /*
        for (int L = 0; L < 1000; L++) {
            System.out.println(L);
            for (int R = 0; R < 1000; R++) {
                Ans ans1 = solve1(L, R);
                Ans ans2 = solve2(L, R);
                if (!ans1.equals(ans2)) {
                    System.out.println(ans1.toString());
                    System.out.println(ans2.toString());
                    return;
                }
            }
        }

         */

        int T = in.nextInt();
        for (int _times = 0; _times < T; _times++) {
            long L = in.nextLong();
            long R = in.nextLong();
            Ans ans1 = solve1(L, R);
            System.out.println(GcjUtil.format(_times, ans1.N + " " + ans1.L + " " + ans1.R));
        }
    }

    private Ans solve1(long _l, long _r) {
        long L = _l, R = _r;

        long n = 0;
        if (L < R) {
            long s = find(R - L);
            R -= (s * (s + 1)) / 2;
            n += s;
        } else {
            long s = find(L - R);
            L -= (s * (s + 1)) / 2;
            n += s;
        }

        if (L >= R) {
            long s1 = find2(n, L);
            long s2 = find2(n + 1, R);
            if (Math.abs(s1 - s2) >= 2) {
                throw new RuntimeException();
            }
            long l1 = n + 2 * s1;
            long l2 = (n + 1) + 2 * s2;
            L -= (s1 * (n + l1)) / 2;
            R -= (s2 * ((n + 1) + l2)) / 2;
            n += s1 + s2;
        } else {
            long s1 = find2(n, R);
            long s2 = find2(n + 1, L);
            if (Math.abs(s1 - s2) >= 2) {
                throw new RuntimeException();
            }
            long l1 = n + 2 * s1;
            long l2 = (n + 1) + 2 * s2;
            R -= (s1 * (n + l1)) / 2;
            L -= (s2 * ((n + 1) + l2)) / 2;
            n += s1 + s2;
        }
        return new Ans(n, L, R);
    }

    private long find(long l) {
        long lo = 0, hi = 1_000_000_100;
        while (hi - lo > 1) {
            long mid = (hi + lo) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum <= l) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


    private long find2(long s, long l) {
        long lo = 0, hi = 1_000_000_100;
        while (hi - lo > 1) {
            long mid = (hi + lo) / 2;
            long last = s + 2 * mid;
            long sum = (mid * (s + last)) / 2;
            if (sum <= l) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private Ans solve2(int l, int r) {
        for (int i = 1; ; i++) {
            if (l >= r) {
                if (i <= l) {
                    l -= i;
                } else {
                    return new Ans(i - 1, l, r);
                }
            } else {
                if (i <= r) {
                    r -= i;
                } else {
                    return new Ans(i - 1, l, r);
                }
            }
        }
    }

    public void run() {
        if (__FILE_DEBUG_FLAG__ == __t__) {
            try {
                is = new FileInputStream(__DEBUG_FILE_NAME__);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("FILE_INPUT!");
        } else {
            is = System.in;
        }
        in = new FastScanner(is);
        out = new PrintWriter(System.out);

        solve();
    }

    public static void main(final String[] args) {
        new Solution().run();
    }
}


class FastScanner {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScanner(InputStream stream) {
        this.stream = stream;
        // stream = new FileInputStream(new File("dec.in"));
    }

    int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = nextInt();

        return array;
    }

    public int[][] nextIntMap(int n, int m) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextIntArray(m);
        }
        return map;
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = nextLong();

        return array;
    }

    public long[][] nextLongMap(int n, int m) {
        long[][] map = new long[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextLongArray(m);
        }
        return map;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++)
            array[i] = nextDouble();

        return array;
    }

    public double[][] nextDoubleMap(int n, int m) {
        double[][] map = new double[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextDoubleArray(m);
        }
        return map;
    }

    public String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++)
            array[i] = next();

        return array;
    }

    public String nextLine() {
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }

    public int[][] nextPackedIntArrays(int packN, int size) {
        int[][] res = new int[packN][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < packN; j++) {
                res[j][i] = nextInt();
            }
        }
        return res;
    }
}

class GcjUtil {
    public static String format(final int x, final String s) {
        return "Case #" + x + ": " + s;
    }
}
