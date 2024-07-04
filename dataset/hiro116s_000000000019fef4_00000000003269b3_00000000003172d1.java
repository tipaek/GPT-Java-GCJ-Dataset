import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/C1";

    FastScanner in;
    PrintWriter out;

    public void solve() {
        int T = in.nextInt();
        for (int _t = 1; _t <= T; _t++) {
            int N = in.nextInt(), D = in.nextInt();
            long[] a = in.nextLongArray(N);

            long cut = D - 1;
            for (int r = D; r >= 1; r--) {
                long[] b = new long[N];
                for (int i = 0; i < N; i++) {
                    b[i] = a[i] * r;
                }
                for (int i = 0; i < N; i++) {
                    List<Integer> l1 = new ArrayList<>();
                    List<Integer> l2 = new ArrayList<>();
                    for (int j = 0; j < N; j++) {
                        if (b[j] % a[i] == 0) {
                            long num = b[j] / a[i];
                            if (num <= D) {
                                l1.add((int) num);
                            } else {
                                l2.add((int) Math.min(num, D));
                            }
                        } else if (b[j] / a[i] != 0) {
                            l2.add((int) Math.min(D, b[j] / a[i]));
                        }
                    }
                    cut = Math.min(cut, calc(l1.toArray(new Integer[l1.size()]), l2.toArray(new Integer[l2.size()]), D));
                }
            }
            String res = cut + "";
            System.out.println(GcjUtil.format(_t, res));
        }
    }

    private int calc(Integer[] l1, Integer[] l2, int d) {
        int[] dp = new int[d+1];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        for (int x : l1) {
            for (int i = d - 1; i >= 0; i--) {
                int ni = Math.min(i+x,d);
                dp[ni] = Math.min(dp[ni], dp[i] + x - 1);
            }
        }
        for (int x : l2) {
            for (int i = d - 1; i >= 0; i--) {
                int ni = Math.min(i+x,d);
                dp[ni] = Math.min(dp[ni], dp[i] + x);
            }
        }

        return dp[d];
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
