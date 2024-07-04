import java.util.*;

public class Solution
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        String res;
        ArrayList<String> results = new ArrayList<String>();
        int cases = scan.nextInt();
        
        for (int i = 0; i<cases; i++)
        {
            int activities = scan.nextInt();
            Activity [] a = new Activity[activities];
            ArrayList<Activity> Cameron = new ArrayList<Activity>();
            ArrayList<Activity> Jamie = new ArrayList<Activity>();
            boolean kid = false;
            res = "";
            for (int j = 0; j<activities; j++)
            {
                a[j] = new Activity(scan.nextInt(), scan.nextInt());
                if (j == 0)
                {
                    Cameron.add(a[j]);
                    res += "C";
                }
                else
                {
                    kid = true;
                    for (int k=0; k<Cameron.size(); k++)
                    {
                        if (overlap(a[j], Cameron.get(k)))
                        {
                            kid = false;
                            break;
                        }
                    }
                    
                    if (kid)
                    {
                        Cameron.add(a[j]);
                        res += "C";
                        continue;
                    }
                    
                    kid = true;
                    for (int k = 0; k<Jamie.size(); k++)
                    {
                        if (overlap(a[j], Jamie.get(k)))
                        {
                            kid = false;
                            break;
                        }
                    }
                    
                    if (kid)
                    {
                        Jamie.add(a[j]);
                        res += "J";
                    }
                    else
                    {
                        res = "IMPOSSIBLE";
                        break;
                    }
                }
            }
            results.add(res);
            Cameron.clear();
            Jamie.clear();
        }
        for (int i = 0; i<results.size(); i++)
        {
            System.out.println("Case #" + (i+1) + ": " + results.get(i));
        }
        results.clear();
    }
   
    public static boolean overlap (Activity a1, Activity a2)
    {
        if (a1.start <= a2.start && a1.end > a2.start)
            return true;
        if (a1.start < a2.end && a1.end >= a2.end)
            return true;
        if (a1.start >= a2.start && a1.end <= a2.end)
            return true;
        return false;
    }
}

class Activity
{
    int start;
    int end;
    
    public Activity (int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}