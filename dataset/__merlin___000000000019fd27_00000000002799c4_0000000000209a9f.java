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
            int i;
            String st="";
            sb.append("Case #"+v+": ");
            for(i=0;i<s.length;i++)
                if(s[i]=='1') st+=s[i];
                else
                {
                    if(st.length()>0) sb.append("("+st+")"+s[i]);
                    else sb.append(s[i]);
                    st="";
                }
            if(st.length()>0)
            sb.append("("+st+")");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
