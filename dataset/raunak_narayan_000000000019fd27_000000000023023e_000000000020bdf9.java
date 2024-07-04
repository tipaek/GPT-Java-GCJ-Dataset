import java.io.*;
import java.util.*;

class Solution {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;
    static int n, j1, c1,j2,c2;
    static int[] s,e;
    static HashSet<Long>[] row_set;
    static HashSet<Long>[] col_set;
    static boolean[] setJ, col_dup;
    static boolean impossible;
    static String S;

    private void solve(int t) {
        n = in.nextInt();
        s = new int[n];
        e = new int[n];
        setJ = new boolean[n];
        
        j1 = c1 = Integer.MAX_VALUE;
        j2 = c2 = Integer.MIN_VALUE;
        impossible = false;
        S = "";

        for(int i = 0;i < n;i++)
        {
            s[i] = in.nextInt();
            e[i] = in.nextInt();
            // System.out.println("j1 = "+j1+" j2 = "+j2+" c1 = "+c1+" c2 = "+c2);
            if(e[i] <= j1 || s[i] >= j2)
            {
                j1 = Math.min(j1,s[i]);
                j2 = Math.max(j2,e[i]);
                setJ[i] = true;
            }
            else if(e[i] <= c1 || s[i] >= c2){
                c1 = Math.min(c1,s[i]);
                c2 = Math.max(c2,e[i]);
            }
            else
                impossible = true;
        }
        // CommonDebugCode.printArray(setJ);
        if(impossible)
            S = "IMPOSSIBLE";
        else
        {
            for(int i = 0;i < n;i++)
            {
                if(setJ[i])
                    S+="J";
                    else
                    S += "C";
            }
        }    


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
