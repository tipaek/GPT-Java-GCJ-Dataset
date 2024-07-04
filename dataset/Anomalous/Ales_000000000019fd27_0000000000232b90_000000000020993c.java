import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculating the trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Checking for duplicate values in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowFlag = false, colFlag = false;

                for (int j = 0; j < matrixSize; j++) {
                    // Check row duplicates
                    if (rowSet.contains(matrix[i][j])) {
                        rowDuplicates++;
                        rowFlag = true;
                    } else {
                        rowSet.add(matrix[i][j]);
                    }

                    // Check column duplicates
                    if (colSet.contains(matrix[j][i])) {
                        colDuplicates++;
                        colFlag = true;
                    } else {
                        colSet.add(matrix[j][i]);
                    }

                    // If duplicates are found, no need to check further in the current row/column
                    if (rowFlag && colFlag) {
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}