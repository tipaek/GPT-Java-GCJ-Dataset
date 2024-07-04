import java.io.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T,x,len,i,open; String s,str="";
        T=Integer.parseInt(in.readLine());
        for(int t=1;t<=T;t++)
        {
            s=in.readLine();
            len=s.length();
            open=0;
            for(i=0;i<len;i++)
            {
                x=s.charAt(i)-'0';
                while(open>x)
                {
                    str+=')';
                    open--;
                }
                while(open<x)
                {
                    str+='(';
                    open++;
                }
                str+=s.charAt(i);
            }
            while(open-->0)
                str+=')';
            System.out.println("Case #"+t+": "+str);
            str="";
        }
    }
}