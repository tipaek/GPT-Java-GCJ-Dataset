import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static int trace(int[][] m, int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += m[i][i];
        }
        return k;
    }

    public static int rows(int[][] m, int n) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            int[] o = new int[n];
            for (int j = 0; j < n; j++) {
                o[j] = m[i][j];
            }
            Arrays.sort(o);
            boolean b = false;
            for (int j = 1; j < n; j++) {
                if (o[j - 1] == o[j]) {
                    b = true;
                    break;
                }
            }
            r += (b ? 1 : 0);
        }
        return r;
    }

    public static int cols(int[][] m, int n) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            int[] o = new int[n];
            for (int j = 0; j < n; j++) {
                o[j] = m[j][i];
            }
            Arrays.sort(o);
            boolean b = false;
            for (int j = 1; j < n; j++) {
                if (o[j - 1] == o[j]) {
                    b = true;
                    break;
                }
            }
            c += (b ? 1 : 0);
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = sc.nextInt();
                }
            }
            int k = trace(m, n);
            int r = rows(m, n);
            int c = cols(m, n);
            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }
}
