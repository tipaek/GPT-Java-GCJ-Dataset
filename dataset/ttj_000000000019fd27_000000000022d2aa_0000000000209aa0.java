import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int length = scanner.nextInt();
            int trace = scanner.nextInt();
            int[][] result = getResult(length, trace);
            System.out.print("Case #" + (i + 1) + ": ");
            if (result == null) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println("POSSIBLE");
                for (int k = 0; k < length; k++) {
                    for (int l = 0; l < length; l++) {
                        System.out.print(result[k][l]);
                        if (l != length - 1)
                            System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            if (i != n - 1)
                System.out.println();
        }
    }

    private static int[][] getResult(int length, int trace) {
        int[][] matrix = new int[length][length];
        return getSolution(matrix, trace, 0, 0);
    }

    private static int[][] getSolution(int[][] matrix, int trace, int currentTrace, int i) {
        if (i == matrix.length * matrix.length) {
            return matrix;
        }
        int x = i % matrix.length;
        int y = i / matrix.length;
        for (int j = 1; j <= matrix.length; j++) {
            if (!canTry(matrix, trace, currentTrace, x, y, j)) {
                continue;
            }
            int newTrace = currentTrace;
            if (x == y) {
                newTrace += j;
            }
            matrix[x][y] = j;
            int[][] solution = getSolution(matrix, trace, newTrace, i + 1);
            if (solution != null) {
                return solution;
            }
            matrix[x][y] = 0;
        }

        return null;
    }

    private static boolean canTry(int[][] matrix, int trace, int currentTrace, int x, int y, int candidate) {
        int newTrace = currentTrace;
        if (x == y) {
            newTrace += candidate;
            if (newTrace > trace) {
                return false;
            }
            if (x == matrix.length - 1 && newTrace != trace) {
                return false;
            }
        }
        for (int k = 0; k < matrix.length; k++) {
            if (matrix[x][k] == candidate || matrix[k][y] == candidate) {
                return false;
            }
        }

        return true;
    }
}
