import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Solution {

    void solve(int caseNum) {
        int x = in.nextInt();
        int y = in.nextInt();
        if (((x^y)&1)==0) {
            out.println("IMPOSSIBLE");
            return;
        }

        int t = abs(x)+abs(y);
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<35; i++) {
            if (t>(1l<<(i+1))) continue;
            int tx = x;
            int ty = y;

            long s = 1l<<i;
            while (s>=1) {
                if (abs(tx)>abs(ty)) {
                    if (tx > 0) {
                        tx -= s;
                        ans.append('E');
                    } else {
                        tx += s;
                        ans.append('W');
                    }
                } else {
                    if (ty > 0) {
                        ty -= s;
                        ans.append('N');
                    } else {
                        ty += s;
                        ans.append('S');
                    }
                }
                s >>= 1;
            }

            if (tx==0&&ty==0) {
                out.println(ans.reverse());
                break;
            }
        }

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
