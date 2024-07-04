import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int x = 1; x <= t; x++) {
            String[] sar = sc.nextLine().split(" ");
            int n = Integer.parseInt(sar[0]);
            int k = Integer.parseInt(sar[1]);

            int diagonal = findDiagonal(n, k);
            if (diagonal == -1) {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
            } else {
                int[][] matrix = generateMatrix(n, diagonal);
                System.out.println("Case #" + x + ": POSSIBLE");
                printMatrix(matrix);
            }
        }
    }

    private static int findDiagonal(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (i * n == k) {
                return i;
            }
        }
        return -1;
    }

    private static int[][] generateMatrix(int n, int diagonal) {
        int[][] matrix = new int[n][n];
        int filler = diagonal;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (filler + j) % n + 1;
            }
            filler++;
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = row.length - 1; j >= 0; j--) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }
}