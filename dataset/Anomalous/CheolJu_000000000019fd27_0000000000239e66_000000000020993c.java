import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTests = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // Move to the next line

            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
                scanner.nextLine(); // Move to the next line
            }

            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateColumns = countDuplicateColumns(matrix, matrixSize);

            // Output the result for the current test case
            System.out.println("Case #" + (testIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;

        for (int row = 0; row < size; row++) {
            int[] checkerArray = new int[size + 1];
            for (int col = 0; col < size; col++) {
                if (checkerArray[matrix[row][col]] != 0) {
                    duplicateRows++;
                    break;
                } else {
                    checkerArray[matrix[row][col]]++;
                }
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;

        for (int col = 0; col < size; col++) {
            int[] checkerArray = new int[size + 1];
            for (int row = 0; row < size; row++) {
                if (checkerArray[matrix[row][col]] != 0) {
                    duplicateColumns++;
                    break;
                } else {
                    checkerArray[matrix[row][col]]++;
                }
            }
        }

        return duplicateColumns;
    }
}