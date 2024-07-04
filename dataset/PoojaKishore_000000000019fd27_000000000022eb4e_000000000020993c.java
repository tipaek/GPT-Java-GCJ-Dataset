import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
      int n,c,r,t;
      Scanner sc=new Scanner(System.in);
      n=sc.nextInt();
      int t1[]=new int[n+1];
      int row[]=new int[n+1];
      int col[]=new int[n+1];
      int x[][];
      int r1[];
      int c1[];
      for(int i=1;i<=n;i++)
      {t=0;
       c=0;
       r=0;
       int n2=sc.nextInt();
       x=new int[n2+1][n2+1];
       for(int j=1;j<=n2;j++)
       {
           for(int k=1;k<=n2;k++)
           {
               x[j][k]=sc.nextInt();
           }
       }
       
       for(int j=1;j<=n2;j++)
       {
           r1=new int[n2+1];
           c1=new int[n2+1];
           int f=0,f1=0;
           t=t+x[j][j];
           
           for(int k=1;k<=n2;k++)
           {
            r1[x[j][k]]++;
            c1[x[k][j]]++;
            if(r1[x[j][k]]>1)
            {
                f=1;
            }
            if(c1[x[k][j]]>1)
            {
                f1=1;
            }
               
           }
           if(f==1)
           {
               r++;
           }
           
           if(f1==1)
           {
               c++;
           }
       }
       t1[i]=t;
       row[i]=r;
       col[i]=c;
       
      }
      for(int i=1;i<=n;i++)
      {
          System.out.println("Case #"+i+": "+t1[i]+" "+row[i]+" "+col[i]);
      }
     
    }
}