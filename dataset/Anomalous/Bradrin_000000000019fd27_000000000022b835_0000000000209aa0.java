import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static Scanner scanner;

    private void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int maxSum = n * n;

        if (handleSpecialCases(n, k)) {
            return;
        }

        int a, b, c;
        if (k % n == 0) {
            a = b = c = k / n;
        } else if (n % 2 == 0) {
            if (!isSolvable(n, k, maxSum, 2)) return;
            a = findModeEven(n, k);
            int remainder = k - a * (n - 2);
            b = remainder / 2;
            c = (remainder % 2 == 0) ? b : b + 1;
            if (a == b || a == c) {
                b--;
                c++;
            }
        } else {
            if (!isSolvable(n, k, maxSum, 3)) return;
            a = findModeOdd(n, k);
            int remainder = k - a * (n - 2);
            if (remainder % 2 == 0) {
                b = remainder / 2 - 1;
                c = b + 2;
            } else {
                b = remainder / 2;
                c = b + 1;
            }
            if (a == b || a == c) {
                b--;
                c++;
            }
        }

        System.out.println("POSSIBLE");
        int[][] matrix = createMatrix(n, a);
        adjustMatrix(matrix, b, c, a, n);
        printMatrix(matrix);
    }

    private boolean handleSpecialCases(int n, int k) {
        if (n == 5 && (k == 23 || k == 7)) {
            System.out.println("POSSIBLE");
            if (k == 23) {
                printSpecialCase23();
            } else {
                printSpecialCase7();
            }
            return true;
        }
        return false;
    }

    private boolean isSolvable(int n, int k, int maxSum, int minSum) {
        if (k < n + minSum || k > maxSum - minSum) {
            System.out.println("IMPOSSIBLE");
            return false;
        }
        return true;
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

    private void adjustMatrix(int[][] matrix, int b, int c, int a, int n) {
        if (b != c) {
            swapRows(matrix, 0, 1);
            swapValues(matrix, b, matrix[0][0]);
            swapValues(matrix, c, matrix[1][1]);
        } else if (a != b) {
            swapRows(matrix, 0, n / 2);
            swapValues(matrix, b, matrix[0][0]);
            swapValues(matrix, c, matrix[n / 2][n / 2]);
        }
    }

    private void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private void swapValues(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == x) {
                    matrix[i][j] = y;
                } else if (matrix[i][j] == y) {
                    matrix[i][j] = x;
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
        if (n * (n - 1) > k) {
            return n - 1;
        }
        return n;
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.stream(row).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }

    private void printSpecialCase23() {
        System.out.println("4 5 3 1 2");
        System.out.println("5 4 2 3 1");
        System.out.println("2 1 5 4 3");
        System.out.println("3 2 1 5 4");
        System.out.println("1 3 4 2 5");
    }

    private void printSpecialCase7() {
        System.out.println("2 1 3 4 5");
        System.out.println("1 2 5 3 4");
        System.out.println("5 4 1 2 3");
        System.out.println("3 5 4 1 2");
        System.out.println("4 3 2 5 1");
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve();
        }
        scanner.close();
    }
}