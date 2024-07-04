
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
            int u;

            short[][] mat = new short[n+1][n+1];
            boolean[] rv = new boolean[n+1];

            for (int j = 0; j < n; ++j) {
                boolean m = false;
                short[] v = new short[n+1];
                for (int k = 0; k < n; ++k) {
                    u = in.nextInt();

                    if (j == k) {
                        r1 += u;
                    }

                    if (++v[u] > 1) m = true;

                    if (++mat[k][u] > 1) rv[k] = true;
                }

                if (m) {
                    r2 += 1;
                }
            }

            for (int j = 0; j <= n; ++j) {
            	if (rv[j])
            		++r3;
            }

            System.out.println("Case #" + i + ": " + r1 + " " + r2 + " " + r3);
        }
        in.close();

        System.exit(0);
    }
}