import java.io.*;
import java.util.*;

class Solution {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;
    static int n, r, c;
    static long[][] a;
    static HashSet<Long>[] row_set;
    static HashSet<Long>[] col_set;
    static boolean[] row_dup, col_dup;
    static String S;

    private void solve(int t) {

        String inp = in.next();

        char[] c = inp.toCharArray();
        n = c.length;
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = c[i] - '0';

        S = "";
        append(A[0], 0, A[0]);
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1])
                append(A[i] - A[i - 1], 0, A[i]);
            if (A[i] <= A[i - 1])
                append(0, A[i - 1] - A[i], A[i]);
        }
        
        for (int i = 0; i < A[n-1]; i++)
            S += ")";

        out.print("Case #" + t + ": " + S);
        out.println();
    }

    void append(int o, int c, int num) {
        for (int i = 0; i < o; i++)
            S += "(";
        for (int i = 0; i < c; i++)
            S += ")";
        S += num;

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
