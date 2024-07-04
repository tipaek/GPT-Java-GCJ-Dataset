import java.util.*;
public class Vestigium
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t;
        t=sc.nextInt();
        int n,trace,cr,cc,flagger;
        for(int l=1;l<=t;l++)
        {
           n=sc.nextInt();
           
           int[][]arr=new int[n][n];
           int[]flag=new int[n];
           trace=0;cr=0;cc=0;
           for(int i=0;i<n;i++)
           {
               flagger=0;
               for(int j=0;j<n;j++)
               {
                   arr[i][j]=sc.nextInt();
                   
                   if(i==j)
                   {
                       trace+=arr[i][j];
                   }
                   if(arr[i][j]<=n)
                   {
                       flag[arr[i][j]-1]=1;
                   }
                   
               }
               for(int k=0;k<n;k++)
               {
                   if(flag[k]==1)
                   flag[k]=0;
                   else
                   flagger=1;
               }
               if(flagger==1)
               cr++;
           }
           for(int i=0;i<n;i++)
           {
               flagger=0;
               for(int j=0;j<n;j++)
               {
                 if(arr[j][i]<=n)
                   {
                       flag[arr[j][i]-1]=1;
                   }
                   
               }
               for(int k=0;k<n;k++)
               {
                   if(flag[k]==1)
                   flag[k]=0;
                   else
                   flagger=1;
                   
               }
               if(flagger==1)
               cc++;
           }
           System.out.println(trace+" "+cr+" "+cc);
           
        }
    }
}