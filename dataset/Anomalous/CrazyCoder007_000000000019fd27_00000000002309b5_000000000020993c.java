public class Solution {
    public static void Calculate(int t, int n, int[][] arr) {
        int trace = 0;
        int dupRows = 0;
        int dupCols = 0;
        int caseCount = 1;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += arr[i][i];
        }

        // Check for duplicate rows
        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (rowCheck[arr[i][j]]) {
                    dupRows++;
                    break;
                }
                rowCheck[arr[i][j]] = true;
            }
        }

        // Check for duplicate columns
        for (int j = 0; j < n; j++) {
            boolean[] colCheck = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (colCheck[arr[i][j]]) {
                    dupCols++;
                    break;
                }
                colCheck[arr[i][j]] = true;
            }
        }

        // Print the result
        System.out.println("Case #" + caseCount + ": " + trace + " " + dupRows + " " + dupCols);
    }

    public static void main(String[] args) {
        int t = 1; // Number of test cases
        int n = 3; // Size of the matrix
        int[][] arr = {
            {1, 2, 3},
            {4, 1, 6},
            {7, 8, 9}
        };

        Calculate(t, n, arr);
    }
}