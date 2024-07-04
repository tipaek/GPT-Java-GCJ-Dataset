import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];

            // Reading the matrix
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    mat[j][k] = sc.nextInt();
                }
            }

            System.out.print("Case #" + i + ": ");
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate trace and row duplicates
            for (int j = 0; j < n; ++j) {
                trace += mat[j][j];
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; ++k) {
                    if (!rowSet.add(mat[j][k])) {
                        ++rowDuplicates;
                        break;
                    }
                }
            }

            // Calculate column duplicates
            for (int j = 0; j < n; ++j) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; ++k) {
                    if (!colSet.add(mat[k][j])) {
                        ++colDuplicates;
                        break;
                    }
                }
            }

            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}