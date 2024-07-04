import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        int[][] mat = new int[100][100]; // Matrix to store input values

        for (int caseNum = 1; caseNum <= t; ++caseNum) {
            int n = in.nextInt(); // Size of the matrix
            int trace = 0; // Sum of diagonal elements
            int duplicateRows = 0; // Count of rows with duplicates
            int duplicateCols = 0; // Count of columns with duplicates

            // Read matrix and calculate trace
            for (int i = 0; i < n; ++i) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = in.nextInt();
                    if (i == j) {
                        trace += mat[i][j];
                    }
                    if (!rowSet.add(mat[i][j])) {
                        rowHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < n; ++j) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; ++i) {
                    if (!colSet.add(mat[i][j])) {
                        colHasDuplicate = true;
                    }
                }
                if (colHasDuplicate) {
                    duplicateCols++;
                }
            }

            // Output the result for this test case
            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}