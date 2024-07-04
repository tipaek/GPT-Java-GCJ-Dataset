import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        int testCase = scanner.nextInt();

        for (int i = 1; i <= testCase; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            solution(n, k, i);
        }

    }

    public static void solution(int n, int k, int testCase) {

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }

        boolean temp = backTracking(matrix, k);

        if (temp) {
            System.out.println("Case #" + testCase + ": POSSIBLE");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
    }

    public static boolean backTracking(int[][] matrix, int k) {

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    for (int l = 1; l <= row; l++) {
                        if (!isInCol(j, matrix, l) && !isInRow(i, matrix, l)) {
                            matrix[i][j] = l;
                            if (backTracking(matrix, k) && isSumEqualToK(matrix, k))
                                return true;
                            else
                                matrix[i][j] = Integer.MAX_VALUE;
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean isSumEqualToK(int[][] matrix, int k) {

        int sum = 0;

        for (int i = 0; i < matrix.length; i++)
            sum += matrix[i][i];

        return sum == k;

    }

    public static boolean isInCol(int col, int[][] matrix, int a) {

        for (int i = 0; i < matrix.length; i++) {
            if (a == matrix[i][col])
                return true;
        }
        return false;
    }

    public static boolean isInRow(int row, int[][] matrix, int a) {
        for (int i = 0; i < matrix.length; i++) {
            if (a == matrix[row][i])
                return true;
        }
        return false;
    }

}