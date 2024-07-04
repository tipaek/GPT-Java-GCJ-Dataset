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
            String ans = "";
            int N = in.nextInt();
            Sc[] S = new Sc[N];
            boolean C = false;
            boolean J = false;
            int one = 0;
            int two = 0;
            for(int x = 0; x < N; x++)
            {
                S[x] = new Sc(in.nextInt(), in.nextInt());
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
                    ans += "C";
                    one = S[x].e;
                }
                else if(!J)
                {
                    J = true;
                    ans += "J";
                    two = S[x].e;
                }
                else
                {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            
            System.out.println("Case #"+ tt +": " + ans);
        }
    }
}
class Sc implements Comparable<Sc>
{
    public int s;
    public int e;
    public Sc(int ss, int ee)
    {
        s = ss;
        e = ee;
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