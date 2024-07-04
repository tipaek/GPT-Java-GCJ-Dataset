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
            ArrayList <Integer> cStart = new ArrayList<>();
            ArrayList <Integer> cEnd = new ArrayList<>();
            ArrayList <Integer> jStart = new ArrayList<>();
            ArrayList <Integer> jEnd = new ArrayList<>();
            String res = "";
            for (int j = 0; j < n; j++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                boolean work = true;
                for (int k = 0; k < cStart.size(); k++)
                {
                    if (cStart.get(k) < s && cEnd.get(k) > s || cStart.get(k) < e && cEnd.get(k) > e) {
                        work = false;
                        break;
                    }
                }
                if (work)
                {
                    cStart.add(s);
                    cEnd.add(e);
                    res += "C";
                    continue;
                }
                work = true;
                for (int k = 0; k < jStart.size(); k++)
                {
                    if (jStart.get(k) < s && jEnd.get(k) > s || jStart.get(k) < e && jEnd.get(k) > e) {
                        work = false;
                        break;
                    }
                }
                if (work)
                {
                    jStart.add(s);
                    jEnd.add(e);
                    res += "J";
                }
                else
                {
                    res = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + res );
        }
    }
}