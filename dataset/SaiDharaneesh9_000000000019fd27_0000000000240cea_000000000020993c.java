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
             int n=in.nextInt();
             int a[][]=new int[n][n];
             for(int i=0;i<n;i++)
             {
                for(int j=0;j<n;j++)
                {
                a[i][j]=in.nextInt();
                }
             }
             int sum=0;
              for(int i=0;i<n;i++)
              {
                sum+=a[i][i];
              }
              int r=0,c=0;
              for(int i=0;i<n;i++)
              {
                 for(int k=0;k<n;k++)
                 {
                   for(int j=k+1;j<n;j++)
                   {
                    if(a[i][k]==a[i][j])
                    {
                    r++;
                    j=n;
                    k=n;
                    }
                   }
                 }
              }
              for(int i=0;i<n;i++)
              {
                 for(int k=0;k<n;k++)
                 {
                   for(int j=k+1;j<n;j++)
                   {
                      if(a[k][i]==a[j][i])
                      {
                      c++;
                      j=n;
                      k=n;
                      }
                   }
                 }
              }
              out.println("Case #"+t+": "+sum+" "+r+" "+c);
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
