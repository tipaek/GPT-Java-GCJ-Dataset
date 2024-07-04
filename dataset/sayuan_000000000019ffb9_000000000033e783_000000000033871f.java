import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Solution {

    public static final int INF = 1<<28;

    void solve(int caseNum) {
        int n = in.nextInt();
        int e = in.nextInt();

        int[][] d = new int[n+1][n+1];
        for (int i=1; i<=n; i++) for (int j=1; j<=n; j++) d[i][j] = i==j?0:INF;

        int[] x = new int[n+1];
        for (int i=2; i<=n; i++) {
            x[i] = in.nextInt();
            if (x[i] > 0) {
                d[1][i] = d[i][1] = x[i];
                x[i] = ~INF;
            }
        }

        Integer[] xi = new Integer[n-1];
        for (int i=0; i<n-1; i++) xi[i] = i+2;
        Arrays.sort(xi, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return x[b] - x[a];
            }
        });

        for (int j=0; j<n-1; j++) {
            Integer[] di = new Integer[n];
            for (int i=0; i<n; i++) di[i] = i+1;
            Arrays.sort(di, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return d[1][a] - d[1][b];
                }
            });

            int o = ~x[xi[j]];
            if (o==INF) break;

            int s = 1;
            if (j>0 && (~x[xi[j-1]] == o)) s = 0;


            int t = d[1][di[o]];
            d[1][xi[j]] = d[xi[j]][1] = t+s;
        }

        int[] a = new int[e];
        int[] b = new int[e];

        for (int i=0; i<e; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();

            int da = d[1][a[i]];
            int db = d[1][b[i]];
            int t = abs(da-db);
            if (t==0) t = 1;
            d[a[i]][b[i]] = d[b[i]][a[i]] = t;

        }

        for (int k=1; k<=n; k++) for (int i=1; i<=n; i++) for (int j=1; j<=n; j++) d[i][j] = min(d[i][j], d[i][k]+d[k][j]);
        // showMap(n, d);

        StringBuilder buf = new StringBuilder();
        for (int i=0; i<e; i++) {
            buf.append(' ').append(d[a[i]][b[i]]);
        }
        out.println(buf);

    }

    // void showMap(int n, int[][] d) {
        // out.println();
        // for (int i=1; i<=n; i++) {
            // for (int j=1; j<=n; j++) {
                // out.print((d[i][j]==INF?"x":d[i][j]) + "\t");
            // }
            // out.println();
        // }
    // }


    // {{{
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    public Solution() throws Exception {
        int caseCount = in.nextInt();
        for (int caseNum=1; caseNum<=caseCount; caseNum++) {
            out.printf("Case #%d:", caseNum);
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
