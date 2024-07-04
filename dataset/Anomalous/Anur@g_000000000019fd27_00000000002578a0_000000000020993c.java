import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int m = 1; m <= T; m++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int[] row = new int[n];
            int[] col = new int[n];
            int trace = 0, dupr = 0, dupc = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows and columns
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    row[j] = matrix[i][j];
                    col[j] = matrix[j][i];
                }
                Arrays.sort(row);
                Arrays.sort(col);
                dupr += hasDuplicates(row);
                dupc += hasDuplicates(col);
            }

            System.out.printf("Case #%d: %d %d %d%n", m, trace, dupr, dupc);
        }
    }

    private static int hasDuplicates(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return 1;
            }
        }
        return 0;
    }
}