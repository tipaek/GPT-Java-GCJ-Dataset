import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.List;
import java.io.PrintWriter;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/T3";

    FastScanner in;
    PrintWriter out;

    class Pair {
        final int a;
        final int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void solve() {
        int T = in.nextInt();
        for (int _t = 1; _t <= T; _t++) {
            int r = in.nextInt(), s = in.nextInt();
            int[] a = new int[r * s];
            for (int i = 0; i < r * s; i++) {
                a[i] = (i % r) + 1;
            }
            List<Pair> ps = solve2(r, s, a);
            System.out.println(GcjUtil.format(_t, ps.size() + "\n" + ps.stream().map(p -> p.a + " " + p.b).collect(Collectors.joining("\n"))));
        }
    }

    private List<Pair> solve2(int r, int s, int[] a) {
        int n = r * s;
        int[] ideal = new int[n];
        for (int i = 0; i < n; i++) {
            ideal[i] = i / s + 1;
        }
        List<Pair> res = new ArrayList<>();

        // System.out.println("ideal " + Arrays.toString(ideal));
        // System.out.println("init " + Arrays.toString(a));
        int[] b = new int[a.length];
        while (true) {
            int x = n - 1;
            while (x >= 0 && a[x] == ideal[x]) {
                x--;
            }
            if (x == -1) {
                break;
            }
            int y = x - 1;
            while (a[y] != ideal[x]) {
                y--;
            }

            Pair p = new Pair(y + 1, x - y);
            res.add(p);
            for (int i = 0; i < p.a; i++) {
                b[p.b+i] = a[i];
            }
            for (int i = 0; i < p.b; i++) {
                b[i] = a[p.a+i];
            }
            for (int i = x + 1; i < n; i++) {
                b[i] = a[i];
            }
            // System.out.println(x + " " + y + " " + Arrays.toString(b));
            int[] tmp = a;
            a = b;
            b = tmp;
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

class GcjUtil {
    public static String format(final int x, final String s) {
        return "Case #" + x + ": " + s;
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
