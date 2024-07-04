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
            boolean[] cWork = new boolean[1440];
            boolean[] jWork = new boolean[1440];
            String res = "";
            boolean work = true;
            for (int j = 0; j < n; j++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                if (work)
                {
                    if (!Arrays.toString(Arrays.copyOfRange(cWork, s, e)).contains("true"))
                    {
                        Arrays.fill(cWork, s, e, true);
                        res += "C";
                    }
                    else if (!Arrays.toString(Arrays.copyOfRange(jWork, s, e)).contains("true"))
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