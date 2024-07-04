import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private void solve() throws Exception {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        // Read the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Calculate the trace
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Calculate the number of rows with duplicates
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Calculate the number of columns with duplicates
        int duplicateCols = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        // Append results to StringBuilder
        sb.append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateCols);
        System.out.print(sb.toString());
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
            System.out.println();
        }
        sc.close();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}