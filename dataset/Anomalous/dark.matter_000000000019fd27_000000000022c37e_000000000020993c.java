import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int row = 0; row < n; row++) {
                boolean[] seenInRow = new boolean[n + 1];
                boolean rowHasDuplicate = false;
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                    if (seenInRow[value]) {
                        rowHasDuplicate = true;
                    }
                    seenInRow[value] = true;
                }
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < n; col++) {
                boolean[] seenInCol = new boolean[n + 1];
                boolean colHasDuplicate = false;
                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];
                    if (seenInCol[value]) {
                        colHasDuplicate = true;
                    }
                    seenInCol[value] = true;
                }
                if (colHasDuplicate) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, duplicateRows, duplicateColumns);
        }
    }
}