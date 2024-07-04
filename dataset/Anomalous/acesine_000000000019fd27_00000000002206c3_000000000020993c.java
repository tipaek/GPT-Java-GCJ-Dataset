import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int[][] columns = new int[matrixSize][matrixSize];
            int[][] rows = new int[matrixSize][matrixSize];
            int repeatedColumns = 0, repeatedRows = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    if (i == j) trace += value;
                    rows[i][value - 1]++;
                    columns[j][value - 1]++;
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                boolean rowHasRepetition = false, columnHasRepetition = false;
                for (int j = 0; j < matrixSize; j++) {
                    if (rows[i][j] > 1) rowHasRepetition = true;
                    if (columns[i][j] > 1) columnHasRepetition = true;
                }
                if (rowHasRepetition) repeatedRows++;
                if (columnHasRepetition) repeatedColumns++;
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, repeatedRows, repeatedColumns);
        }
    }
}