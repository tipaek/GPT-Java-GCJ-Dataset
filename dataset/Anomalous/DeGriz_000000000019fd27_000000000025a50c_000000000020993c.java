import java.io.*;
import java.util.*;

public class Solution extends Thread {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer st;

    public static void main(String[] args) {
        new Solution().start();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private void solve() throws IOException {
        int numberOfTests = nextInt();

        for (int testNumber = 0; testNumber < numberOfTests; testNumber++) {
            processTestCase(testNumber);
        }
    }

    private void processTestCase(int testNumber) throws IOException {
        int squareSize = nextInt();
        int sum = 0;
        boolean[] rowsWithDups = new boolean[squareSize];
        boolean[] columnsWithDups = new boolean[squareSize];
        boolean[][] rowDups = new boolean[squareSize][squareSize];
        boolean[][] columnDups = new boolean[squareSize][squareSize];

        for (int row = 0; row < squareSize; row++) {
            for (int column = 0; column < squareSize; column++) {
                int value = nextInt();
                checkAndSetDuplicates(rowDups, rowsWithDups, row, value);
                checkAndSetDuplicates(columnDups, columnsWithDups, column, value);

                if (row == column) {
                    sum += value;
                }
            }
        }

        out.println(String.format("Case #%d: %d %d %d", testNumber + 1, sum, countDuplicates(rowsWithDups), countDuplicates(columnsWithDups)));
    }

    private void checkAndSetDuplicates(boolean[][] dupsMatrix, boolean[] dupsLine, int index, int value) {
        if (dupsMatrix[index][value - 1]) {
            dupsLine[index] = true;
        }
        dupsMatrix[index][value - 1] = true;
    }

    private int countDuplicates(boolean[] array) {
        int count = 0;
        for (boolean hasDup : array) {
            if (hasDup) {
                count++;
            }
        }
        return count;
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}