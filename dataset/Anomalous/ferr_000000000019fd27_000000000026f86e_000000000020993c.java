import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Main implements Runnable {

    private boolean isValidSequence(int[] array) {
        if (array[0] != 1 || array[array.length - 1] != array.length) {
            return false;
        }
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] + 1 != array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public String solveTestCase() {
        int n = nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = nextInt();
            }
        }

        int trace = 0;
        int rowCount = 0, colCount = 0;
        for (int i = 0; i < n; ++i) {
            int[] row = new int[n];
            int[] col = new int[n];
            for (int j = 0; j < n; ++j) {
                row[j] = matrix[i][j];
                col[j] = matrix[j][i];
            }
            Arrays.sort(row);
            Arrays.sort(col);
            if (!isValidSequence(row)) {
                rowCount++;
            }
            if (!isValidSequence(col)) {
                colCount++;
            }
            trace += matrix[i][i];
        }
        return String.format("%d %d %d", trace, rowCount, colCount);
    }

    public void solve() {
        int testCases = nextInt();
        for (int i = 0; i < testCases; ++i) {
            String result = solveTestCase();
            pw.printf("Case #%d: %s\n", i + 1, result);
        }
    }

    private static final String FILENAME = "A";
    private static final boolean FROM_CONSOLE = true;

    public void run() {
        try {
            if (!FROM_CONSOLE) {
                in = new BufferedReader(new FileReader(FILENAME + ".in"));
                pw = new PrintWriter(FILENAME + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            tokenizer = new StringTokenizer("");
            long startTime = System.currentTimeMillis();
            solve();
            pw.close();
            // pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer tokenizer;
    private BufferedReader in;
    private PrintWriter pw;

    private boolean hasNextToken() {
        try {
            while (!tokenizer.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String next() {
        return hasNextToken() ? tokenizer.nextToken() : null;
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
        new Thread(new Main()).start();
    }
}