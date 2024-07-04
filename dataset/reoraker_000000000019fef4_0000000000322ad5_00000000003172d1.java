import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.print("Case #"+test+": ");
            test++;
            int n=in.nextInt();
            int d=in.nextInt();
            long[] a=new long[n];
            for(int i=0;i<n;i++)
                a[i]=in.nextLong();
            TreeSet<Long> set=new TreeSet<>();
            HashMap<Long,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                set.add(a[i]);
                if(map.containsKey(a[i]))
                {
                    int c=map.get(a[i]);
                    c++;
                    map.put(a[i],c);
                }
                else
                    map.put(a[i],1);
            }
            if(d==1)
                System.out.println(0);
            else if(d==2)
            {
                if(set.size()<n)
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            else
            {
                int max=0;
                for(long i: set)
                    max=Math.max(map.get(i),max);
                if(max==3)
                    System.out.println(0);
                else if(max==2)
                {
                    long tmp=Integer.MAX_VALUE;
                    for(long i: set)
                    {
                        if(map.get(i)==2)
                        {
                            tmp=i;
                            break;
                        }
                    }
                    if(set.higher(tmp)!=null)
                        System.out.println(1);
                    else
                    {
                        boolean flag=false;
                        for(long i: set)
                        {
                            if(((i&1)==0) && set.contains(i>>1))
                            {
                                flag=true;
                                break;
                            }
                        }
                        if(flag==true)
                            System.out.println(1);
                        else
                            System.out.println(2);
                    }
                }
                else
                {
                    boolean flag=false;
                    for(long i: set)
                    {
                        if(((i&1)==0) && set.contains(i>>1))
                        {
                            flag=true;
                            break;
                        }
                    }
                    if(flag==true)
                        System.out.println(1);
                    else
                        System.out.println(2);
                }
            }
        }
    }
}
                

            
