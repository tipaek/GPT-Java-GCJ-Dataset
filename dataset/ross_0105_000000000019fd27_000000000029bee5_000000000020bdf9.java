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
    public static void main(String args[])
    {
        try
        {
            FastReader fr=new FastReader();
            int t=fr.nextInt();
            outer:
            for(int l=1;l<=t;l++)
            {
                System.out.print("Case #"+l+": ");
                int n=fr.nextInt();
                int s[]=new int[n];
                int e[]=new int[n];
                char ch[]=new char[n];
                for(int x=0;x<n;x++)
                {
                    s[x]=fr.nextInt();
                    e[x]=fr.nextInt();
                    ch[x]='0';
                }
                ch[0]='J';
                ch[1]='C';
                String str="JC";
                boolean im=false;
                for(int x=2;x<n;x++)
                {
                    boolean j=true;
                    boolean c=true;
                    for(int y=0;y<x;y++)
                    {
                        if(j)
                        {
                            if(ch[y]=='J')
                            {
                                int start=Math.max(s[x],s[y]);
                                int end=Math.min(e[x],e[y]);
                                if(start<end)
                                {
                                    j=false;
                                }
                            }
                        }
                        if(c)
                        {
                            if(ch[y]=='C')
                            {
                                int start=Math.max(s[x],s[y]);
                                int end=Math.min(e[x],e[y]);
                                if(start<end)
                                {
                                    c=false;
                                }
                            }
                        }
                    }
                    if(!j  && !c)
                    {
                        im=true;
                    }
                    else if(c)
                    {
                        ch[x]='C';
                        str+="C";
                    }
                    else if(j)
                    {
                        ch[x]='J';
                        str+="J";
                    }
                    
                }
                if(im)
                {
                    System.out.println("IMPOSSIBLE");
                }
                else if(!im)
                {
                    System.out.println(str);
                }
            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
    }
}