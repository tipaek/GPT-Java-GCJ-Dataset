import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numMatrices = scanner.nextInt();

        for (int i = 0; i < numMatrices; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Counting repeated rows
            int rowCount = 0;
            for (int row = 0; row < n; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Counting repeated columns
            int colCount = 0;
            for (int col = 0; col < n; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colCount++;
                        break;
                    }
                }
            }

            // Printing the result for the current matrix
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}