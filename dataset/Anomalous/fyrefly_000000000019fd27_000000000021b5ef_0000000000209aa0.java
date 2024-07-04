import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int tn = 1; tn <= t; tn++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[][] matrix = new int[n][n];
            boolean isPossible = false;

            for (int start = 1; start <= n; start++) {
                for (int i = 0; i < n; i++) {
                    int value = start + i;
                    for (int j = 0; j < n; j++) {
                        if (value > n) value = 1;
                        matrix[i][j] = value++;
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
                System.out.println("Case #" + tn + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + tn + ": IMPOSSIBLE");
            }
        }
    }
}