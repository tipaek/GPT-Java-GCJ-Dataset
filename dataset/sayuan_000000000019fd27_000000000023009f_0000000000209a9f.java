import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Solution {

    void solve(int caseNum) {
        String s = in.next();
        StringBuilder buf = new StringBuilder();
        int c = 0;
        for (int i=0; i<s.length(); i++) {
            int n = s.charAt(i)-'0';
            for (int j=0; j<n-c; j++) buf.append('(');
            for (int j=0; j<c-n; j++) buf.append(')');
            buf.append(n);
            c = n;
        }
        for (int j=0; j<c; j++) buf.append(')');
        out.println(buf);
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
