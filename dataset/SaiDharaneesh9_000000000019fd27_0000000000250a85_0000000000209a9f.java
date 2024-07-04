import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[] ) {
        InputStream ip = System.in;
        OutputStream op = System.out;
        InputReader in = new InputReader(ip);
        PrintWriter out = new PrintWriter(op);
        Vestigium v=new Vestigium();
        int t=in.nextInt();
        for(int i=1;i<=t;i++)
        {
        v.solve(i,in,out);
        }
        out.close();
    }
    static class Vestigium
    {
        public void solve(int t,InputReader in,PrintWriter out)
        {
            String str=in.nextLine();
            String s="";
            int l=0,r=0;
                int e=0;
                if(str.length()==1)
                {
                    char c=str.charAt(0);
                    int a=Integer.parseInt(String.valueOf(c));
                    for(int i=0;i<a;i++)
                        s=s+'(';
                    s=s+c;
                    for(int i=0;i<a;i++)
                        s=s+')';
                }
                else
             for(int i=0;i<str.length()-1;i++)
             {
                char c=str.charAt(i);
                char b=str.charAt(i+1);
                int a=Integer.parseInt(String.valueOf(c));

                if(l<a||i==0)
                for(int j=0;j<a;j++)
                {
                    s=s+'(';
                    l++;
                }
                s=s+c;
                int d=Integer.parseInt(String.valueOf(b));
                if(a>d)
                for(int j=0;j<a-d;j++)
                {
                    s=s+')';
                    l--;
                }
                else
                    for(int j=0;j<d-a;j++)
                    {
                        s=s+'(';
                        l++;
                    }
                    e=a-d;
                if(i+1==str.length()-1)
                {
                    s=s+b;
                    for(int j=0;j<d;j++)
                    {
                        s=s+')';
                    }
                }

             }
              out.println("Case #"+t+": "+s);
        }
    }
   static class InputReader
   {
       BufferedReader br;
       StringTokenizer st;
       public InputReader(InputStream stream)
       {
           InputStream in;
           br=new BufferedReader(new InputStreamReader(stream),32768);
       }
       String next()
       {
           while(st==null||!st.hasMoreElements())
           {
               try
               {
                   st=new StringTokenizer(br.readLine());
               }
               catch(IOException e)
               {
                   e.printStackTrace();
               }
           }
           return st.nextToken();
       }
       int nextInt()
       {
           return Integer.parseInt(next());
       }
       long nextLong()
       {
        return Long.parseLong(next());
       }
       String nextLine()
       {
           String str="";
           try
           {
           str=br.readLine();
           }
           catch(IOException e)
           {
           e.printStackTrace();
           }
           return str;
       }
   }
}
