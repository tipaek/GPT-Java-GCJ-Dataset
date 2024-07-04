import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int m=1;
        while(m<=t)
        {
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                    if(i==j)
                    sum=sum+arr[i][j];
                }
            }
            int count=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                   for(int k=0;k<j;k++)
                   {
                       if(arr[i][j]==arr[i][k])
                       count++;
                       break;
                   }
                }
            }
            int count2=0;
            for(int j=0;j<n;j++)
            {
                for(int i=0;i<n;i++)
                {
                    for(int k=0;k<i;k++)
                    {
                        if(arr[i][j]==arr[k][j])
                        count2++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+m+": "+sum+" "+count+" "+count2);
            m++;
        }
    }
}