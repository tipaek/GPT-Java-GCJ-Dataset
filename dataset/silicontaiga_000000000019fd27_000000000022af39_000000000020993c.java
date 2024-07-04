import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int tt = 0; tt < t; tt++) {
            int n = scanner.nextInt();

            int trace = 0;

            int rows = 0;
            int cols = 0;

            int[][] r = new int[n][n + 1];
            int[][] c = new int[n][n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int v = scanner.nextInt();

                    if (i == j) {
                        trace += v;
                    }

                    r[i][v]++;
                    c[j][v]++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (r[i][j] > 1) {
                        rows++;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (c[i][j] > 1) {
                        cols++;
                        break;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", tt + 1, trace, rows, cols);
        }
    }
}