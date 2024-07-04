import java.io.*;
import java.util.*;

class Solution {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;
    static int n,r,c;
    static long[][] a;
    static HashSet<Long>[] row_set;
    static HashSet<Long>[] col_set;
    static boolean[] row_dup,col_dup;

    private void solve(int t) {
        long ans = 0;
        n = in.nextInt();
        a = new long[n][n];
        r = 0; c = 0;
        row_set = new HashSet[n];
        HashSet<Long> col_set[] = new HashSet[n];
        for (int i = 0; i < n; i++) {
            row_set[i] = new HashSet<>();
            col_set[i] = new HashSet<>();
        }

        boolean row_dup[] = new boolean[n];
        boolean col_dup[] = new boolean[n];
        Arrays.fill(row_dup, false);
        Arrays.fill(col_dup, false);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextLong();

                if (row_set[i].contains(a[i][j]))
                    row_dup[i] = true;

                if (col_set[j].contains(a[i][j]))
                    col_dup[j] = true;

                    row_set[i].add(a[i][j]);
                    col_set[j].add(a[i][j]);   

                if (i == j)
                    ans += a[i][j];
            }
        }

        for (int i = 0; i < n; i++)
            if (col_dup[i])
                c++;
        for (int i = 0; i < n; i++)
            if (row_dup[i])
                r++;

        out.print("Case #" + t + ": "+ans+" "+r+" "+c);
        out.println();
    }

    private void run() throws Exception {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            // out.print("Case #" + i + ": ");
            solve(i);
        }
        in.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}
