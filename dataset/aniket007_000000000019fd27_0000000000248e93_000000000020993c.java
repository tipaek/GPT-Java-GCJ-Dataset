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
            int a[][]=new int[n+1][n+1];
            int k=0,r=0,c=0;
            for(int j=0;j<n;j++)
            {
                for(int m=0;m<n;m++)
                a[j][m]=sc.nextInt();
                k=k+a[j][j];a[j][n]=0;a[n][j]=0;
            }
            for(int j=0;j<n;j++)
            {
                for(int m=0;m<n;m++)
                {
                    
                    for(int y=0;y<n;y++)
                    {
                        if(a[j][m]==a[j][y]&&(y!=m)&&a[j][m]>0)
                        {
                            a[j][n]++;
                        }
                    }
                    for(int y=0;y<n;y++)
                    {
                        if(a[m][j]==a[y][j]&&(y!=m)&&a[m][j]>0)
                        {
                            a[n][j]++;
                        }
                    }
                    
                }
                if(a[j][n]>0)
                r++;
                if(a[n][j]>0)
                c++;
            }
            System.out.println("Case #"+i+":"+" "+k+" "+r+" "+c);
            
        }
    }
}
        