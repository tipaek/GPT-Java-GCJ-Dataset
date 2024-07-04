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
            boolean[] cWork = new boolean[1441];
            boolean[] jWork = new boolean[1441];
            String res = "";
            boolean work = true;
            for (int j = 0; j < n; j++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                if (work)
                {
                    if (!Arrays.toString(Arrays.copyOfRange(cWork, s, e)).contains("true") && (!cWork[s] || s!= 0 && !cWork[s-1]) && (!cWork[e] || e != 1440 && !cWork[e+1]))
                    {
                        Arrays.fill(cWork, s, e, true);
                        res += "C";
                    }
                    else if (!Arrays.toString(Arrays.copyOfRange(jWork, s, e)).contains("true") && (!jWork[s] || s!= 0 && !jWork[s-1]) && (!jWork[e] || e != 1440 && !jWork[e+1]))
                    {
                        Arrays.fill(jWork, s, e, true);
                        res += "J";
                    }
                    else
                    {
                        res = "IMPOSSIBLE";
                        work = false;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + res );
        }
    }
}