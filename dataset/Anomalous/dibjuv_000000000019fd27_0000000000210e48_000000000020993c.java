import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate the number of rows with duplicate values
            int duplicateRows = 0;
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowValues.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Calculate the number of columns with duplicate values
            int duplicateColumns = 0;
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> columnValues = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!columnValues.add(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}