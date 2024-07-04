
import java.util.Scanner;

/**
 * Created by Acesine on 4/3/20.
 */
public class Solution {
    Scanner in = new Scanner(System.in);

    void solve() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            int n = in.nextInt();
            int[] r = new int[24*60+1];
            int[][] act = new int[n][2];
            boolean can = true;
            StringBuilder ret = new StringBuilder();
            for (int i=0;i<n;i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                act[i][0] = s;
                act[i][1] = e;
                boolean saw1 = false;
                boolean saw2 = false;
                for (int k=s;k<e;k++) {
                    if (r[k] == 1) saw1 = true;
                    if (r[k] == 2) saw2 = true;
                    if (r[k] == 3) {
                        saw1 = true;
                        saw2 = true;
                    }
                }
                if (saw1 && saw2) can = false;
                int v = 1;
                if (saw1) v = 2;
                for (int k=s;k<e;k++) {
                    if (r[k] == 0) r[k] = v;
                    else r[k] = 3;
                }
                if (v == 1) ret.append('C');
                else ret.append('J');
            }

            if (!can) System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            else {
                for (int i=0;i<n;i++) {
                    int v = ret.charAt(i) == 'C' ? 1 : 2;
                    for (int k=act[i][0];k<act[i][1];k++) {
                        if (r[k] == v) continue;
                        if (r[k] != 3) throw new RuntimeException();
                    }
                }
                System.out.println(String.format("Case #%d: %s", t, ret.toString()));
            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
