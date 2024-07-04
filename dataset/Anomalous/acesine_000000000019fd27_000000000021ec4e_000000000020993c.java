import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Solution().solve();
    }

    void solve() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int[][] columnTracker = new int[matrixSize][matrixSize];
            int[][] rowTracker = new int[matrixSize][matrixSize];
            int repeatedColumns = 0, repeatedRows = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    if (rowTracker[i][value - 1] == 1) {
                        repeatedRows++;
                    }
                    rowTracker[i][value - 1]++;
                    if (columnTracker[j][value - 1] == 1) {
                        repeatedColumns++;
                    }
                    columnTracker[j][value - 1]++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, repeatedRows, repeatedColumns);
        }
    }
}