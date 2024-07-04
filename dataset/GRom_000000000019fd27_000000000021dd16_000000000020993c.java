import java.util.*;
import java.io.*;

public class Solution {
    private static final int MAX_SIZE = 100;

    private static final int[][] rows = new int[MAX_SIZE][MAX_SIZE];
    private static final int[][] cols = new int[MAX_SIZE][MAX_SIZE];
    private static final boolean[] duplicatesInRows = new boolean[MAX_SIZE];
    private static final boolean[] duplicatesInCols = new boolean[MAX_SIZE];

    private Scanner scanner;
    private PrintStream printStream;

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }

    Solution() {
        // No-op.
    }

    void execute(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        printStream = out;

        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int caseNo) {
        clearRowsAndColumns();

        int size = scanner.nextInt();

        int trace = 0;
        int numberOfRowsWithDuplicates = 0;
        int numberOfColsWithDuplicates = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int val = scanner.nextInt();

                if (++rows[i][val - 1] > 1) {
                    if (!duplicatesInRows[i]) {
                        numberOfRowsWithDuplicates++;
                    }

                    duplicatesInRows[i] = true;
                }
                if (++cols[j][val - 1] > 1) {
                    if (!duplicatesInCols[j]) {
                        numberOfColsWithDuplicates++;
                    }

                    duplicatesInCols[j] = true;
                }

                if (i == j) {
                    trace += val;
                }
            }
        }

        printStream.println(String.format("Case #%d: %d %d %d",
                caseNo, trace, numberOfRowsWithDuplicates, numberOfColsWithDuplicates));
    }

    private void clearRowsAndColumns() {
        for (int i = 0; i < MAX_SIZE; i++) {
            Arrays.fill(rows[i], 0);
            Arrays.fill(cols[i], 0);
        }

        Arrays.fill(duplicatesInCols, false);
        Arrays.fill(duplicatesInRows, false);
    }
}