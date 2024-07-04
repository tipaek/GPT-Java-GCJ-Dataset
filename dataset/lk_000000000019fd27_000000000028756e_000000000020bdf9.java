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
            int[] c=new int[1441];
           int[] j=new int[1441];
           int n=s.nextInt();
           int[][] m=new int[n][2];
           for(int i=0;i<n;i++)
            {m[i][0]=s.nextInt();
              m[i][1]=s.nextInt();}
           for(int i=0;i<n;i++)
            {
                int t1=m[i][0];
                int t2=m[i][1];
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