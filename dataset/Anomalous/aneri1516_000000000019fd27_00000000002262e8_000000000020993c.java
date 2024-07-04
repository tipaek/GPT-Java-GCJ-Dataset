import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[n][n];

            // Read matrix and calculate trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int k = 0; k < n; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Output the result
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}