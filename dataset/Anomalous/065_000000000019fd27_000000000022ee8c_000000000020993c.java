import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in each row
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (rowMap.containsKey(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    } else {
                        rowMap.put(matrix[i][j], 1);
                    }
                }
            }

            // Check for duplicate values in each column
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (colMap.containsKey(matrix[j][i])) {
                        duplicateCols++;
                        break;
                    } else {
                        colMap.put(matrix[j][i], 1);
                    }
                }
            }

            // Print the results for the current case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
            caseNumber++;
        }

        sc.close();
    }
}