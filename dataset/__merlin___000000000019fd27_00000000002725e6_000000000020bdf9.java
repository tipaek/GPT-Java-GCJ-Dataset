import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine()),v;
        StringBuilder sb=new StringBuilder();
        for(v=1;v<=t;v++)
        {
            int n=Integer.parseInt(bu.readLine());
            int i,j,a[][]=new int[n][2],used[]=new int[n],check[]=new int[24*60*60];
            char c[]=new char[n];
            int flag=0;
            for(i=0;i<n;i++)
            {
                String s[]=bu.readLine().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
                for(j=a[i][0];j<a[i][1];j++)
                {check[j]++;
                if(check[j]>2) {flag=1; break;}}
                //if(flag==1) break;
            }

            if(flag==1) {sb.append("Case #"+v+": IMPOSSIBLE\n"); continue;}
            int ja=a[0][0],jb=a[0][1];
            c[0]='J';
            for(i=1;i<n;i++)
            {
                if(a[i][0]>=jb || a[i][1]<=ja) c[i]='J';
                else c[i]='C';
            }
            sb.append("Case #"+v+": ");
            for(i=0;i<n;i++)
                sb.append(c[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
