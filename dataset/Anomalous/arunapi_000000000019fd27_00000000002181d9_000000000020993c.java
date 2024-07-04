import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt(); // Number of test cases

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt(); // Size of the Latin square
            int[][] latinSquare = new int[n][n];
            boolean[] hasRepeatedCols = new boolean[n];
            boolean[] hasRepeatedRows = new boolean[n];
            int trace = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int element = scanner.nextInt();
                    latinSquare[row][col] = element;

                    if (row == col) {
                        trace += element;
                    }

                    // Check for duplicates in columns
                    if (!hasRepeatedCols[col]) {
                        for (int r = 0; r < row; r++) {
                            if (latinSquare[r][col] == element) {
                                hasRepeatedCols[col] = true;
                                break;
                            }
                        }
                    }

                    // Check for duplicates in rows
                    if (!hasRepeatedRows[row]) {
                        for (int c = 0; c < col; c++) {
                            if (latinSquare[row][c] == element) {
                                hasRepeatedRows[row] = true;
                                break;
                            }
                        }
                    }
                }
            }

            int repeatedColsCount = 0;
            for (boolean repeated : hasRepeatedCols) {
                if (repeated) {
                    repeatedColsCount++;
                }
            }

            int repeatedRowsCount = 0;
            for (boolean repeated : hasRepeatedRows) {
                if (repeated) {
                    repeatedRowsCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRowsCount + " " + repeatedColsCount);
        }
    }
}