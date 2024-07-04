//created by Whiplash99
import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N,k=0;

        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        while(T-->0)
        {
            char str[]=br.readLine().trim().toCharArray();
            sb2.setLength(0);

            int prev=0;
            for(i=0;i<str.length;i++)
            {
                int cur=str[i]-'0';
                int diff=Math.abs(prev-cur);

                if(prev<cur) for(int j=0;j<diff;j++) sb2.append('(');
                else for(int j=0;j<diff;j++) sb2.append(')');

                sb2.append(cur);
                prev=cur;
            }

            int cur=0;
            int diff=Math.abs(prev-cur);
            if(prev<cur) for(int j=0;j<diff;j++) sb2.append('(');
            else for(int j=0;j<diff;j++) sb2.append(')');

            sb.append("Case #").append(++k).append(": ");
            sb.append(sb2).append("\n");
        }
        System.out.println(sb);
    }
}