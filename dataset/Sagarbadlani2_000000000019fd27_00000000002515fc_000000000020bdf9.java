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
        String ans="";int f=0;int x=0;int y=0;
        for(int i=0;i<N;i++)
        {
            f=0;
            for(int k=0;k<N;k++)
            {
                if(p[i][0]>=c[k][1] || p[i][1]<=c[k][0])
                {
                    ans+="C";
                    c[x][0]=p[i][0];
                    c[x][1]=p[i][1];
                    x++;
                    break;
                }
                else if(p[i][0]>=j[k][1] || p[i][1]<=j[k][0])
                {
                    ans+="J";
                    j[y][0]=p[i][0];
                    j[y][1]=p[i][1];
                    y++;
                    break;
                }
                else 
                {
                    ans="IMPOSSIBLE";
                    f=1;
                    break;
                }
            }
            if(f==1)
            break;
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