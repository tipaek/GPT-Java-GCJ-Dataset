import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = in.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }

            // Calculate horizontal duplicates
            int hdup = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    rowSet.add(arr[row][col]);
                }
                if (rowSet.size() != n) {
                    hdup++;
                }
            }

            // Calculate vertical duplicates
            int vdup = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    colSet.add(arr[row][col]);
                }
                if (colSet.size() != n) {
                    vdup++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + i + ": " + trace + " " + hdup + " " + vdup);
        }
    }
}