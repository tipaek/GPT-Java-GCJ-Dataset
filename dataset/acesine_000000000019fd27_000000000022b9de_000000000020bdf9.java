
import java.util.Arrays;
import java.util.Comparator;
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
            int[][] act = new int[n][4];
            boolean can = true;
            for (int i=0;i<n;i++) {
                act[i][0] = in.nextInt();
                act[i][1] = in.nextInt();
                act[i][2] = i;
            }
            Arrays.sort(act, Comparator.comparingInt(x -> x[0]));
            int c = -1, j = -1;
            for (int i=0;i<n;i++) {
                if (act[i][0] >= c) {
                    act[i][3] = 1;
                    c = act[i][1];
                } else if (act[i][0] >= j) {
                    act[i][3] = 2;
                    j = act[i][1];
                } else {
                    can = false;
                }
            }

            if (!can) System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            else {
                Arrays.sort(act, Comparator.comparingInt(x -> x[2]));
                StringBuilder ret = new StringBuilder();
                for (int i=0;i<n;i++) {
                    ret.append(act[i][3] == 1? 'C' : 'J');
                }
                System.out.println(String.format("Case #%d: %s", t, ret.toString()));
            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
