import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static String find(int n, int[][] a) {

        char[] f = new char[n];
        Arrays.sort(a, (x, y) -> x[1] == y[1] ? y[2] - x[2] : x[1] - y[1]);

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++)
                if (a[i][1] < a[j][2]) {

                    if (f[a[i][0]] == 0) f[a[i][0]] = f[a[j][0]] == 'C' ? 'J' : 'C';
                    else if (f[a[i][0]] == f[a[j][0]]) return "IMPOSSIBLE";
                }

            if (f[a[i][0]] == 0) f[a[i][0]] = 'C';
        }

        return String.valueOf(f);
    }

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        for (int k = 1; k <= m; k++) {

            int n = scanner.nextInt();
            int[][] a = new int[n][3];

            for (int i = 0; i < n; i++) {
                a[i][0] = i;
                a[i][1] = scanner.nextInt();
                a[i][2] = scanner.nextInt();
            }

            System.out.println("Case #" + k + ": " + find(n, a));
        }
    }

}
