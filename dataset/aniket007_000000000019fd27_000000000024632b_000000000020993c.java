import java.util.*;
public class Solution 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int k=0,r=0,c=0;
            for(int j=0;j<n;j++)
            {
                for(int m=0;m<n;m++)
                a[j][m]=sc.nextInt();
                k=k+a[j][j];
            }
            for(int j=0;j<n;j++)
            {
                for(int m=0;m<n;m++)
                {
                    int v=c,h=r;
                    for(int y=0;y<n;y++)
                    {
                        if(a[j][m]==a[j][y]&&(y!=m))
                        {
                            r++;break;
                        }
                    }
                    for(int y=0;y<n;y++)
                    {
                        if(a[m][j]==a[y][j]&&(y!=m))
                        {
                            c++;break;
                        }
                    }
                    if(r!=h||c!=v)
                    break;
                }
            }
            System.out.println("Case #"+i+":"+" "+k+" "+r+" "+c);
            
        }
    }
}