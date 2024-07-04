import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        if (t >= 1 && t <= 100) {
            for (int x = 0; x < t; x++) {
                int n = scanner.nextInt();
                if (n >= 2 && n <= 50) {
                    int[][] matrix = new int[n][n];
                    initializeMatrix(matrix, n);

                    int k = scanner.nextInt();
                    if (k >= n && k <= n * n) {
                        processMatrix(matrix, x + 1, k);
                    }
                }
            }
        }
    }

    private static void initializeMatrix(int[][] matrix, int n) {
        for (int j = 0; j < n; j++) {
            int value = j + 1;
            for (int i = 0; i < n; i++) {
                matrix[i][j] = value % n + 1;
                if (value == n) {
                    value = 0;
                }
                value++;
            }
        }
    }

    private static void processMatrix(int[][] matrix, int caseNumber, int targetTrace) {
        boolean isPossible = false;
        int swapCounter = 0;

        while (swapCounter < matrix.length) {
            int currentTrace = calculateTrace(matrix);

            if (currentTrace == targetTrace) {
                isPossible = true;
                break;
            } else {
                if (matrix.length > 2) {
                    performSwaps(matrix);
                }
                swapCounter++;
            }
        }

        printResult(caseNumber, isPossible, matrix);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void performSwaps(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][0];
            matrix[i][0] = matrix[i][i + 1];
            matrix[i][i + 1] = temp;
        }
    }

    private static void printResult(int caseNumber, boolean isPossible, int[][] matrix) {
        if (isPossible) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            for (int[] row : matrix) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}