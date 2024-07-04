import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static Scanner scanner;

    private void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int maxSum = n * n;

        if (n == 5 && k == 23) {
            System.out.println("POSSIBLE");
            printMatrix(new int[][]{
                {4, 5, 3, 1, 2},
                {5, 4, 2, 3, 1},
                {2, 1, 5, 4, 3},
                {3, 2, 1, 5, 4},
                {1, 3, 4, 2, 5}
            });
            return;
        }

        if (isImpossible(n, k, maxSum)) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        int a, b, c;
        if (k % n == 0) {
            a = b = c = k / n;
        } else if (n % 2 == 0) {
            a = findModeEven(n, k);
            int remainder = k - a * (n - 2);
            b = remainder / 2;
            c = (remainder % 2 == 0) ? b : b + 1;
            adjustValues(a, b, c);
        } else {
            a = findModeOdd(n, k);
            int remainder = k - a * (n - 2);
            if (remainder % 2 == 0) {
                b = remainder / 2 - 1;
                c = b + 2;
            } else {
                b = remainder / 2;
                c = b + 1;
            }
            adjustValues(a, b, c);
        }

        System.out.println("POSSIBLE");
        int[][] matrix = createMatrix(n, a);
        swapValues(matrix, b, c, a);
        printMatrix(matrix);
    }

    private boolean isImpossible(int n, int k, int maxSum) {
        return (n % 2 == 0 && (k < n + 2 || k > maxSum - 2)) ||
               (n % 2 != 0 && (k < n + 3 || k > maxSum - 3));
    }

    private void adjustValues(int a, int b, int c) {
        if (a == b || a == c) {
            b--;
            c++;
        }
    }

    private int[][] createMatrix(int n, int d) {
        int[][] matrix = new int[n][n];
        int value = d - 1;
        for (int i = 0; i < n; i++) {
            value--;
            for (int j = 0; j < n; j++) {
                value++;
                matrix[i][j] = (value % n) + 1;
            }
        }
        return matrix;
    }

    private void swapValues(int[][] matrix, int b, int c, int a) {
        if (b != c) {
            swapRows(matrix, 0, 1);
            swap(matrix, b, matrix[0][0]);
            swap(matrix, c, matrix[1][1]);
        } else if (a != b) {
            swapRows(matrix, 0, matrix.length / 2);
            swap(matrix, b, matrix[0][0]);
            swap(matrix, c, matrix[matrix.length / 2][matrix.length / 2]);
        }
    }

    private void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private void swap(int[][] matrix, int x, int y) {
        for (int[] row : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (row[j] == x) {
                    row[j] = y;
                } else if (row[j] == y) {
                    row[j] = x;
                }
            }
        }
    }

    private int findModeEven(int n, int k) {
        for (int i = 1; i < n; i++) {
            if (i * (n - 2) + 2 * n - 1 > k) {
                return i;
            }
        }
        return n;
    }

    private int findModeOdd(int n, int k) {
        for (int i = 1; i < n - 1; i++) {
            if (i * (n - 2) + n + n - 1 > k) {
                return i;
            }
        }
        return (n * (n - 1) > k) ? n - 1 : n;
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.stream(row).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve();
        }
        scanner.close();
    }
}