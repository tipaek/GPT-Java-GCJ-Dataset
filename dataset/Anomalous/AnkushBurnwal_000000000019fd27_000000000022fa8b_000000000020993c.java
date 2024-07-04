import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        int count = 1;

        while (count <= noOfTestCases) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculating rows and columns with duplicates
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() < n) {
                    rowsWithDuplicates++;
                }
                if (colSet.size() < n) {
                    colsWithDuplicates++;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + count + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
            count++;
        }

        sc.close();
    }
}