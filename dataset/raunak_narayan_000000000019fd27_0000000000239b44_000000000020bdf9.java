import java.io.*;
import java.util.*;

class Solution {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;
    static int n, J, C,j2,c2;
    static Point[] s,e;
    static HashSet<Long>[] row_set;
    static HashSet<Long>[] col_set;
    static boolean[] setJ, col_dup;
    static boolean impossible;
    static String S;
    static char[] ans;

    static class Point implements Comparable<Point>
    {
       int val,index; 

       @Override
       public int compareTo(Point o) {
           // TODO Auto-generated method stub
           return this.val - o.val;
       }
       @Override
       public String toString()
       {
           return ""+val; 
       }
    }

    private void solve(int t) {
        n = in.nextInt();
        s = new Point[n];
        e = new Point[n];
         ans = new char[n];
        
        C = J = -1;
        impossible = false;
        S = "";

        for(int i = 0;i < n;i++)
        {
            Point a = new Point();
            Point b = new Point();
            a.val = in.nextInt();
            b.val = in.nextInt();
            a.index = b.index = i;
            s[i] = a;
            e[i] = b;
        }

        Arrays.sort(s);
        Arrays.sort(e);

        // printA(s);
        // printA(e);   
        
        int i = 0,j = 0;
        while(i < n && j < n)
        {
            // System.out.println("i = "+i+" j = "+j+" J = "+J+" C = "+C);
            if(e[j].val <= s[i].val)
            {
                if(J == e[j].index)
                    J = -1;
                else if(C == e[j].index)
                    C = -1;
                j++;
            }
            else if(e[j].val > s[i].val)
            {
                if(J == -1)
                {
                    J = s[i].index;
                    ans[s[i].index] = 'J';    
                }
                else if(C == -1)
                {
                    C = s[i].index;
                    ans[s[i].index] = 'C';
                }
                else{
                    impossible = true;
                    break;
                }

                i++;
            }
        }
        if(j < n)
        {
            for(int m = j;m < n;m++)
            {
                if(J == e[m].index)
                    J = -1;
                else if(C == e[m].index)
                    C = -1;
            }

        }

        // CommonDebugCode.printArray(setJ);
        getS();

        out.print("Case #" + t + ": " + S);
        out.println();
    }

    void getS()
    {
        if(impossible)
            S = "IMPOSSIBLE";
        else
        {
            for(int i = 0;i < n;i++)
            {
                S += ans[i];
            }
        } 
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

    void printA(Point[] P)
    {
        for(int i = 0;i < n;i++)
            System.out.print(P[i].val+" ");   
        System.out.println();
    }

}
