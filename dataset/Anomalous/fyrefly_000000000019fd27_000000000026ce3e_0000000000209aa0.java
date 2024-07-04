import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            boolean isPossible = false;

            for (int startValue = 1; startValue <= n; startValue++) {
                for (int row = 0; row < n; row++) {
                    int value = startValue - row;
                    for (int col = 0; col < n; col++) {
                        if (value <= 0) value = n;
                        matrix[row][col] = value;
                        value--;
                    }
                }

                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace += matrix[i][i];
                }

                if (trace == k) {
                    isPossible = true;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}