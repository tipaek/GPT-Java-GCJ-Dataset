import java.util.Scanner;
import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][][] matrices = new int[t][][];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            matrices[k] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrices[k][i][j] = sc.nextInt();
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int trace = calculateTrace(matrices[i]);
            int rowDuplicates = countDuplicateRows(matrices[i]);
            int colDuplicates = countDuplicateRows(transposeMatrix(matrices[i]));

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowDuplicates, colDuplicates);
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
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        Arrays.sort(array);
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] == array[j + 1]) {
                return true;
            }
        }
        return false;
    }
}