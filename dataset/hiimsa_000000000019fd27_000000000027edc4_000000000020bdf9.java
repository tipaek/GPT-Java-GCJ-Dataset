import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Interval
{
    public int startTime;
    public int endTime;
    Interval( int s,int e)
    {
        startTime = s;
        endTime = e;
    }
}

class Par
{
    public Interval interval;
    public String name;
    Par( String n , Interval in)
    {
        name = n;
        interval = in;
    }
}

class IntervalComp implements Comparator<Interval>{
    public int compare(Interval s1, Interval s2) {
        if (s1.startTime > s2.startTime)
            return 1;
        else if (s1.startTime < s2.startTime)
            return -1;
        return 0;
    }
}

public class Solution {

    public static void FindSequence(Interval []intervals, int t)
    {
        StringBuilder result= new StringBuilder();
        Arrays.sort(intervals,new IntervalComp());
        Par ParentC = new Par("C",intervals[0]);
        Par ParentJ = new Par("J", new Interval(0,0));
        result.append("C");
        for(int i=1; i < intervals.length; i++)
        {
            Interval interval = intervals[i];
            if(interval.startTime >= ParentC.interval.endTime )
            {
                ParentC.interval = interval;
                result.append("C");
            }
            else if(interval.startTime >= ParentJ.interval.endTime)
            {
                ParentJ.interval = interval;
                result.append("J");
            }
            else
            {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + t + ": " + result.toString());
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int NoOftest = in.nextInt();
        for (int t = 1; t <= NoOftest; ++t) {
            int size = in.nextInt();
            Interval []interval = new Interval[size];
            for (int i = 0; i < size; ++i)
            {
                interval[i] = new Interval(in.nextInt(),in.nextInt());
            }
            FindSequence(interval, t);
        }
    }
}

