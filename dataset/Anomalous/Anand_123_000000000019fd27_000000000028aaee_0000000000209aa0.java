import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (k % n != 0) {
                System.out.println("case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("case #" + i + ": POSSIBLE");
                int val = k / n;
                int[][] matrix = new int[n][n];
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        int diff = c - r;
                        matrix[r][c] = (val + diff) % n;
                        if (matrix[r][c] == 0) {
                            matrix[r][c] = n;
                        }
                        if (matrix[r][c] < 0) {
                            matrix[r][c] += n;
                        }
                    }
                }
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        System.out.print(matrix[r][c] + " ");
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}