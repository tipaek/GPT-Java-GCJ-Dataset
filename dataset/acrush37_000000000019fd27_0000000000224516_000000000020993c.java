import java.util.Scanner;

public class Solution {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        for (int k = 1; k <= m; k++) {

            int n = scanner.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = scanner.nextInt();

            int s = 0;
            for (int i = 0; i < n; i++) s += a[i][i];
            System.out.print("Case #" + k + ": " + s);
            s = 0;

            for (int i = 0; i < n; i++) {

                boolean[] t = new boolean[n+1];

                for (int j = 0; j < n; j++)
                    if (!t[a[i][j]]) t[a[i][j]] = true;
                    else {
                        s++;
                        break;
                    }
            }

            System.out.print(" " + s);
            s = 0;

            for (int j = 0; j < n; j++) {

                boolean[] t = new boolean[n+1];

                for (int i = 0; i < n; i++)
                    if (!t[a[i][j]]) t[a[i][j]] = true;
                    else {
                        s++;
                        break;
                    }
            }

            System.out.println(" " + s);
        }
    }

}
