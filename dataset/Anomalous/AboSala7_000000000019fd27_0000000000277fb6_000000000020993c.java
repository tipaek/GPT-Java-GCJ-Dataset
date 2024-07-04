import java.util.HashMap;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate number of rows with repeated elements
            int repeatedRows = 0;
            for (int i = 0; i < matrixSize; i++) {
                HashMap<Integer, Boolean> rowMap = new HashMap<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (rowMap.containsKey(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    } else {
                        rowMap.put(matrix[i][j], true);
                    }
                }
            }

            // Calculate number of columns with repeated elements
            int repeatedColumns = 0;
            for (int i = 0; i < matrixSize; i++) {
                HashMap<Integer, Boolean> colMap = new HashMap<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (colMap.containsKey(matrix[j][i])) {
                        repeatedColumns++;
                        break;
                    } else {
                        colMap.put(matrix[j][i], true);
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + test + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}