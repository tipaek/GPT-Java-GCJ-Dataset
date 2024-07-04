import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void calculateTraceAndDuplicates(int caseNumber, int matrixSize, int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        // Calculate the trace of the matrix
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate elements in each row
        for (int i = 0; i < matrixSize; i++) {
            int[] rowCheck = new int[101];
            for (int j = 0; j < matrixSize; j++) {
                rowCheck[matrix[i][j]]++;
                if (rowCheck[matrix[i][j]] > 1) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Check for duplicate elements in each column
        for (int i = 0; i < matrixSize; i++) {
            int[] columnCheck = new int[101];
            for (int j = 0; j < matrixSize; j++) {
                columnCheck[matrix[j][i]]++;
                if (columnCheck[matrix[j][i]] > 1) {
                    duplicateColumns++;
                    break;
                }
            }
        }

        // Print the result for the current case
        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            calculateTraceAndDuplicates(caseNumber, matrixSize, matrix);
        }

        scanner.close();
    }
}