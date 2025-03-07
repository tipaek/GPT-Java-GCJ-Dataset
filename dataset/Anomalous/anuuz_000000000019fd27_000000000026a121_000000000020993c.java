import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][][] matrices = new int[t][][];

        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            matrices[k] = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrices[k][i][j] = scanner.nextInt();
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int trace = 0;
            for (int j = 0; j < matrices[i].length; j++) {
                trace += matrices[i][j][j];
            }

            System.out.print("Case #" + (i + 1) + ": " + trace);

            int[][] transposedMatrix = transposeMatrix(matrices[i]);

            System.out.print(" " + countDuplicateRows(matrices[i]));
            System.out.println(" " + countDuplicateRows(transposedMatrix));
        }

        scanner.close();
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
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