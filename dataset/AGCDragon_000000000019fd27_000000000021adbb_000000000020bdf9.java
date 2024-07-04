import java.io.*;
import java.util.*;

public class Solution 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 1; tt <= T; tt++)
        {
            
            int N = in.nextInt();
            String[] ans = new String[N];
            String answer = "";
            boolean ii = false;
            Sc[] S = new Sc[N];
            boolean C = false;
            boolean J = false;
            int one = 0;
            int two = 0;
            for(int x = 0; x < N; x++)
            {
                S[x] = new Sc(in.nextInt(), in.nextInt(), x);
            }
            Arrays.sort(S);
            int time = 0;
            for(int x = 0; x < N; x++)
            {
                time = S[x].s;
                if(one <= time)
                    C = false;
                if(two <= time)
                    J = false;
                if(!C)
                {
                    C = true;
                    ans[S[x].o] = "C";
                    one = S[x].e;
                }
                else if(!J)
                {
                    J = true;
                    ans[S[x].o] = "J";
                    two = S[x].e;
                }
                else
                {
                    answer = "IMPOSSIBLE";
                    ii = true;
                    break;
                }
            }
            if(!ii)
            {
                for(int x = 0; x < N; x++)
                {
                    answer += ans[x];
                }
            }
            System.out.println("Case #"+ tt +": " + answer);
        }
    }
}
class Sc implements Comparable<Sc>
{
    public int s;
    public int e;
    public int o;
    public Sc(int ss, int ee, int oo)
    {
        s = ss;
        e = ee;
        o = oo;
    }
    public int compareTo(Sc other)
    {
        if(other.s < s)
            return 1;
        else if(other.s > s)
            return -1;
        else
            return 0;
    }
    public String toString()
    {
        return "[" + s + " " + e + "]";
    }
}