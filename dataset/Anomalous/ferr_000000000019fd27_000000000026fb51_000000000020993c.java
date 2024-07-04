import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private boolean isSequential(int[] array) {
        if (array[0] != 1 || array[array.length - 1] != array.length) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 != array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public String solveCase() {
        int n = nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nextInt();
            }
        }
        int trace = 0;
        int rowCount = 0, colCount = 0;
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = matrix[i][j];
                col[j] = matrix[j][i];
            }
            Arrays.sort(row);
            Arrays.sort(col);
            if (!isSequential(row)) {
                rowCount++;
            }
            if (!isSequential(col)) {
                colCount++;
            }
            trace += matrix[i][i];
        }
        return String.format("%d %d %d", trace, rowCount, colCount);
    }

    public void solve() {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            String result = solveCase();
            pw.printf("Case #%d: %s\n", i + 1, result);
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
            long startTime = System.currentTimeMillis();
            solve();
            //pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - startTime);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    private boolean hasNext() {
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

    private String next() {
        return hasNext() ? st.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}