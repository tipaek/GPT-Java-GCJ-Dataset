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
            char s[]=bu.readLine().toCharArray();
            int i,j;
            String st="";
            sb.append("Case #"+v+": ");
            for(i=0;i<s.length;i++)
            {
                int n=s[i]-48;
                for(j=0;j<n;j++)   st+="(";
                st+=Integer.toString(n);
                for(j=0;j<n;j++)  st+=")";
            }
            while(st.contains(")(")) st=st.replace(")(","");
            sb.append(st+"\n");
        }
        System.out.print(sb);
    }
}
