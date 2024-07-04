import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int j = 0; j < t; ++j) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; ++i) {
                for (int k = 0; k < n; ++k) {
                    matrix[i][k] = sc.nextInt();
                    if (i == k) {
                        trace += matrix[i][k];
                    }
                }
            }

            int duplicateRows = 0;
            // Check for duplicate elements in rows
            for (int i = 0; i < n; ++i) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;

                for (int k = 0; k < n; ++k) {
                    if (!rowSet.add(matrix[i][k])) {
                        hasDuplicate = true;
                    }
                }

                if (hasDuplicate) {
                    ++duplicateRows;
                }
            }

            int duplicateColumns = 0;
            // Check for duplicate elements in columns
            for (int i = 0; i < n; ++i) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;

                for (int k = 0; k < n; ++k) {
                    if (!colSet.add(matrix[k][i])) {
                        hasDuplicate = true;
                    }
                }

                if (hasDuplicate) {
                    ++duplicateColumns;
                }
            }

            System.out.println("Case #" + (j + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}