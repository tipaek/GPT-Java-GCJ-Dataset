import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int res[][]=new int[t][3];
        for(int c=1;c<=t;c++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                }
            }
            res[c-1][0]=trace;
            int rflag=0;
            int cflag=0;
            for(int i=0;i<n;i++)
            {
                rflag=0;
                for(int j=1;j<n;j++)
                {
                    for(int k=0;k<j;k++)
                    {
                        if(a[i][j]==a[i][k]&&j!=k)
                            rflag=1;
                    }
                }
                if(rflag==1)
                    res[c-1][1]++;
            }
            
            for(int i=0;i<n;i++)
            {
                cflag=0;
                for(int j=1;j<n;j++)
                {
                    for(int k=0;k<j;k++)
                    {
                        if(a[j][i]==a[k][i]&&j!=k)
                            cflag=1;
                    }
                }
                if(cflag==1)
                    res[c-1][2]++;
            }
            
        }
        for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+(i+1)+": "+res[i][0]+" "+res[i][1]+" "+res[i][2]);
        }
    }
}