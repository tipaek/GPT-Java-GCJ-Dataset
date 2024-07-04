import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
        int n=sc.nextInt();
        HashSet<Integer> c=new HashSet<Integer>();
         HashSet<Integer> j=new HashSet<Integer>();
        //  int a[]=new int [n];
        //  int b[]=new int [n];
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
         int i,k,flag=0;
         String str="";
        for(i=0;i<=1440;i++)
        {
            c.add(i);
            j.add(i);
        }
        for(i=0;i<n;i++)
        {
            a.add(sc.nextInt());
            b.add(sc.nextInt());
            
            
        }
        for(i=0;i<n;i++)
        {
            if(b.contains(a.get(i)))
            a.set(i,a.get(i)+1);
        }
      //  System.out.println(a);
        //   for(i=0;i<n;i++)
        //   {
        //       c.add(b[i]);
        //       j.add(b[i]);
        //   }
        for(i=0;i<n;i++)
        {
            int found=1;
            for(k=a.get(i);k<=b.get(i);k++)
            {
                if(!c.contains(k))
                {
                    found=0;
                    break;
                }
            }
            if(found==1)
            {
                for(k=a.get(i);k<=b.get(i);k++)
                c.remove(k);
                str+='c';
            }
            else
            {
                for(k=a.get(i);k<=b.get(i);k++)
                {
                    if(!j.contains(k))
                    {
                        flag=1;
                        str="IMPOSSIBLE";
                    }
                }
                if(flag==1)
                break;
                for(k=a.get(i);k<=b.get(i);k++)
                j.remove(k);
                str=str+'j';
            }
        }
        System.out.println("Case #"+x+":"+" "+str);
        
    }
    System.exit(0);
  }
}
        
        
        
        
        
        