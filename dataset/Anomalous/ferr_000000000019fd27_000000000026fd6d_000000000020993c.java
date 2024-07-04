import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private boolean isValidSequence(int[] sequence) {
        if (sequence[0] != 1 || sequence[sequence.length - 1] != sequence.length) {
            return false;
        }
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] + 1 != sequence[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private String solveSingleCase() {
        int n = nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nextInt();
            }
        }

        int trace = 0;
        int invalidRowCount = 0;
        int invalidColCount = 0;

        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = matrix[i][j];
                col[j] = matrix[j][i];
            }
            Arrays.sort(row);
            Arrays.sort(col);
            if (!isValidSequence(row)) {
                invalidRowCount++;
            }
            if (!isValidSequence(col)) {
                invalidColCount++;
            }
            trace += matrix[i][i];
        }

        return String.format("%d %d %d", trace, invalidRowCount, invalidColCount);
    }

    private void solve() {
        int testCaseCount = nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            String result = solveSingleCase();
            pw.printf("Case #%d: %s\n", i + 1, result);
        }
    }

    private static final String FILENAME = "A";
    private static final boolean FROM_CONSOLE = true;

    @Override
    public void run() {
        try {
            if (!FROM_CONSOLE) {
                in = new BufferedReader(new FileReader(FILENAME + ".in"));
                pw = new PrintWriter(new FileWriter(FILENAME + ".out"));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            solve();
            pw.close();
        } catch (IOException e) {
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