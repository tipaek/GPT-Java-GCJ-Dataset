import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean isPossible = false;
            int diagonalValue = 0;

            for (int i = 1; i <= n; i++) {
                diagonalValue = n * i;
                if (k == diagonalValue) {
                    isPossible = true;
                    diagonalValue = i;
                    break;
                }
            }

            if (!isPossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t + 1);
            } else {
                System.out.printf("Case #%d: POSSIBLE%n", t + 1);
                int[][] matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    if (i == 0) {
                        matrix[0][i] = diagonalValue;
                    } else {
                        matrix[0][i] = (matrix[0][i - 1] - 1) < 1 ? n : (matrix[0][i - 1] - 1);
                    }
                    for (int j = 1; j < n; j++) {
                        matrix[j][i] = (matrix[j - 1][i] + 1) > n ? 1 : (matrix[j - 1][i] + 1);
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}