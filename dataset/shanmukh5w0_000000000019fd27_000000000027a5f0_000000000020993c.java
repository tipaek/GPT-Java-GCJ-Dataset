import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,a[][],sum,flag,r,c;
        for(int i=0;i<t;i++)
        {
            n = sc.nextInt();
            a = new int[n][n];
            sum = 0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k] = sc.nextInt();
                    if(j==k)
                    {
                        sum = sum+a[j][k];
                    }
                }
            }
            r = 0;
            for(int j=0;j<n;j++)
            {
                int count[] = new int[n+1];
                for(int k=0;k<n;k++)
                {
                    count[a[j][k]]++;
                }
                for(int k=1;k<=n;k++)
                {
                    if(count[k]>1)
                    {
                        r++;
                        break;
                    }
                }
            }
            c = 0;
            for(int j=0;j<n;j++)
            {
                int count[] = new int[n+1];
                for(int k=0;k<n;k++)
                {
                    count[a[k][j]]++;
                }
                for(int k=1;k<=n;k++)
                {
                    if(count[k]>1)
                    {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
        }
    }
}