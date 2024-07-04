import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int xo=1;xo<=test;xo++)
        {
            int n=sc.nextInt();
            int d=sc.nextInt();ArrayList<Long>r=new ArrayList<Long>();
            for(int x=0;x<n;x++)
            {r.add(sc.nextLong());}
            int steps=d-1;
            for(int x=0;x<r.size();x++)
            {
                if(r.contains(r.get(x)*2))
                {steps=1;}
                if(Collections.max(r)>r.get(x)&&Collections.frequency(r,r.get(x))==d-1)
                {steps=1;}
                if(Collections.frequency(r,r.get(x))>=d)
                {steps=0;break;}
            }
            System.out.println("Case #"+xo+": "+steps);
        }
        sc.close();
    }
}
