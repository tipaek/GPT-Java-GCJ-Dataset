import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    boolean check(int[] a) {
        if (a[0] != 1 || a[a.length - 1] != a.length)
            return false;
        for (int i = 0; i + 1 < a.length; ++i)
            if (a[i] + 1 != a[i + 1])
                return false;
        return true;
    }


    public String solveCase() {
        int n = nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = nextInt();
            }
        }
        int trace = 0;
        int cCount = 0, rCount = 0;
        for (int i = 0; i < n; ++i) {
            int[] row = new int[n];
            int[] col = new int[n];
            for (int j = 0; j < n; ++j) {
                row[j] = a[j][i];
                col[j] = a[i][j];
            }
            Arrays.sort(row);
            Arrays.sort(col);
            if (!check(row))
                rCount++;
            if (!check(col))
                cCount++;
            trace += a[i][i];
        }
        return String.format("%d %d %d", trace, cCount, rCount);
    }

    public void solve() {
        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            String ans = solveCase();
            pw.printf("Case #%d: %s\n", i + 1, ans);
        }
    }

    static final String filename = "A";
    static final boolean fromConsole = true;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader(filename + ".in"));
                pw = new PrintWriter(filename + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            long st = System.currentTimeMillis();
            solve();
            //pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - st);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return st.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String next() {
        return hasNext() ? st.nextToken() : null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();        
    }
}