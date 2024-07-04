import java.io.*;
import java.util.*;
class FastReader
{
    BufferedReader br;
    StringTokenizer st;
    FastReader()
    {
        br=new BufferedReader(new InputStreamReader(System.in));
    }
    String next()throws IOException
    {
        while(st==null ||!st.hasMoreTokens())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    int nextInt()throws IOException
    {
        return Integer.parseInt(next());
    }
}

class Solution
{
    public static void main(String args[])throws IOException
    {
        try 
        {
            FastReader fr=new FastReader();
            int t=fr.nextInt();
            for(int l=1;l<=t;l++)
            {
                String str=fr.next();
                String ans=str;
                String s="";
                for(int x=0;x<ans.length();x++)
                {
                    char ch=ans.charAt(x);
                    if(ch=='(')
                    {
                        s=s+ch;
                    }
                    else if(ch==')' && s.length()>0)
                    {
                        s=s.substring(0,s.length()-1);
                    }
                    else if(Character.isDigit(ch))
                    {
                        int c=Integer.parseInt(ch+"");
                        while(s.length()>c)
                        {
                            s=s.substring(0,s.length()-1);
                            ans=ans.substring(0,x)+")"+ans.substring(x);
                        }
                        while(s.length()<c)
                        {
                            s=s+"(";
                            ans=ans.substring(0,x)+"("+ans.substring(x);
                            x++;
                        }
                    }
                }
                while(s.length()>0)
                {
                    s=s.substring(0,s.length()-1);
                    ans=ans+")";
                }
                System.out.println("Case #"+l+": "+ans);
            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
    }
}