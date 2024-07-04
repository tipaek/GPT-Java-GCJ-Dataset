import java.util.Set;
import java.util.InputMismatchException;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStream;
import java.util.stream.Collectors;
import java.io.FileInputStream;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __t__;
    String __DEBUG_FILE_NAME__ = "src/E2";

    FastScanner in;
    PrintWriter out;

    public void solve() {
        int T = in.nextInt();
        for (int __times = 1; __times <= T; __times++) {
            int N = in.nextInt(), K = in.nextInt();
            int[] diag = find(N, K);
            if (diag == null) {
                System.out.println(GcjUtil.format(__times, "IMPOSSIBLE"));
                continue;
            }
            int[][] res = construct(diag);
            System.out.println(GcjUtil.format(__times, "POSSIBLE\n" + toAnswer(res)));
        }
        System.exit(0);
    }

    private int[][] construct(int[] diag) {
        int n = diag.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = diag[i];
        }
        Set<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    sets[x].add(y + 1);
                }
                sets[x].remove(res[i][i]);
            }
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (res[y][x] != 0) sets[x].remove(res[y][x]);
                }
            }
            while (true) {
                boolean fin = true;
                for (int j = 0; j < n; j++) {
                    fin &= res[i][j] != 0;
                }
                if (fin) {
                    break;
                }
                boolean flag = true;
                while (flag) {
                    flag = false;
                    for (int x = 0; x < n; x++) {
                        if (res[i][x] == 0 && sets[x].size() == 1) {
                            res[i][x] = sets[x].iterator().next();
                            for (int j = 0; j < n; j++) {
                                sets[j].remove(res[i][x]);
                            }
                            flag = true;
                        }
                    }
                }
                int[] count = new int[n];
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    for (int s : sets[j]) {
                        count[s-1]++;
                    }
                }
                Set<Integer> used = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (res[i][j] != 0)
                        used.add(res[i][j]);
                }
                int v = -1;
                for (int j = 0; j < n; j++) {
                    if (used.contains(j + 1)) {
                        continue;
                    }
                    if (v == -1 || count[j] < count[v]) v = j;
                }
                for (int x = 0; x < n; x++) {
                    if (res[i][x] == 0 && sets[x].contains(v + 1)) {
                        res[i][x] = v + 1;
                        for (int j = 0; j < n; j++) {
                            sets[j].remove(res[i][x]);
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }

    private int[] find(int n, int k) {
        if (k == n + 1 || k == n * n - 1) {
            return null;
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        if (n == k) {
            return res;
        }
        res[0]++;
        res[1]++;
        int now = n + 2;
        while (now < k) {
            now++;
            for (int i = 0; i < n; i++) {
                if (res[i] != n) {
                    res[i]++;
                    break;
                }
            }
        }
        return res;
    }

    private String toAnswer(int[][] a) {
        String[] res = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = Arrays.stream(a[i])
                    .mapToObj(x -> x + "")
                    .collect(Collectors.joining(" "));
        }
        return String.join("\n", res);
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
