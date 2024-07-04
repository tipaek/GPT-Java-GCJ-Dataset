import java.util.*;
import java.io.*;
import java.lang.Math;
public class Solution
{   public static void main(String[] args)
{
    Scanner in=new Scanner(System.in);
    int i,j,n,m,a,b;
        a=in.nextInt();
        for(i=0;i<a;i++)
        {
            n=in.nextInt();
            int c=0,k=0,r=0;
            int a[][]=new int[n][n];
           int x[][]=new int[n][n];
           int y[][]=new int[n][n];
            for(j=0;j<n;j++)
            {
                for(m=0;m<n;m++)
                {
                    a[j][m]=in.nextInt();
                    if(j==m)
                    {
                        k+=a[j][m];
                    }
                    x[a[j][m]-1][j]++;
                }
                for( m=0;m<n;m++)
                {
                    if(x[m][j]>1)
                    {
                        r++;
                        break;
                    }
                }
            }
            for(m=0;m<n;m++)
            {
                for(j=0;j<n;j++)
                {
                    y[a[j][m]-1][m]++;
                   
                }
               
            }
            for(j=0;j<n;j++)
            {
                for(m=0;m<n;m++)
                {
                    if(y[m][j]>1)
                    {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
}
}
