import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution
{
    private static int t;
    private static int task;
    private static Scanner in;

    public static void main(String[] args) throws Exception
    {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        t = in.nextInt();
        for (int i = 1; i <= t; ++i)
        {
            task = i;
            solve();
        }
    }

    private static void solve()
    {
        int n = in.nextInt();
        List<Activity> al = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            al.add(new Activity(in.nextInt(), in.nextInt(), i));
        }
        Collections.sort(al);
        int js = -1;
        int je = -1;
        int cs = -1;
        int ce = -1;
        String res = "";
        char[] rc = new char[n];
        for (Activity a : al)
        {
            if (cs < 0 || ce <= a.start)
            {
                cs = a.start;
                ce = a.end;
                rc[a.pos] = 'C';
            } else if (js < 0 || je <= a.start)
            {
                js = a.start;
                je = a.end;
                rc[a.pos] = 'J';
            } else
            {
                res = "IMPOSSIBLE";
                break;
            }
        }
        if (res.length() == 0)
            res = new String(rc);

        System.out.println("Case #" + task + ": " + res);
    }

}

class Activity implements Comparable<Activity>
{
    public Activity(int start, int end, int pos)
    {
        super();
        this.start = start;
        this.end = end;
        this.pos = pos;
    }

    int start;
    int end;
    int pos;

    @Override
    public int compareTo(Activity o)
    {
        if (start - o.start != 0)
            return start - o.start;
        if (end - o.end != 0)
            return end - o.end;
        return 0;
    }
}
