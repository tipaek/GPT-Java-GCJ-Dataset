import java.util.*;
public class Solution
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int n = sc.nextInt();
            int[] starts = new int[n];
            int[] ends = new int[n];
            String res = "";
            boolean work = true;
            ArrayList <Integer> cases = new ArrayList<>();
            for (int w = 0; w < 1440; w++)
                cases.add(0);
            for (int j = 0; j < n; j++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                starts[j] = s;
                ends[j] = e;
                if (work)
                {
                    if (!cases.contains(3))
                    {
                        for (int k = s; k < e; k++)
                            cases.set(k,cases.get(k)+1);
                    }
                    else
                    {
                        res = "IMPOSSIBLE";
                        work = false;
                    }
                }
            }
            if (cases.contains(3))
                res = "IMPOSSIBLE";
            else if (work)
            {
                for (int j = 0; j < starts.length; j++)
                {
                    if (cases.get(starts[j])==2)
                        res+="J";
                    else
                        res+="C";
                }
            }
            System.out.println("Case #" + i + ": " + res );
        }
    }
}