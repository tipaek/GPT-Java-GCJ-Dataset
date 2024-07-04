
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int x = 1;
        while (t-- != 0) {
            int n = s.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = s.nextInt();
                }

            }
            int row_dup = 0, col_dup = 0;
            for (int i = 0; i < n; i++) {
                int[] freq = new int[101];
                for (int j = 0; j < n; j++) {
                    freq[mat[i][j]]++;
                }
                for (int j = 1; j <= 100; j++) {
                    if (freq[j] > 1) {
                        row_dup++;
                        break;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                int[] freq = new int[101];
                for (int i = 0; i < n; i++) {
                    freq[mat[i][j]]++;
                }
                for (int i = 1; i <= 100; i++) {
                    if (freq[i] > 1) {
                        col_dup++;
                        break;
                    }
                }
            }
            int sum = 0;
            for (int i = 0, j = 0; i < n; i++, j++) {
                sum += mat[i][j];
            }
            System.out.println("Case #" + x + ": " + sum + " " + row_dup + " " + col_dup);
            x++;
        }
    }
}
