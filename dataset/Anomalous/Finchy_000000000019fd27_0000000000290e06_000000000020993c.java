import java.util.*;
import java.io.*;

class Vestigium {

    static boolean hasDuplicatesWithinK(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);

            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }
        return false;
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transposed = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static void main(String[] args) {
        boolean debug = false;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
                if (hasDuplicatesWithinK(matrix[j], n)) {
                    rowDuplicates++;
                }
            }

            int[][] transposedMatrix = transposeMatrix(matrix);
            for (int j = 0; j < n; j++) {
                if (hasDuplicatesWithinK(transposedMatrix[j], n)) {
                    columnDuplicates++;
                }
            }

            if (debug) {
                System.out.println(Arrays.deepToString(matrix));
                System.out.println(Arrays.deepToString(transposedMatrix));
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}