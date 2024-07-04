import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int sum=0;
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
                if(i==j)
                sum=sum+arr[i][j];
                }
                
            }
            int count=0;
            int count1=0;
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n-1;j++)
               {
                   for(int l=j+1;l<n;l++)
                   {
                       if(arr[i][j]==arr[i][l])
                       {
                           count++;
                           break;
                       }
                   }
                   if(count>0)
                   break;
               }
           }
            for(int j=0;j<n;j++)
           {
               for(int i=0;i<n-1;i++)
               {
                   for(int l=i+1;l<n;l++)
                   {
                       if(arr[i][j]==arr[l][j])
                       {
                           count1++;
                           break;
                       }
                   }
                   if(count1>0)
                   break;
               }
           }
           System.out.println("case #"+k+": "+sum+" "+count+" "+count1);
           
            
        }
    }
}