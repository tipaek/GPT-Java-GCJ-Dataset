import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static Scanner scanner;

    private void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int maxSum = n * n;

        int a, b, c;
        if (k % n == 0) {
            a = b = c = k / n;
        } else if (n % 2 == 0) {
            if (k < n + 2 || k > maxSum - 2) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            a = findModeEven(n, k);
            int remainder = k - a * (n - 2);
            b = remainder / 2;
            c = (remainder % 2 == 0) ? b : b + 1;
            if (a == b || a == c) {
                b--;
                c++;
            }
        } else {
            if (k < n + 3 || k > maxSum - 3) {
                System.out.println("IMPOSSIBLE");
                return;
            }
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

        if (b != c) {
            swapRows(matrix, 0, 1);
            swapValues(matrix, b, matrix[0][0]);
            swapValues(matrix, c, matrix[1][1]);
        } else if (a != b) {
            swapRows(matrix, 0, n / 2);
            swapValues(matrix, b, matrix[0][0]);
            swapValues(matrix, c, matrix[n / 2][n / 2]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.stream(matrix[i])
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(" ")));
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

    private void swapValues(int[][] matrix, int x, int y) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == x) {
                    row[j] = y;
                } else if (row[j] == y) {
                    row[j] = x;
                }
            }
        }
    }

    private void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
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
            if (i * (n - 2) + 2 * n - 1 > k) {
                return i;
            }
        }
        return n;
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