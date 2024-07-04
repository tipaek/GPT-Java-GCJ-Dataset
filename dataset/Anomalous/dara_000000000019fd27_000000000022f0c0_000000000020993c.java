import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = reader.nextInt(); // Number of test cases
        reader.nextLine();
        String[] results = new String[t];

        for (int p = 0; p < t; p++) {
            int n = reader.nextInt(); // Size of the matrix
            reader.nextLine();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                String[] line = reader.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Calculate trace and check for repeated rows and columns
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];

                if (hasDuplicates(matrix[i])) {
                    repeatedRows++;
                }

                if (hasDuplicates(getColumn(matrix, i))) {
                    repeatedCols++;
                }
            }

            results[p] = "Case #" + (p + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}