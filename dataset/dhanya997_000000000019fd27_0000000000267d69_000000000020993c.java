import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t,n,i,j,p;
        t=sc.nextInt();
        for(p=0;p<t;p++)
        {
            n=sc.nextInt();
            int arr[][] = new int[n][n];
            int trace=0,nrow=0,ncol=0;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    if(i==j)
                    {
                        trace=trace+arr[i][j];
                    }
                }
            }
            for(i=0;i<n;i++)
            {
                Set<Integer> row = new HashSet<Integer>();
                for(j=0;j<n;j++)
                {
                    if(row.contains(arr[i][j]))
                    {
                        nrow++;
                        break;
                    }
                    else
                    {
                        row.add(arr[i][j]);
                    }
                }
            }
            for(i=0;i<n;i++)
            {
                Set<Integer> col = new HashSet<Integer>();
                for(j=0;j<n;j++)
                {
                    if(col.contains(arr[j][i]))
                    {
                        ncol++;
                        break;
                    }
                    else
                    {
                        col.add(arr[j][i]);
                    }
                }
            }
            System.out.println("Case #"+(p+1)+": "+trace+" "+nrow+" "+ncol);
        }
    }
}