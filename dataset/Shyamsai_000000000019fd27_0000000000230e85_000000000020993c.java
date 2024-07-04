import java.util.*;
class Main
{
  public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     int t=sc.nextInt();
     for(int k=0;k<t;k++)
     {
        n=sc.nextInt();
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<n;j++)
            a[i][j]=sc.nextInt();
        }
        sum=0;
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<n;j++)
          {
             sum=sum+a[i][i];
          }
        }
        System.out.println(sum);
     }
  }
}