import java.util.Scanner;

public class Solution {
    private static boolean isPossible = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int cs = 1; cs <= testCases; cs++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[][] matrix = new int[n][n];
            int currentVal = n;
            int[] chosen = new int[n];

            for (int i = 0; i < n; i++) {
                while (k - currentVal < n - i - 1) {
                    currentVal--;
                }
                k -= currentVal;
                matrix[i][i] = currentVal;
                chosen[i] = currentVal;
            }

            for (int j = 0; j < n; j++) {
                int val = n;
                if (val == chosen[j]) {
                    val--;
                }
                for (int i = 0; i < n; i++) {
                    if (i == j) {
                        if (val == chosen[j]) {
                            val--;
                        }
                        continue;
                    }
                    matrix[i][j] = val;
                    val--;
                }
                for (int i = n - 1; i >= 0; i--) {
                    int direction = (i != 0) ? -1 : 1;
                    int switchIndex = (i != 0) ? i - 1 : 1;
                    checkAndSwitch(j, i, matrix, switchIndex, direction);
                }
            }

            String result = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + cs + ": " + result);
            if (isPossible) {
                printMatrix(matrix);
            }
        }
    }

    private static void checkAndSwitch(int j, int i, int[][] matrix, int switchIndex, int direction) {
        if (i == j || (i == 1 && j == 0)) {
            return;
        }
        if (switchIndex == matrix.length) {
            isPossible = isMatrixValid(matrix);
            return;
        }
        if (switchIndex == j) {
            checkAndSwitch(j, i, matrix, switchIndex + direction, direction);
            return;
        }
        boolean duplicateExists = false;
        for (int l = 0; l < matrix.length; l++) {
            if (l == j) {
                continue;
            }
            if (matrix[i][l] == matrix[i][j]) {
                duplicateExists = true;
                break;
            }
        }
        if (duplicateExists) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[switchIndex][j];
            matrix[switchIndex][j] = temp;
            if (switchIndex > 0) {
                checkAndSwitch(j, i, matrix, switchIndex + direction, direction);
            }
        }
    }

    private static boolean isMatrixValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (!isRowValid(matrix, i) || !isColumnValid(matrix, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRowValid(int[][] matrix, int row) {
        int n = matrix.length;
        boolean[] found = new boolean[n];
        for (int j = 0; j < n; j++) {
            if (found[matrix[row][j] - 1]) {
                return false;
            }
            found[matrix[row][j] - 1] = true;
        }
        return true;
    }

    private static boolean isColumnValid(int[][] matrix, int column) {
        int n = matrix.length;
        boolean[] found = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (found[matrix[i][column] - 1]) {
                return false;
            }
            found[matrix[i][column] - 1] = true;
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}