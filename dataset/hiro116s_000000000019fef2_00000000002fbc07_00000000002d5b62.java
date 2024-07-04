import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/T1";

    FastScanner in;
    PrintWriter out;

    public void solve() {
        int T = in.nextInt();
        for (int _t = 1; _t <= T; _t++) {
            long x = in.nextInt(), y = in.nextInt();
            String res = calc(x, y);
            System.out.println(GcjUtil.format(_t, res));
        }
        /*
        int range = 100;
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                String res = calc(x, y);
                if (res.equals("IMPOSSIBLE") && ((x % 2 == 1 && y % 2 == 0) || (x % 2 == 0 && y % 2 == 1))) {
                    throw new RuntimeException("I " + x + " " + y);
                }
                if (!res.equals("IMPOSSIBLE") && !validate(res, x, y)) {
                    throw new RuntimeException(x + " " + y);
                }
            }
        }
         */
    }

    private boolean validate(String res, long gx, long gy) {
        long unit = 1;
        long x = 0, y = 0;
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            if (c == 'E') {
                x += unit;
            } else if (c == 'W') {
                x -= unit;
            } else if (c == 'N') {
                y += unit;
            } else if (c == 'S') {
                y -= unit;
            }
            unit *= 2;
        }
        // System.out.println(x + " " + y + " " + unit / 2 + " " + res);
        return x == gx && y == gy;
    }

    private String calc(long x, long y) {
        char s, e, w, n;
        if (x > 0) {
            e = 'E';
            w = 'W';
        } else {
            e = 'W';
            w = 'E';
            x = -x;
        }
        if (y > 0) {
            s = 'S';
            n = 'N';
        } else {
            s = 'N';
            n = 'S';
            y = -y;
        }

        StringBuilder res = new StringBuilder();
        for (int d = 1; d < 40; d++) {
            if (x % 2 == 1 && y % 2 == 0) {
                int yy = (int) ((y / 2) % 2);
                int xx = (int) (((x + 1) / 2) % 2);
                if ((y != 0 && yy != xx) || (x != 1 && y == 0 && xx != 0)) {
                    x += 1;
                    res.append(w);
                } else {
                    x -= 1;
                    res.append(e);
                }
            } else if (x % 2 == 0 && y % 2 == 1) {
                int xx = (int) ((x / 2) % 2);
                int yy = (int) (((y + 1) / 2) % 2);
                if ((x != 0 && xx != yy) || (y != 1 && x == 0 && yy != 0)) {
                    y += 1;
                    res.append(s);
                } else {
                    y -= 1;
                    res.append(n);
                }
            } else {
                res = new StringBuilder("IMPOSSIBLE");
                break;
            }
            if (x == 0 && y == 0) {
                break;
            }
            x /= 2;
            y /= 2;
        }
        return res.toString();
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
