import java.util.Scanner;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int k = sc.nextInt();
            int[][] matrix = new int[n][n];
            boolean possible = false;

            for (int j = 0; j < n; j++) {
                int value = 1;
                for (int m = 0; m < n; m++) {
                    matrix[j][m] = value++;
                    if (value > n) value = 1;
                }

                if ((j + 1) * n == k) {
                    possible = true;
                    System.out.println("Case #" + i + ": POSSIBLE");
                    break;
                }
            }

            if (!possible) {
                if (arrange(matrix, k)) {
                    System.out.println("Case #" + i + ": POSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
    }

    static boolean check(int[][] matrix, int k) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][n - i - 1];
        }

        return primaryDiagonalSum == k || secondaryDiagonalSum == k;
    }

    static boolean arrange(int[][] matrix, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j != i) {
                    int[] temp = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = temp;
                }

                if (check(matrix, k)) {
                    return true;
                }
            }
        }
        return false;
    }
}