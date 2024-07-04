
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    Scanner in = new Scanner(System.in);

    void solve(int t, long xx, long yy) {
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

        if (xs[0] == 0 && ys[0] == 0) {
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
                boolean finish = true;
                for (int j=i;j<35;j++) {
                    if (xs[j] != 0 || ys[j] != 0) {
                        finish = false;
                        break;
                    }
                }
                if (finish) break;
                if (xs[i-1] == 1) {
                    xs[i] = 1;
                    xs[i-1] = -1;
                } else {
                    ys[i] = 1;
                    ys[i-1] = -1;
                }
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
        verify(sb.toString(), xx, yy);
        System.out.println(String.format("Case #%d: %s", t, sb.toString()));
    }

    boolean verify(String s, long x, long y) {
        long xx = 0;
        long yy = 0;

        long b = 1;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == 'E') {
                xx += b;
            }
            if (s.charAt(i) == 'W') {
                xx -= b;
            }
            if (s.charAt(i) == 'N') {
                yy += b;
            }
            if (s.charAt(i) == 'S') {
                yy -= b;
            }
            b *= 2;
        }

        if (xx != x || yy != y) throw new RuntimeException(x + ", " + y);
        return true;
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            solve(t, in.nextLong(), in.nextLong());
        }
//        for (long x = -4;x<=4;x++) {
//            for (long y=-4;y<=4;y++) {
//                System.out.println(x + ", " + y);
//                solve(0, x, y);
//            }
//        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
