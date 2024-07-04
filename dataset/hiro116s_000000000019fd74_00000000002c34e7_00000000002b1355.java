import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.io.FileNotFoundException;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/B1";

    FastScanner in;
    PrintWriter out;

    int MAX = 510;

    int[] vx = {0, -1, 0, 1};
    int[] vy = {1, 0, -1, 0};

    public void solve() {
        int T = in.nextInt();
        for (int _t = 1; _t <= T; _t++) {
            int R = in.nextInt(), C = in.nextInt();
            int[][] S = in.nextIntMap(R, C);
            int[][] nextS = new int[R][C];

            boolean loop = true;
            long res = 0;
            while (loop) {
                loop = false;

                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (S[r][c] == -1) continue;
                        res += S[r][c];
                        int tot = 0;
                        int cnt = 0;
                        for (int d = 0; d < 4; d++) {
                            int nr = r + vy[d];
                            int nc = c + vx[d];
                            while (0 <= nr && nr < R && 0 <= nc && nc < C && S[nr][nc] == -1) {
                                nr += vy[d];
                                nc += vx[d];
                            }
                            if (0 <= nr && nr < R && 0 <= nc && nc < C && S[nr][nc] != -1) {
                                tot += S[nr][nc];
                                cnt++;
                            }
                        }
                        if (tot <= S[r][c] * cnt) {
                            nextS[r][c] = S[r][c];
                        } else {
                            nextS[r][c] = -1;
                            loop = true;
                        }
                    }
                }
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        S[r][c] = nextS[r][c];
                    }
                }
            }
            System.out.println(GcjUtil.format(_t, res + ""));
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
