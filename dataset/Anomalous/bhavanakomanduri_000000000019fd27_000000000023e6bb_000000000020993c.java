import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] traceSums = new int[N];
        int[] rowDuplicates = new int[N];
        int[] columnDuplicates = new int[N];

        for (int l = 0; l < N; l++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                traceSums[l] += matrix[i][i];
            }

            // Check for row duplicates
            rowDuplicates[l] = countRowDuplicates(matrix, n);

            // Check for column duplicates
            columnDuplicates[l] = countColumnDuplicates(matrix, n);
        }

        // Output results
        for (int a = 0; a < N; a++) {
            System.out.println("Case #" + (a + 1) + ": " + traceSums[a] + " " + rowDuplicates[a] + " " + columnDuplicates[a]);
        }
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int duplicateCount = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    duplicateCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix, int n) {
        int duplicateCount = 0;
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (seen[matrix[i][j]]) {
                    duplicateCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicateCount;
    }
}