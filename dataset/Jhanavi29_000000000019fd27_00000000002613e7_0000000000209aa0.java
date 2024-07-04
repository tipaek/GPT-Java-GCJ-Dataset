import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int l=1;l<=t;l++)
        {
          int n=sc.nextInt();
          int k=sc.nextInt();
          boolean flag=false,flag1=false;
          int a[][]=new int[n][n];
          for(int i=0;i<n;i++)
          a[0][i]=i+1;
          for(int i=1;i<n;i++)
          {a[i]=left(a[i-1]);}
          for(int j=0;j<n;j++)
          {
              int tr=0,tl=0;
          for(int i=0;i<n;i++)
          {
              tr+=a[i][i];
              tl+=a[n-i-1][n-i-1];
          }
          if(tr==k)
          {
              flag=true;break;
          }
          if(tl==k)
          {
              flag1=true;break;
          }
          shiftrows(a);
          }
          if(flag)
          {
              System.out.println("Case #"+l+": POSSIBLE");
              for(int i=0;i<n;i++)
              {
                  for(int j=0;j<n;j++)
                  System.out.print(a[i][j]+" ");
                  System.out.println();
              }
          }
          else if(flag1)
          {
            System.out.println("Case #"+l+": POSSIBLE");
              for(int i=n-1;i>=0;i--)
              {
                  for(int j=0;j<n;j++)
                  System.out.print(a[j][i]+" ");
                  System.out.println();
              }  
          }
          else
          {
            System.out.println("Case #"+l+": IMPOSSIBLE");  
          }
        }
    }
    static int[] left(int a[])
    {
       int n=a.length;
        int b[]=new int[n];
        for(int i=0;i<n-1;i++)
        b[i]=a[i+1];
        b[n-1]=a[0];
        return b;
    }
    static void shiftrows(int a[][])
    {
        int n=a.length;
        int b[]=new int[n];
        b=a[0];
        int c[][]=new int[n][n];
        for(int i=0;i<n-1;i++)
        {
          c[i]=a[i+1];
        }
        for(int i=0;i<n;i++)
        c[n-1][i]=b[i];
        for(int i=0;i<n;i++)
        a[i]=c[i];
    }
}