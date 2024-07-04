import java.util.*;
import java.io.*;

public class Solution 
{
    static class Activity implements Comparable<Activity>
    {
        Integer startTime, endTime;
        char sched;

        Activity(int start, int end)
        {
            startTime = start;
            endTime = end;
        }

        public int compareTo(Activity a)
        {
            return startTime.compareTo(a.startTime);
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        for(int t=1; t<=tc; t++)
        {
            int n = Integer.parseInt(in.readLine());
            String[] data;
            ArrayList<Activity> acts = new ArrayList<Activity>(n);
            ArrayList<Activity> actsO = new ArrayList<Activity>(n);
            for(int i=0; i<n; i++)
            {
                data = in.readLine().split(" ");
                acts.add(new Activity(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                actsO.add(acts.get(i));
            }
            Collections.sort(acts);
            Activity c = new Activity(0,0);
            Activity j = new Activity(0,0);
            boolean imp = false;
            for(Activity a: acts)
            {
                if (a.startTime>=c.endTime)
                {
                    a.sched = 'C';
                    c = a;
                }
                else if (a.startTime>=j.endTime)
                {
                    a.sched = 'J';
                    j = a;
                }
                else
                {
                    imp = true;
                    break;
                }
            }
            if (imp) System.out.println("Case #"+t+": "+"IMPOSSIBLE");
            else
            {
                String res = "";
                for(Activity a: actsO) res+=a.sched+"";
                System.out.println("Case #"+t+": "+res);
            }
        }
    }
}