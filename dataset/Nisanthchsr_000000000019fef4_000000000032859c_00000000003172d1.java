import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=scan.nextInt();
            int d=scan.nextInt();
            HashMap<Long,Integer> map=new HashMap<Long,Integer>();
            for(int j=0;j<n;j++)
            {
                Long a=scan.nextLong();
                if(map.containsKey(a))
                {
                     int b=map.get(a);
                    b++;
                    map.replace(a,b);
                }
                else
                {
                map.put(a,0);
                }
            }
            int c=minSlices(map,n,d);
            System.out.println("Case #"+i+": "+c);
        }
    }
    static int minSlices(HashMap<Long,Integer> map,int n,int d)
    {
        if(map.containsValue(d))
        {
            return 0;
        }
        LinkedList<Integer> l=new LinkedList<Integer>(map.values());
        int max=0;
        for(int i=0;i<l.size();i++)
        {
            if(l.get(i)>max)
            max=l.get(i);
        }
        if(max>=d)
        return 0;
        int diff=d-max;
        return diff-1;
    }
}