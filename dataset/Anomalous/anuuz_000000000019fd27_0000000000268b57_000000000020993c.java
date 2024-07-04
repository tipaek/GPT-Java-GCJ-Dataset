import java.util.Scanner;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][][] matrices = new int[testCases][][];

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            matrices[t] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrices[t][i][j] = scanner.nextInt();
                }
            }
        }

        for (int t = 0; t < testCases; t++) {
            System.out.print("Case #" + (t + 1) + ":");

            int trace = calculateTrace(matrices[t]);
            System.out.print(" " + trace);

            int duplicateRows = countDuplicateRows(matrices[t]);
            System.out.print(" " + duplicateRows);

            int[][] transposedMatrix = transposeMatrix(matrices[t]);
            int duplicateCols = countDuplicateRows(transposedMatrix);
            System.out.println(" " + duplicateCols);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] transposedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = 0; j < row.length - 1; j++) {
                if (row[j] == row[j + 1]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}