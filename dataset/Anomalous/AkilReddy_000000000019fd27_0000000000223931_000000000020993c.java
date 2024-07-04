import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Check for duplicate values in rows
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!set.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            int duplicateColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!set.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Calculate the trace (sum of diagonal elements)
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Output the results
            System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}