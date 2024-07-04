import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Solution {

    long f(long k, long n, int r) {
        return (k+k+(n-1)*r)*n/2;
    }

    void solve(int caseNum) {
        long l = in.nextLong();
        long r = in.nextLong();
        long d = abs(l-r);

        long n;
        {
            long lower = 0;
            long upper = 1L<<31;
            while (lower<upper) {
                long mid = (lower+upper) >> 1;
                long t = f(1, mid, 1);
                if (t>d)
                    upper = mid;
                else
                    lower = mid+1;
            }
            n = lower-1;

            if (l<r) r -= f(1, n, 1);
            else l -= f(1, n, 1);

            if (l<r && r>=n+1) {
                r -= n+1;
                n++;
            }
        }
        // debug(n, l, r);

        long n2;
        {
            long lower = 0;
            long upper = 1L<<31;
            while (lower<upper) {
                long mid = (lower+upper) >> 1;
                long tl = f(n+1, mid, 2);
                long tr = f(n+2, mid, 2);

                if (l<tl || r<tr)
                    upper = mid;
                else
                    lower = mid+1;
            }

            n2 = lower-1;
            l -= f(n+1, n2, 2);
            r -= f(n+2, n2, 2);
            n += n2*2;

            if (l>=n+1) {
                l -= n+1;
                n++;
            }
        }
        // debug(n, l, r);
        out.println(n+" "+l+" "+r);
    }

    // {{{
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    public Solution() throws Exception {
        int caseCount = in.nextInt();
        for (int caseNum=1; caseNum<=caseCount; caseNum++) {
            out.printf("Case #%d: ", caseNum);
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
