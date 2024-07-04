
import java.util.Scanner;

/**
 * Created by Acesine on 4/3/20.
 */
public class Solution {
    Scanner in = new Scanner(System.in);

    void solve() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            int N = in.nextInt();
            int trace = 0;
            int[][] cols = new int[N][N];
            int[][] rows = new int[N][N];
            int rcols = 0, rrows = 0;
            for (int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    int v = in.nextInt();
                    if (i == j) trace += v;
                    rows[i][v-1]++;
                    cols[j][v-1]++;
                }
            }
            for (int i=0;i<N;i++) {
                boolean rrep = false, crep = false;
                for (int j=0;j<N;j++) {
                    if (rows[i][j] > 1) {
                        rrep = true;
                    }
                    if (cols[i][j] > 1) {
                        crep = true;
                    }
                }
                if (rrep) rrows++;
                if (crep) rcols++;
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, trace, rrows, rcols));
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
