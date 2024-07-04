import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixAnalysis {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(args[0]);
        Scanner scanner = new Scanner(inputFile);

        int numCases = scanner.nextInt();
        
        for (int i = 1; i <= numCases; i++) {
            int n = scanner.nextInt();
            int[][] numMatrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    numMatrix[row][col] = scanner.nextInt();
                }
            }

            int k = calculateTrace(numMatrix, n);
            int r = countDuplicateRows(numMatrix, n);
            int c = countDuplicateColumns(numMatrix, n);

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}