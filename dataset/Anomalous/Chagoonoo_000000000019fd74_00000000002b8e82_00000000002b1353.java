import java.util.Scanner;

public class Solution {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        matrix = generateMatrix(500);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println("Case #" + (i + 1) + ":");
            if (n <= 501) {
                handleCaseLessThanOrEqualTo501(n);
            } else if (n <= 1000) {
                handleCaseLessThanOrEqualTo1000(n);
            }
        }
    }

    private static void handleCaseLessThanOrEqualTo501(int n) {
        System.out.println("1 1");
        if (n == 1) {
            return;
        }
        System.out.println("2 1");
        int sum = 2;
        int j = 1;
        while (sum < n) {
            System.out.println((j + 1) + " " + (j + 1));
            j++;
            sum++;
        }
    }

    private static void handleCaseLessThanOrEqualTo1000(int n) {
        int sum = 3;
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("2 2");
        int r = 3;
        while (sum < n) {
            if (sum + matrix[r][r - 2] <= n) {
                sum += matrix[r][r - 2];
                System.out.println((r + 1) + " " + (r - 1));
            } else {
                sum += matrix[r][r - 1];
                System.out.println((r + 1) + " " + r);
            }
            r++;
        }
    }

    private static int[][] generateMatrix(int n) {
        int lastLength = (matrix == null) ? 0 : matrix.length;
        if (n > lastLength) {
            int[][] newMatrix = new int[n][];
            for (int i = lastLength; i < n; i++) {
                newMatrix[i] = new int[i + 1];
                for (int j = 0; j < newMatrix[i].length; j++) {
                    if (j == 0 || j == newMatrix[i].length - 1) {
                        newMatrix[i][j] = 1;
                    } else {
                        newMatrix[i][j] = newMatrix[i - 1][j - 1] + newMatrix[i - 1][j];
                    }
                }
            }
            if (matrix != null) {
                copyArray(matrix, newMatrix);
            }
            matrix = newMatrix;
        }
        return matrix;
    }

    private static void copyArray(int[][] source, int[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
    }
}