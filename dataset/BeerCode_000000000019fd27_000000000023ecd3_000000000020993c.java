import java.util.*;
class Solution {
    public static void main(String[] commands) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            int[][]m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                }
            }
            int k = 0;
            for (int i = 0; i < n; i++) {
                k += m[i][i];
            }
            int target = (n+1) * n / 2;
            int r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                boolean ok = true;
                for (int j = 0; j < n; j++) {
                    if (m[i][j] < 1 ||
                        m[i][j] > n) { ok = false; }
                    sum += m[i][j];
                }
                if (sum != target || !ok) { r++; }
            }
            for (int j = 0; j < n; j++) {
                int sum = 0;
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    if (m[i][j] < 1 ||
                        m[i][j] > n) { ok = false; }
                    sum += m[i][j];
                }
                if (sum != target || !ok) { c++; }
            }
            
            System.out.println("Case #" + t + ": " +
                        k + " " + r + " " + c);
        }
    }
}