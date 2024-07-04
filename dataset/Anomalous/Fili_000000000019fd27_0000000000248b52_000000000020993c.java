import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate values in rows
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowValues = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowValues.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> columnValues = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnValues.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}