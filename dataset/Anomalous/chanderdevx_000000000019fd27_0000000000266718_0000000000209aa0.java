import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int x = 1; x <= t; x++) {
            String[] sar = sc.nextLine().split(" ");
            int n = Integer.parseInt(sar[0]);
            int k = Integer.parseInt(sar[1]);
            boolean isPossible = false;
            int diagonalValue = -1;

            for (int i = 1; i <= n; i++) {
                if (i * n == k) {
                    diagonalValue = i;
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
                continue;
            }

            int[][] matrix = new int[n][n];
            int filler = diagonalValue;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = (filler + j) % n + 1;
                }
                filler++;
            }

            System.out.println("Case #" + x + ": POSSIBLE");
            printMatrix(matrix);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}