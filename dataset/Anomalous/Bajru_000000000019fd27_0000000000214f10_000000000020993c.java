import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            int[][] mat = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = scan.nextInt();
                }
            }
            solve(mat, n, i);
        }
    }

    private static void solve(int[][] mat, int n, int caseNumber) {
        int trace = 0;

        // Calculate the trace of the matrix
        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        int expectedSum = n * (n + 1) / 2;
        int rowRepeats = 0, colRepeats = 0;

        // Check for duplicate elements in rows and columns
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(mat[i][j]);
                colSet.add(mat[j][i]);
            }
            if (rowSet.size() != n) {
                rowRepeats++;
            }
            if (colSet.size() != n) {
                colRepeats++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}