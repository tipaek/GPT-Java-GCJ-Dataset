import java.util.*;
import java.io.*;
import java.lang.*;
class Solution
{
    public static void main(String args[])
    {
        int t,n,r,a[][],k,ro,c,cc,cr;
        Scanner kb=new Scanner(System.in);
        t=kb.nextInt();
        for(int i=1;i<=t;i++)
        {
            k=0;
            ro=0;
            c=0;
            n=kb.nextInt();
            a=new int [n][n];
            for(int j=0;j<n;j++)
            for(int m=0;m<n;m++)
            a[j][m]=kb.nextInt();
            for(int j=0;j<n;j++)
            {
                int x=0,y=0;
                for(int m=1;m<=n;m++)
                {
                    x=0;
                    y=0;
                    cr=0;
                    cc=0;
                    if(j==m-1)
                    k+=a[j][m-1];
                    for(int l=0;l<n;l++)
                    {
                        if(m==a[j][l])
                        cr++;
                        if(m==a[l][j])
                        cc++;
                    }
                    if(cr!=1)
                    x++;
                    if(cc!=1)
                    y++;
                }
                if(x!=0)
                    ro++;
                if(y!=0)
                    c++;
            }
            System.out.println("case#"+i+": "+k+" "+ro+" "+c);
        }
    }
}