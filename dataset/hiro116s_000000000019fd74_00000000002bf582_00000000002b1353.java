import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/B1";

    FastScanner in;
    PrintWriter out;

    int MAX = 510;

    public void solve() {
        long[][] triangle = new long[MAX+1][];
        triangle[1] = new long[2];
        triangle[1][1] = 1;
        for (int i = 2; i <= MAX; i++) {
            triangle[i] = new long[i+1];
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = triangle[i-1][j-1];
                if (j != i) {
                    triangle[i][j] += triangle[i-1][j];
                }
            }
            if (i < 100) {
                // System.out.println(Arrays.toString(triangle[i]));
            }
        }
        /*
        for (int i = 1; i <= 1000; i++) {
            try {
                List<String> res = solve2(i, triangle);
                // System.out.println(GcjUtil.format(i, "\n" + String.join("\n", solve2(i, triangle))));
                if (res == null) {
                    throw new RuntimeException("null " + i);
                }
                if (restore(res, triangle) != i) {
                    throw new RuntimeException("wrong " + i);
                }
            } catch (Exception e) {
                throw new RuntimeException("Fail " + i, e);
            }
        }
        System.out.println("OK");

         */
        int T = in.nextInt();
        for (int _t = 1; _t <= T; _t++) {
            int N = in.nextInt();
            System.out.println(GcjUtil.format(_t, "\n" + String.join("\n", solve2(N, triangle))));
        }
    }

    private int restore(List<String> list, long[][] triagnle) {
        if (list.size() > 500) {
            throw new RuntimeException("Fail");
        }
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for (String s : list) {
            if (set.contains(s)) {
                throw new RuntimeException();
            }
            set.add(s);
            String[] ws = s.split(" ");
            int r = Integer.valueOf(ws[0]);
            int c = Integer.valueOf(ws[1]);
            if (r > 500 || c > 500) {
                throw new RuntimeException("invalid " + r + " " + c);
            }
            res += triagnle[r][c];
        }
        return res;
    }

    private List<String> solve2(int n, long[][] triangle) {
        for (int i = 1; i < 500; i++) {
            List<String> list = calc(n, i, triangle);
            if (list != null && list.size() <= 500) {
                return list;
            }
        }
        return null;
    }

    private List<String> calc(int n, int depth, long[][] triangle) {
        List<String> res = new ArrayList<>();

        int r = 1, c = 1;
        long cur = triangle[r][c];
        res.add(r + " " + c);
        while (r < depth) {
            r++;
            c++;
            res.add(r + " " + c);
            cur += triangle[r][c];
        }
        if (depth == 1 || r == 500) {
            return cur == n ? res : null;
        }
        if (cur == n) {
            return res;
        } else if (cur > n) {
            return null;
        }

        r++;
        res.add(r + " " + c);
        cur += triangle[r][c];
        while (r < 500 && cur + triangle[r+1][c] <= n) {
            r++;
            res.add(r + " " + c);
            cur += triangle[r][c];
        }
        if (n == cur) {
            return res;
        } else if (cur > n) {
            return null;
        }
        c--;
        res.add(r + " " + c);
        cur += triangle[r][c];
        while (r > 2 && cur < n) {
            try {
                if (c <= r - 1 && cur + triangle[r - 1][c] <= n) {
                    r--;
                } else {
                    r--;
                    c--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            res.add(r + " " + c);
            cur += triangle[r][c];
        }
        return n == cur ? res : null;
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
