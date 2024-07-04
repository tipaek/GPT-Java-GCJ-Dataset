import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.io.FileInputStream;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/N3";

    FastScanner in;
    PrintWriter out;

    class Edge {
        final int id;
        final int to;

        public Edge(int id, int to) {
            this.id = id;
            this.to = to;
        }
    }

    public void solve() {
        int T = in.nextInt();
        for (int _times = 1; _times <= T; _times++) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[] rec = new int[n];
            int[] c = in.nextIntArray(n - 1);
            for (int i = 0; i < n - 1; i++) {
                if (c[i] < 0) {
                    rec[i+1] = -c[i];
                }
            }
            List<Edge>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                g[u].add(new Edge(i, v));
                g[v].add(new Edge(i, u));
            }


            Queue<Integer> q = new ArrayDeque<>();
            q.add(0);
            boolean[] vis = new boolean[n];
            int[] w = new int[m];
            vis[0] = true;
            Arrays.fill(w, -1);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (Edge e : g[u]) {
                    if (!vis[e.to] && rec[e.to] == rec[u] + 1) {
                        w[e.id] = 1;
                        vis[e.to] = true;
                        q.add(e.to);
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if (w[i] == -1) {
                    res.append(999999);
                } else {
                    res.append(w[i]);
                }
                if (i != m - 1) {
                    res.append(" ");
                }
            }
            System.out.println(GcjUtil.format(_times + 1, res.toString()));
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
