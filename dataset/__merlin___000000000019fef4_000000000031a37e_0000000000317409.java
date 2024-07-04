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
            String s[]=bu.readLine().split(" ");
            int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]),i,time[][]=new int[s[2].length()][2];
            char d[]=s[2].toCharArray();
            for(i=0;i<d.length;i++)
            {
                if(d[i]=='S') y--;
                if(d[i]=='N') y++;
                if(d[i]=='E') x++;
                if(d[i]=='W') x--;
                time[i][0]=Math.abs(x)+Math.abs(y);
                time[i][1]=i+1;
            }
            int min=Integer.MAX_VALUE;
            for(i=0;i<d.length;i++)
                if(time[i][0]<=time[i][1])
                if(time[i][1]<min) min=time[i][1];

            if(min==Integer.MAX_VALUE) sb.append("Case #"+v+": IMPOSSIBLE\n");
            else sb.append("Case #"+v+": "+min+"\n");
        }
        System.out.print(sb);
    }
}
