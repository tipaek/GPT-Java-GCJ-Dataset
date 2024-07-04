import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            System.out.print("Case #" + testCase + ": ");
            findTrace(n, k);
        }
    }

    private static void findTrace(int n, int k) {
        int[] trace = new int[n];
        Arrays.fill(trace, 0);
        if (!calculateNextValues(trace, 0, k, 0, 0)) {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean calculateNextValues(int[] trace, int index, int k, int sum, int usedValues) {
        if (index >= trace.length || usedValues >= trace.length || sum >= k) {
            if (sum == k && usedValues == trace.length) {
                return calculateSudoku(trace.clone());
            }
            return false;
        }

        trace[index] = 0;
        int remainingValues = trace.length - usedValues;
        for (int i = 0; i <= remainingValues; i++) {
            int currentValue = i * (index + 1) + sum;
            if (currentValue + (remainingValues - i) * (index + 1) <= k && currentValue + (remainingValues - i) * trace.length >= k) {
                trace[index] = i;
                if (calculateNextValues(trace, index + 1, k, currentValue, usedValues + i)) {
                    return true;
                }
            }
        }
        trace[index] = 0;
        return false;
    }

    private static boolean calculateSudoku(int[] trace) {
        int n = trace.length;
        int[][] matrix = new int[n][n];
        int traceIndex = 0;

        for (int i = 0; i < n; i++) {
            while (trace[traceIndex] == 0) {
                traceIndex++;
            }
            matrix[i][i] = traceIndex + 1;
            trace[traceIndex]--;
        }

        boolean feasible = solveSudoku(matrix, n);
        if (feasible) {
            System.out.println("POSSIBLE");
            printMatrix(matrix);
        }
        return feasible;
    }

    private static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}