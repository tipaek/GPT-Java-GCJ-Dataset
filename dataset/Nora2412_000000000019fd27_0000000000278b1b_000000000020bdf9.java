import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int p=1;p<=t;p++)
        {
            int n=sc.nextInt();
            int[][] a=new int[n][2];
            int[][] a1=new int[n][2];
            for(int q=0;q<n;q++)
            {
                int var1 = sc.nextInt();
                int var2 = sc.nextInt();
                a[q][0]=var1;
                a[q][1]=var2;
                a1[q][0]=var1;
                a1[q][1]=var2;
            }
            for(int j=0;j<n-1;j++)
            {
                for(int k=0;k<n-j-1;k++)
                {
                    if(a[k][0]>a[k+1][0])
                    {
                        int t1 = a[k][0];
                        a[k][0] = a[k+1][0];
                        a[k+1][0] = t1;
                        t1 = a[k][1];
                        a[k][1] = a[k+1][1];
                        a[k+1][1] = t1;
                    }
                    if(a[k][0]==a[k+1][0])
                    {
                        if(a[k][1]>a[k+1][1])
                        {
                            int t2 = a[k][1];
                            a[k][1] = a[k + 1][1];
                            a[k + 1][1] = t2;
                        }
                    }
                }
            }
            char[] so=new char[n];
            int lc=-1;
            int lf=-1;
            int flag=0;
            for(int j=0;j<n;j++)
            {
                int v=-1;
                for(int k=0;k<n;k++)
                {
                    if(a[j][0]==a1[k][0] && a[j][1]==a1[k][1])
                    {
                        a1[k][0]=-1;
                        a1[k][1]=-1;
                        v=k;
                        break;
                    }
                }
                if(a[j][0]>=lc)
                {
                    so[v]='C';
                    lc=a[j][1];
                }
                else if(a[j][0]>=lf)
                {
                    so[v]='J';
                    lf=a[j][1];
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            String s= new String(so);
            if(flag==0)
                System.out.println("Case #"+p+": "+s);
            else
                System.out.println("Case #"+p+": IMPOSSIBLE");
        }
    }
}