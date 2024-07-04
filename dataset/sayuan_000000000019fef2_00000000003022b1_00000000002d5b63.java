import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Solution {

    public static final int INF = 1<<30;
    int gy(int lower, int upper, boolean f, int x) {
        if (f) {
            out.println(x + " " + upper);
            String r = in.next();
            if (r.equals("HIT")) {
                return upper;
            }
        } else {
            out.println(x + " " + lower);
            String r = in.next();
            if (r.equals("HIT")) {
                return lower;
            }
        }
        while (lower<upper) {
            int mid = (lower+upper)/2;

            out.println(x + " " + mid);
            String r = in.next();
            if (r.equals("CENTER")) return INF;
            boolean hit = r.equals("HIT");

            if (f) {
                if (!hit)
                    upper = mid;
                else
                    lower = mid+1;
            } else {
                if (hit)
                    upper = mid-1;
                else
                    lower = mid;
            }
        }
        if (f) return lower-1;
        return lower+1;
    }

    int gx(int lower, int upper, boolean f, int y) {
        if (f) {
            out.println(upper + " " + y);
            String r = in.next();
            if (r.equals("HIT")) {
                return upper;
            }
        } else {
            out.println(lower + " " + y);
            String r = in.next();
            if (r.equals("HIT")) {
                return lower;
            }
        }
        while (lower<upper) {
            int mid = (lower+upper)/2;
            out.println(mid + " " + y);
            String r = in.next();
            if (r.equals("CENTER")) return INF;
            boolean hit = r.equals("HIT");

            if (f) {
                if (!hit)
                    upper = mid;
                else
                    lower = mid+1;
            } else {
                if (hit)
                    upper = mid-1;
                else
                    lower = mid;
            }
        }
        if (f) return lower-1;
        return lower+1;
    }

    boolean f(int x, int y) {
        out.println(x + " " + y);
        String r = in.next();
        if (r.equals("CENTER")) return true;
        if (r.equals("MISS")) return false;

        int tx = gx(x, F, true, y);
        if (tx==INF) return true;
        int bx = gx(-F, x, false, y);
        if (bx==INF) return true;
        int ry = gy(y, F, true, x);
        if (ry==INF) return true;
        int ly = gy(-F, y, false, x);
        if (ly==INF) return true;
        int cx = (tx+bx)/2;
        int cy = (ly+ry)/2;
        out.println(cx + " " + cy);
        r = in.next();
        if (r.equals("CENTER")) return true;
        // debug("???");
        return false;
    }

    int F = (int) 1e9;
    int H = F/2;
    void solve(int caseNum) {
        if (f(0, H)) return;
        if (f(H, 0)) return;
        if (f(0, -H)) return;
        if (f(-H, 0)) return;
    }

    // {{{
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    public Solution() throws Exception {
        int caseCount = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        for (int caseNum=1; caseNum<=caseCount; caseNum++) {
            solve(caseNum);
        }
    }
    public static void main(String[] args) throws Exception {
        new Solution();
    }
    public static void debug(Object... arr) {
        System.err.println(Arrays.deepToString(arr));
    }
    // }}}
}
