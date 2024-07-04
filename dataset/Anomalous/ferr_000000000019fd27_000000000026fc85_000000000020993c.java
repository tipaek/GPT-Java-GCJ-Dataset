import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private boolean isSequentialArray(int[] array) {
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

    private String processCase() {
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
            if (!isSequentialArray(row)) {
                rowCount++;
            }
            if (!isSequentialArray(col)) {
                colCount++;
            }
            trace += matrix[i][i];
        }
        return String.format("%d %d %d", trace, rowCount, colCount);
    }

    private void solve() {
        int testCases = nextInt();
        for (int i = 0; i < testCases; ++i) {
            String result = processCase();
            output.printf("Case #%d: %s\n", i + 1, result);
        }
    }

    private static final String FILE_NAME = "A";
    private static final boolean FROM_CONSOLE = true;

    public void run() {
        try {
            if (!FROM_CONSOLE) {
                input = new BufferedReader(new FileReader(FILE_NAME + ".in"));
                output = new PrintWriter(FILE_NAME + ".out");
            } else {
                input = new BufferedReader(new InputStreamReader(System.in));
                output = new PrintWriter(System.out);
            }
            tokenizer = new StringTokenizer("");
            solve();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer tokenizer;
    private BufferedReader input;
    private PrintWriter output;

    private boolean hasNextToken() {
        try {
            while (!tokenizer.hasMoreTokens()) {
                String line = input.readLine();
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

    private String nextToken() {
        return hasNextToken() ? tokenizer.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}