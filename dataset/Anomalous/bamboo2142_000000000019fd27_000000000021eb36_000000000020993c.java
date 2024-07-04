import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix input
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace of the matrix
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Count rows with duplicate elements
            int duplicateRows = 0;
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Count columns with duplicate elements
            int duplicateColumns = 0;
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}