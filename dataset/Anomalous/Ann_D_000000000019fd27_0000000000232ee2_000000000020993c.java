import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            // Reading the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }

            // Counting rows with duplicate values
            int duplicateRows = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    rowSet.add(arr[j][k]);
                }
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
            }

            // Counting columns with duplicate values
            int duplicateColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    colSet.add(arr[k][j]);
                }
                if (colSet.size() != n) {
                    duplicateColumns++;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        sc.close();
    }
}