import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            int[][] matrix = new int[n][n];
            int[][] transposedMatrix = new int[n][n];

            // Read the matrix and compute the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        trace += value;
                    }
                    matrix[row][col] = value;
                    transposedMatrix[col][row] = value;
                }
            }

            // Check for duplicate values in each row
            for (int row = 0; row < n; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in each column
            for (int col = 0; col < n; col++) {
                if (hasDuplicates(transposedMatrix[col])) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}