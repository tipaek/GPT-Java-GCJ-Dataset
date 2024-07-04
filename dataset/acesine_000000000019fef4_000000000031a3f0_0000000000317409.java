
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    Scanner in = new Scanner(System.in);

    int solve(int t, int x, int y, String M) {
        int xx = x, yy = y;
        for (int i=0;i<M.length();i++) {
            if (Math.abs(xx) + Math.abs(yy) <= i) {
                return i;
            }
            switch (M.charAt(i)) {
                case 'S':
                    yy--;
                    break;
                case 'N':
                    yy++;
                    break;
                case 'E':
                    xx++;
                    break;
                case 'W':
                    xx--;
                    break;
            }
        }
        if (Math.abs(xx) + Math.abs(yy) <= M.length()) {
            return M.length();
        }
        return -1;
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            int r = solve(t, in.nextInt(), in.nextInt(), in.next());
            if (r == -1) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            } else {
                System.out.println(String.format("Case #%d: %d", t, r));
            }
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
