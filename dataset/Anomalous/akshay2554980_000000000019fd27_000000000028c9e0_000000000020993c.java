import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int j = 0; j < t; ++j) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; ++i) {
                for (int k = 0; k < n; ++k) {
                    arr[i][k] = sc.nextInt();
                    if (i == k) {
                        trace += arr[i][k];
                    }
                }
            }

            // Calculate number of rows with repeated elements
            int rowCount = 0;
            for (int i = 0; i < n; ++i) {
                if (hasDuplicates(arr[i])) {
                    rowCount++;
                }
            }

            // Calculate number of columns with repeated elements
            int colCount = 0;
            for (int i = 0; i < n; ++i) {
                if (hasDuplicates(getColumn(arr, i))) {
                    colCount++;
                }
            }

            System.out.println("Case #" + (j + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    // Helper method to check if an array has duplicates
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to get a column from a 2D array
    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}