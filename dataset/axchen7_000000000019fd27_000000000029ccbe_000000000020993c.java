import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] m = new int[n][n];
            for (int j = 0; j < n; j++) for (int k = 0; k < n; k++) m[j][k] = scanner.nextInt();
            int a = 0;
            for (int j = 0; j < n; j++) a += m[j][j];
            int r = 0;
            for (int j = 0; j < n; j++) {
                boolean[] v = new boolean[n + 1];
                for (int k = 0; k < n; k++) {
                    if (v[m[j][k]]) {
                        r++;
                        break;
                    } else {
                        v[m[j][k]] = true;
                    }
                }
            }
            int c = 0;
            for (int j = 0; j < n; j++) {
                boolean[] v = new boolean[n + 1];
                for (int k = 0; k < n; k++) {
                    if (v[m[k][j]]) {
                        c++;
                        break;
                    } else {
                        v[m[k][j]] = true;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + a + " " + r + " " + c);
        }
    }
}
