import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner r=new Scanner(System.in);
        int t=r.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=r.nextInt();
            int a[][]=new int[n][n];
            int c[]=new int[n];
            int tr=0,sumr=0,sumc=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=r.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                tr+=a[i][i];
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    c[j]=0;
                }
                for(int j=0;j<n;j++)
                {
                    if(c[a[i][j]-1]==1)
                    {
                        sumr++;
                        break;
                    }
                    else
                    {
                        c[a[i][j]-1]++;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    c[j]=0;
                }
                for(int j=0;j<n;j++)
                {
                    if(c[a[j][i]-1]==1)
                    {
                        sumc++;
                        break;
                    }
                    else
                    {
                        c[a[j][i]-1]++;
                    }
                }
            }
            System.out.println("Case #"+z+":"+" "+tr+" "+sumr+" "+sumc);
        }
    }
}