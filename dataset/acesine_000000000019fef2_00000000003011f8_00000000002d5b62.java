
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    Scanner in = new Scanner(System.in);

    void solve(int t) {
        long xx = in.nextLong(), yy = in.nextLong();
        long x = Math.abs(xx), y = Math.abs(yy);
        StringBuilder sb = new StringBuilder();

        int[] xs = new int[35];
        int[] ys = new int[35];
        for (int i=0;i<35;i++) {
            long mask = 1L << i;
            if ((x & mask) != 0) xs[i] = 1;
            if ((y & mask) != 0) ys[i] = 1;
        }

        if (xs[0] == 1 && ys[0] == 1) {
            System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            return;
        }

        for (int i=0;i<35;i++) {
            if (xs[i] > 1) {
                xs[i+1] += xs[i] / 2;
                xs[i] %= 2;
            }
            if (ys[i] > 1) {
                ys[i+1] += ys[i] / 2;
                ys[i] %= 2;
            }
            if (xs[i] == 0 && ys[i] == 0) {
                for (int j=i;j<35;j++) {
                    if (xs[j] != 0 || ys[j] != 0) {
                        System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
                        return;
                    }
                }
                break;
            }
            if (xs[i] != 0 && ys[i] != 0) {
                if (xs[i-1] == 1) {
                    xs[i+1]++;
                    xs[i-1] = -1;
                    xs[i] = 0;
                } else {
                    ys[i+1]++;
                    ys[i-1] = -1;
                    ys[i] = 0;
                }
            }
        }

        for (int i=0;i<xs.length;i++) {
            if (xs[i] == 0 && ys[i] == 0) break;
            if (xs[i] != 0) sb.append(xs[i] == 1 ? 'E' : 'W');
            else sb.append(ys[i] == 1 ? 'N' : 'S');
        }

        if (xx < 0) {
            for (int i=0;i<sb.length();i++) {
                if (sb.charAt(i) == 'E') sb.setCharAt(i, 'W');
                else if (sb.charAt(i) == 'W') sb.setCharAt(i, 'E');
            }
        }
        if (yy < 0) {
            for (int i=0;i<sb.length();i++) {
                if (sb.charAt(i) == 'N') sb.setCharAt(i, 'S');
                else if (sb.charAt(i) == 'S') sb.setCharAt(i, 'N');
            }
        }
        System.out.println(String.format("Case #%d: %s", t, sb.toString()));
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            solve(t);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
