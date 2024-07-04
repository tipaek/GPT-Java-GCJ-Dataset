import java.util.Scanner;
class Main
{
    public static void Main(String[] args)
    {
       Scanner s=new Scanner(System.in);
       int t=s.nextInt();
       for(int i=0;i<t;i++)
       {
           int sum=0,r=0,c=0;
           int n=s.nextInt();
           int[][] a=new int[n][n];
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   a[j][k]=s.nextInt();
               }
           }
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   if(j==k)
                   {
                       sum=sum+a[j][k];
                   }
               }
           }
           /*for(int j=0;j<n;j++)
           {
               for(int k=1;k<n;k++)
               {
                   if(a[j][k]==a[j][k-1])
                   {
                       r++;
                       break;
                   }
               }
           }
           for(int j=1;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   if(a[j][k]==a[j-1][k])
                   {
                       c++;
                       break;
                   }
               }
           }*/
       }
    }
}