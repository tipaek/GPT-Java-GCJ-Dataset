import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            // Append results for the current test case
            result.append("Case #").append(t).append(": ").append(trace).append(" ")
                  .append(rowRepeats).append(" ").append(colRepeats).append("\n");
        }

        // Output the results
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        out.print(result.toString());
        out.close();
        sc.close();
    }
}