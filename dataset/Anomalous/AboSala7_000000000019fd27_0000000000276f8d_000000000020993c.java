import java.util.Scanner;
import java.util.HashSet;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            // Calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Check for repeated elements in rows
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Check for repeated elements in columns
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        repeatedColumns++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}