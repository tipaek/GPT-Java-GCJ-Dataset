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

            if(str[0]=='0')sb2.append(0);
            else sb2.append("(1");

            for(i=1;i<str.length;i++)
            {
                if(str[i-1]=='0')
                {
                    if(str[i]=='0') sb2.append(0);
                    else sb2.append("(1");
                }
                else
                {
                    if(str[i]=='0') sb2.append(")0");
                    else sb2.append(1);
                }
            }
            if(str[str.length-1]=='1')sb2.append(')');
            sb.append("Case #").append(++k).append(": ");
            sb.append(sb2).append("\n");
        }
        System.out.println(sb);
    }
}