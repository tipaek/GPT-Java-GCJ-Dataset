import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = 0, b =0, c = 0;

            int n = sc.nextInt();

            int[][] x = new int[n][];
            for (int i1 = 0; i1 < n; i1++) {
                x[i1] = new int[n];
                for (int i2 = 0; i2 < n; i2++) {
                    x[i1][i2] = sc.nextInt();
                }
            }

            for (int i1 = 0; i1 < n; i1++) {
                a += x[i1][i1];
            }

            for (int i1 = 0; i1 < n; i1++) {
                int[] y = new int[n];
                for (int i2 = 0; i2 < n; i2++) {
                    if (y[x[i1][i2] - 1]++ == 1) {
                        b++;
                        break;
                    }
                }
            }

            for (int i1 = 0; i1 < n; i1++) {
                int[] y = new int[n];
                for (int i2 = 0; i2 < n; i2++) {
                    if (y[x[i2][i1] - 1]++ == 1) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", i + 1, a, b, c));
        }
    }
}
