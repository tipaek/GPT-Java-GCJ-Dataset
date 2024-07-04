import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Parent
{
    public String name;
    public int endTime;
    Parent(String n, int e)
    {
        name = n;
        endTime = e;
    }
}

class ParentComparator implements Comparator<Parent>{
    public int compare(Parent s1, Parent s2) {
        if (s1.endTime > s2.endTime)
            return 1;
        else if (s1.endTime < s2.endTime)
            return -1;
        return 0;
    }
}

public class Solution {

    public static void FindSequence(int [] start, int []end, int t, HashMap<Integer, PriorityQueue<Integer>> map)
    {
        Arrays.sort(start);
        Arrays.sort(end);
        PriorityQueue<Parent> availQ = new PriorityQueue<Parent>( new ParentComparator());
        PriorityQueue<Parent> usedQ = new PriorityQueue<Parent>(new ParentComparator());
        availQ.add(new Parent("C",Integer.MAX_VALUE));
        availQ.add(new Parent("J",Integer.MAX_VALUE));
        StringBuilder  result = new StringBuilder();
        int startPtr=0, endPtr=0;
        boolean imp = false;
        while(startPtr < start.length)
        {
            if(start[startPtr] < end[endPtr])
            {
                if(availQ.isEmpty())
                {
                    imp = true;
                    break;
                }
                else
                {
                    Parent next = availQ.remove();
                    int startTime = start[startPtr];
                    PriorityQueue<Integer> lst = map.get(startTime);
                    next.endTime = lst.poll(); //remove the first entry if multiple entries
                    usedQ.add(next);
                    result.append(next.name);                    
                }
                startPtr++;
            }
            else
            {
                Parent sendBack = usedQ.remove();
                availQ.add(sendBack);
                endPtr++;
            }
        }

        if(imp)
            System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
        else
            System.out.println("Case #" + t + ": " + result.toString());
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int NoOftest = in.nextInt();
        for (int t = 1; t <= NoOftest; ++t) {
            int row = in.nextInt();
            int[]start = new int[row];
            int[]end = new int[row];
            HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int i = 0; i < row; ++i)
            {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
                if(map.containsKey(start[i])) {
                    PriorityQueue<Integer> lst = map.get(start[i]);
                    lst.add(end[i]);
                    map.put(start[i],lst);
                }
                else
                {
                    PriorityQueue<Integer> p = new PriorityQueue<Integer>();
                    p.add(end[i]);
                    map.put(start[i],p);
                }
            }
            FindSequence(start,end, t, map);
        }
    }
}