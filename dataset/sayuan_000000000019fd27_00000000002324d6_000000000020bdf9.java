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
        int[] s = new int[n];
        int[] e = new int[n];
        for (int i=0; i<n; i++) {
            s[i] = in.nextInt();
            e[i] = in.nextInt();
        }

        Integer[] indice = new Integer[n];
        for (int i=0; i<n; i++) indice[i] = i;
        Arrays.sort(indice, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return s[a]-s[b];
            }
        });

        char[] assigns = new char[n];
        int c = 0;
        for (int i=0; i<n; i++) {
            int ind = indice[i];
            if (c > s[ind]) continue;
            assigns[ind] = 'C';
            c = e[ind];
        }

        c = 0;
        for (int i=0; i<n; i++) {
            int ind = indice[i];
            if (assigns[ind] == 'C') continue;
            if (c > s[ind]) {
                out.println("IMPOSSIBLE");
                return;
            }
            assigns[ind] = 'J';
            c = e[ind];
        }

        out.println(new String(assigns));
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
