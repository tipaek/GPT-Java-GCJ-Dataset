import java.util.*;
import java.io.*;

public class Vestigium {

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
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (hasDuplicatesWithinK(matrix[i], n)) {
                    rowDuplicates++;
                }
            }

            int[][] transposedMatrix = transposeMatrix(matrix);
            for (int i = 0; i < n; i++) {
                if (hasDuplicatesWithinK(transposedMatrix[i], n)) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}