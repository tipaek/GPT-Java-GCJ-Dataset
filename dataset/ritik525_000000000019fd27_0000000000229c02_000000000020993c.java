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
                int flag=0;
               for(int j=0;j<n;j++)
               {
                   for(int l=j+1;l<n;l++)
                   {
                       if(arr[i][j]==arr[i][l])
                       {
                           count++;
                           flag=1;
                           break;
                       }
                   }
                   if(flag==1)
                   break;
               }
           }
            for(int j=0;j<n;j++)
           {
               int flag1=0;
               for(int i=0;i<n;i++)
               {
                   for(int l=i+1;l<n;l++)
                   {
                       if(arr[i][j]==arr[l][j])
                       {
                           count1++;
                           flag1=1;
                           break;
                       }
                   }
                   if(flag1==1)
                   break;
               }
           }
           System.out.println("Case #"+k+": "+sum+" "+count+" "+count1);
           
            
        }
    }
}