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
            int[] cases = new int[1440];
            for (int w = 0; w < 1440; w++)
                cases[w] = 0;
            for (int j = 0; j < n; j++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                starts[j] = s;
                ends[j] = e;
                for (int k = s; k < e; k++)
                    cases[k] ++;
            }
            boolean work = true;
            for (int j = 0; j < n; j++) {
                if (cases[j] >= 3) {
                    res = "IMPOSSIBLE";
                    work = false;
                    break;
                }
            }
            String[] fin = new String[n];
            Arrays.fill(fin,"C");
            if (work)
            {
                for (int j = 0; j < cases.length; j++)
                {
                    if (cases[j]==2)
                    {
                        int k = 0;
                        for (; k < starts.length; k++) {
                            if (starts[k] == j) {
                                fin[k] = "J";
                                break;
                            }
                        }
                        for (int l = starts[k]; l < ends[k]; l++)
                            cases[l] --;
                    }
                }
                res = Arrays.toString(fin).replaceAll("[\\[\\],]","").replaceAll(" ","");
            }
            System.out.println("Case #" + i + ": " + res );
        }
    }
}