import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int caseNum = 1; caseNum <= t; ++caseNum) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt();
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(mat[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(mat[i][j])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        in.close();
    }
}