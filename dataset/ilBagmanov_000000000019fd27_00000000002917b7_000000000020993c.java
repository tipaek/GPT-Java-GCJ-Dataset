import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int w = 0; w < t; w++) {
            int n = sc.nextInt();
            int[][] a = new int[n * 2][n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                    a[n + j][i] = a[i][j];
                    if (i == j) sum += a[i][j];
                }
            }
            int answer1 = 0;
            int answer2 = 0;
            for (int i = 0; i < n; i++) {
                Arrays.sort(a[i]);
                for (int j = 0; j < n - 1; j++) {
                    if (a[i][j] == a[i][j + 1]) {
                        answer1++;
                        break;
                    }
                }
            }
            for (int i = n; i < 2 * n; i++) {
                Arrays.sort(a[i]);
                for (int j = 0; j < n - 1; j++) {
                    if (a[i][j] == a[i][j + 1]) {
                        answer2++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + (w + 1) + ": " + sum + " " + answer1 + " " + answer2);
        }
    }
}
