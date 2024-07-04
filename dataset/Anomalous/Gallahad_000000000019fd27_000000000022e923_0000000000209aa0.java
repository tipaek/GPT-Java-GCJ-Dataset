import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int it = 1; it <= t; it++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            if (solve(matrix, n, k)) {
                System.out.println("Case #" + it + ": POSSIBLE");
                printMatrix(matrix, n);
            } else {
                System.out.println("Case #" + it + ": IMPOSSIBLE");
            }
        }
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] matrix, int n, int k) {
        int diagonalSum = 0;
        boolean incompleteDiagonal = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][i] == 0) {
                incompleteDiagonal = true;
                break;
            } else {
                diagonalSum += matrix[i][i];
            }
        }

        if (!incompleteDiagonal && diagonalSum != k) {
            return false;
        }

        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
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
            if (isSafe(matrix, row, col, num)) {
                matrix[row][col] = num;
                if (solve(matrix, n, k)) {
                    return true;
                } else {
                    matrix[row][col] = 0;
                }
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] matrix, int row, int col, int num) {
        for (int d = 0; d < matrix.length; d++) {
            if (matrix[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][col] == num) {
                return false;
            }
        }

        return true;
    }
}