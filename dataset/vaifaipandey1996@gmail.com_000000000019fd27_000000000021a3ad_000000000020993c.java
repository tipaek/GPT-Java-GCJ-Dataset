import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int sum=0,r=0,c=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    {
                        sum+=a[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                int row[]=new int[n];
                int col[]=new int[n];
                for(int j=0;j<n;j++)
                {
                    if(row[a[i][j]-1]==1)
                    {
                        r++;break;
                    }
                    row[a[i][j]-1]=1;
                }
                for(int j=0;j<n;j++)
                {
                    if(col[a[j][i]-1]==1)
                    {
                        c++;break;
                    }
                    col[a[j][i]-1]=1;
                }
            }
            System.out.println("Case #"+z+": "+sum+" "+r+" "+c);
        }
    }
}