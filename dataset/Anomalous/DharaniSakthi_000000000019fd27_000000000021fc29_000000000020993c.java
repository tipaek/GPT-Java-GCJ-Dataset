import java.util.Scanner;

public class MatrixProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, n, i, j, k, s, r, c;

        t = scanner.nextInt();
        for (i = 1; i <= t; i++) {
            n = scanner.nextInt();
            int[][] a = new int[n][n];
            s = 0;
            r = 0;
            c = 0;

            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++) {
                    a[j][k] = scanner.nextInt();
                }
            }

            for (j = 0; j < n; j++) {
                s += a[j][j];
            }

            for (j = 0; j < n; j++) {
                for (k = 0; k < n - 1; k++) {
                    if (a[j][k] == a[j][k + 1]) {
                        r++;
                    }
                }
            }

            for (j = 0; j < n - 1; j++) {
                for (k = 0; k < n; k++) {
                    if (a[j][k] == a[j + 1][k]) {
                        c++;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i, s, r, c);
        }

        scanner.close();
    }
}