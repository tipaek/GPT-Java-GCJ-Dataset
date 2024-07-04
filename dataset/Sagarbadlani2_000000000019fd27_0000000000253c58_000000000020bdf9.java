import java.util.*;
import java.io.*;
class Solution
{
    public static void solve(Scanner sc,int test)
    {
        int N;
        N=sc.nextInt();
        int p[][]=new int[N][2];
        for(int i=0;i<N;i++)
        {
            p[i][0]=sc.nextInt();
            p[i][1]=sc.nextInt();
        }
        int c[][]=new int[N][2];
        int j[][]=new int[N][2];
        String ans="";int f=0;int x=0;int y=0;int count=0;
        for(int i=0;i<N;i++)
        {
            count=0;f=0;
            for(int k=0;k<N;k++)
            {
                if(p[i][0]>=c[k][1] || p[i][1]<=c[k][0])
                {
                    count++;
                }
            }
            if(count==N)
            {
                ans+="C";
                c[x][0]=p[i][0];
                c[x][1]=p[i][1];
                x++;
                f=1;
            }
            if(f==1)
            continue;
            f=0;count=0;
            for(int k=0;k<N;k++)
            {
                if(p[i][0]>=j[k][1] || p[i][1]<=j[k][0])
                {
                    count++;
                }
            }
            if(count==N)
            {
                ans+="J";
                j[y][0]=p[i][0];
                j[y][1]=p[i][1];
                y++;
                f=1;
            }
            if(f==0)
            {
                ans="IMPOSSIBLE";break;
            }
        }
        System.out.println("Case #"+test+": "+ans);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++)
        {
            solve(sc,i+1);
        }
    }
}