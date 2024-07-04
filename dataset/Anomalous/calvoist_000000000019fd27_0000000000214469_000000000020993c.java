import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
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

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Counting rows with repeated elements
            int repeatedRows = 0;
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowElements = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowElements.add(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Counting columns with repeated elements
            int repeatedColumns = 0;
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> columnElements = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnElements.add(matrix[i][j])) {
                        repeatedColumns++;
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}