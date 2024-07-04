import java.util.*;
public class Solution
{
    static int n;
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int c=1;
            n=sc.nextInt();
            int k=sc.nextInt();
            int a[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int m=0;m<n;m++)
                {
                    a[j][m]=c++;
                    if(c>n) c=1;
                }
                c=c-1;
            }
            if(arrange(a,k))
            System.out.println("Case #"+i+": "+"POSSIBLE");
            else
            System.out.println("Case #"+i+": "+"IMPOSSIBLE");
        }
    }
    static boolean check(int a[][],int k)
    {
        int c=0,t=0;
        for(int i=0;i<n;i++)
        {c=c+a[i][i];t+=a[i][n-i-1];}
        if(c==k||t==k)
        return true;
        return false;
    }
    static boolean arrange(int a[][],int k)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==i)
                continue;
                int d[]=a[i];
                a[i]=a[j];
                a[j]=d;
                if(check(a,k))
                return true;
                d=a[i];
                a[i]=a[j];
                a[j]=d;
                
            }
        }
        return false;
    }
}
