import java.util.*;
class Solution
{
    public static void main(String args[])
    {  
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[][]=new int[n][n];
            if(k%n==0)
            {
                int p=n/k;
                int b[]=new int[n-1];
                for(int j=1;j<p;j++)
                {
                    b[j]=j;
                }
                for(int j=p+1;j<=n;j++)
                {
                    b[j]=j;
                }
                for(int j=0;j<n;j++)
                {
                    a[j][j]=p;
                }
                for(int j=0;j<n;j++ )
                {
                    for(int m=0;m<n;m++)
                    {
                        if(j==m)
                            continue;
                           a[j][m]=b[m]; 
                    }
                }
                System.out.println("Case #"+i+": POSSIBLE");
                System.out.print(a[0][0]);
                for(int j=0;j<n;j++)
                {
                    for(int m=1;m<n;m++)
                    {
                       System.out.print(" "+a[j][m]);
                    }
                    System.out.println();
                }
            }
            else
            {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
              
                    
        }
    }
}
    