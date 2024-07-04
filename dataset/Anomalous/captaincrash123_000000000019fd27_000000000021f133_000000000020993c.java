import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(new File("output.out"));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRowsCount = 0;
            int duplicateColumnsCount = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n];
                boolean[] colCheck = new boolean[n];
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (!rowDuplicate) {
                        if (rowCheck[matrix[i][j] - 1]) {
                            rowDuplicate = true;
                            duplicateRowsCount++;
                        } else {
                            rowCheck[matrix[i][j] - 1] = true;
                        }
                    }

                    if (!colDuplicate) {
                        if (colCheck[matrix[j][i] - 1]) {
                            colDuplicate = true;
                            duplicateColumnsCount++;
                        } else {
                            colCheck[matrix[j][i] - 1] = true;
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRowsCount, duplicateColumnsCount);
        }

        scanner.close();
        writer.close();
    }
}