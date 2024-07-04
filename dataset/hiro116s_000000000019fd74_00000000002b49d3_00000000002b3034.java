import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/C2";

    FastScanner in;
    PrintWriter out;

    public void solve() {
        int T = in.nextInt();
        for (int _t = 1; _t <= T; _t++) {
            int N = in.nextInt();
            String[] s = in.nextStringArray(N);
            String[] p = new String[N];
            String[] w = new String[N];

            String pp = "";
            String ww = "";
            for (int i = 0; i < N; i++) {
                String[] ws = split(s[i]);
                // System.out.println(s[i] + " " + Arrays.toString(ws));
                p[i] = ws[0];
                w[i] = ws[1];
                if (pp.length() <= p[i].length()) {
                    pp = p[i];
                }
                if (ww.length() <= w[i].length()) {
                    ww = w[i];
                }
            }
            String res = pp + "Z" + ww;
            for (int i = 0; i < N; i++) {
                if (res.startsWith(p[i]) && res.endsWith(w[i])) {
                    // ok
                } else {
                    res = "*";
                    break;
                }
            }
            System.out.println(GcjUtil.format(_t, res));
        }
    }

    private String[] split(String s) {
        String[] res = new String[2];
        int idx = 0;
        res[0] = res[1] = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                idx++;
            } else {
                res[idx] += s.charAt(i);
            }
        }
        return res;
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
