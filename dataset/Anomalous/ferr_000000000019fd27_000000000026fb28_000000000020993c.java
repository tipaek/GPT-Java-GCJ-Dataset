import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private boolean isValidSequence(int[] array) {
        if (array[0] != 1 || array[array.length - 1] != array.length) {
            return false;
        }
        for (int i = 0; i + 1 < array.length; ++i) {
            if (array[i] + 1 != array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private String processTestCase() {
        int n = nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = nextInt();
            }
        }

        int trace = 0;
        int rowInvalidCount = 0, columnInvalidCount = 0;

        for (int i = 0; i < n; ++i) {
            int[] row = new int[n];
            int[] column = new int[n];

            for (int j = 0; j < n; ++j) {
                row[j] = matrix[i][j];
                column[j] = matrix[j][i];
            }

            Arrays.sort(row);
            Arrays.sort(column);

            if (!isValidSequence(row)) {
                rowInvalidCount++;
            }
            if (!isValidSequence(column)) {
                columnInvalidCount++;
            }

            trace += matrix[i][i];
        }

        return String.format("%d %d %d", trace, columnInvalidCount, rowInvalidCount);
    }

    private void solve() {
        int testCases = nextInt();

        for (int i = 0; i < testCases; ++i) {
            String result = processTestCase();
            pw.printf("Case #%d: %s\n", i + 1, result);
        }
    }

    private static final String FILE_NAME = "A";
    private static final boolean FROM_CONSOLE = true;

    @Override
    public void run() {
        try {
            if (!FROM_CONSOLE) {
                in = new BufferedReader(new FileReader(FILE_NAME + ".in"));
                pw = new PrintWriter(FILE_NAME + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }

            st = new StringTokenizer("");
            long startTime = System.currentTimeMillis();
            solve();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    private boolean hasNextToken() {
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

    private String nextToken() {
        return hasNextToken() ? st.nextToken() : null;
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