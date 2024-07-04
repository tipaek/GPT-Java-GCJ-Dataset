import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();

            if (d % n == 0 && d <= n * n) {
                System.out.printf("Case #%d: POSSIBLE\n", t);
                int[][] matrix = new int[n][n];
                int offset = 0;

                for (int i = 0; i < n; i++) {
                    int value = d / n;
                    for (int j = 0; j < n; j++) {
                        matrix[i][(offset + j) % n] = value;
                        value++;
                        if (value > n) value = 1;
                    }
                    offset++;
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + (j == n - 1 ? "" : " "));
                    }
                    System.out.println();
                }
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            }
        }
    }
}