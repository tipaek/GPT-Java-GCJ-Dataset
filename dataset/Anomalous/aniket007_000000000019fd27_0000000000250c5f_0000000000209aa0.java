import java.util.Scanner;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];

            initializeMatrix(matrix);
            boolean possible = arrange(matrix, k);

            System.out.println("Case #" + testCase + ": " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
        }
    }

    private static void initializeMatrix(int[][] matrix) {
        int value = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = value++;
                if (value > n) {
                    value = 1;
                }
            }
            value--; // Adjust for the next row
        }
    }

    private static boolean check(int[][] matrix, int k) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][n - i - 1];
        }

        return primaryDiagonalSum == k || secondaryDiagonalSum == k;
    }

    private static boolean arrange(int[][] matrix, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }

                // Swap rows
                int[] temp = matrix[i];
                matrix[i] = matrix[j];
                matrix[j] = temp;

                if (check(matrix, k)) {
                    return true;
                }

                // Swap back
                temp = matrix[i];
                matrix[i] = matrix[j];
                matrix[j] = temp;
            }
        }
        return false;
    }
}