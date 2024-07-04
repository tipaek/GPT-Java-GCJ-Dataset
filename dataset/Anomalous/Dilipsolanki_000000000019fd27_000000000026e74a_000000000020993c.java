import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Reading the matrix and calculating diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += arr[i][j];
                    }
                }
            }

            // Checking row repeats
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Checking column repeats
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    seen[arr[j][i]] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", k + 1, diagonalSum, rowRepeats, colRepeats);
        }

        sc.close();
    }
}