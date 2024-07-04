import java.util.*;
public class Solution
{
    public static void main(String[] b)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int x=1;
        while(x<=t)
        {    String ans="";
            int[] c=new int[1440];
           int[] j=new int[1440];
           int n=s.nextInt();
           for(int i=0;i<n;i++)
            {
                int t1=s.nextInt();
                int t2=s.nextInt();
                  int p;
                  for(p=t1;p<t2;p++)
                  {
                      if(c[p]==1)
                       break;
                  }
                  if(p==t2)
                   {ans=ans+"C";
                     for(int k=t1;k<t2;k++)
                       c[k]=1;
                   }
                  else
                  {
                    for(p=t1;p<t2;p++)
                  {
                      if(j[p]==1)
                       break;
                  }
                  if(p==t2)
                   {ans=ans+"J";
                     for(int k=t1;k<t2;k++)
                       j[k]=1;
                   }
                   else {
                       ans="IMPOSSIBLE";
                       break;
                   }
                  }
            }
            System.out.println("Case #"+x+": "+ans);
           x++; 
        }
    }
}    