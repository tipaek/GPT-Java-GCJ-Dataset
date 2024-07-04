import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int i1 = 1; i1 <= t; ++i1) {
            int n = in.nextInt(); // Size of the matrix
            int[][] mat = new int[n][n];
            int sum = 0, r = 0, c = 0;

            // Reading the matrix and calculating the sum of the diagonal
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt();
                    if (i == j) {
                        sum += mat[i][j];
                    }
                }
            }

            // Checking for duplicate rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(mat[i][j])) {
                        r++;
                        break;
                    }
                }
            }

            // Checking for duplicate columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(mat[i][j])) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i1 + ": " + sum + " " + r + " " + c);
        }
    }
}