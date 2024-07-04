import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(in.readLine());

        for (int k = 1; k <= t1; k++) {
            int n = Integer.parseInt(in.readLine());
            int[] j = new int[1441];
            int[] c = new int[1441];
            int[][] a = new int[n][2];

            Arrays.fill(j, 0);
            Arrays.fill(c, 0);

            for (int i = 0; i < n; i++) {
                String[] b = in.readLine().split(" ");
                a[i][0] = Integer.parseInt(b[0]);
                a[i][1] = Integer.parseInt(b[1]);
            }

            StringBuilder ans = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                boolean cc = false, jj = false;

                for (int m = a[i][0]; m < a[i][1]; m++) {
                    if (j[m] == 1) jj = true;
                    if (c[m] == 1) cc = true;
                }

                if (jj && cc) {
                    ans = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }

                if (!jj) {
                    Arrays.fill(j, a[i][0], a[i][1], 1);
                    ans.append("J");
                } else {
                    Arrays.fill(c, a[i][0], a[i][1], 1);
                    ans.append("C");
                }
            }

            System.out.println("Case #" + k + ": " + ans);
        }
    }
}