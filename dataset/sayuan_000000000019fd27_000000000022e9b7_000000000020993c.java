import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Solution {

    void solve(int caseNum) {
        int n = in.nextInt();
        int[][] m = new int[n][n];
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i=0; i<n; i++) for (int j=0; j<n; j++) m[i][j] = in.nextInt();
        for (int i=0; i<n; i++) {
            k += m[i][i];
l1:
            for (int j=0; j<n; j++) {
                for (int j2=0; j2<j; j2++) {
                    if (m[i][j2]==m[i][j]) {
                        r++;
                        break l1;
                    }
                }
            }
l2:
            for (int j=0; j<n; j++) {
                for (int j2=0; j2<j; j2++) {
                    if (m[j2][i]==m[j][i]) {
                        c++;
                        break l2;
                    }
                }
            }
        }
        out.printf("%d %d %d\n", k, r, c);
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
