import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        while(t-->0)
        {
            int r=0,c=0;
            k++;
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                int f=0;
                for(int j=0;j<n-1;j++)
                {
                    for(int l=j+1;l<n;l++)
                    {
                        if(a[i][j]==a[i][l])
                        {
                            f=1;
                            break;
                        }
                    }
                }
                if(f==1)
                {
                    r++;
                }
            }
            for(int i=0;i<n;i++)
            {
                int f=0;
                for(int j=0;j<n-1;j++)
                {
                    for(int l=j+1;l<n;l++)
                    {
                        if(a[j][i]==a[l][i])
                        {
                            f=1;
                            break;
                        }
                    }
                }
                if(f==1)
                {
                    c++;
                }
            }
            int sum = 0; 
            for (int i=0; i<n; i++)
            {
                sum +=a[i][i]; 
            }
            System.out.println("Case #"+k+": "+sum+" "+r+" "+c);
        }
    }
}