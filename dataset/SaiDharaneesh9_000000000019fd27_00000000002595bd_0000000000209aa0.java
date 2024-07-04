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
        v.solve(t,i,in,out);
        }
        out.close();
    }
    static class Vestigium
    {
        public void solve(int p,int t,InputReader in,PrintWriter out)
        {

             int n=in.nextInt();
             int k=in.nextInt();
             String s="";
             if(k%n==0&&k/n==2)
             {
                 s=s+"POSSIBLE";
                 out.println("Case #"+t+": "+s);
                 int a[][]=new int[n][n];
                 for(int i=0;i<n;i++)
                     a[i][i]=k/n;
                 for(int i=0;i<n;i++)
                 {
                     for(int j=0;j<n;j++)
                     {
                         if(i!=j&&j>i)
                         {
                             if(a[i][j-1]==1)
                                 a[i][j]=n;
                             else
                           a[i][j]=a[i][i]-1;
                         }
                         if(i!=j&&j<i)
                         {
                             a[i][j]=n+1-a[j][i];
                         }
                         if(j!=n-1)
                         out.print(a[i][j]+" ");
                         else
                             out.print(a[i][j]);

                     }
                     if(t!=p||i!=n-1)
                     out.println();
                 }
             }
             else {
                 s = s + "IMPOSSIBLE";
                 if(t!=p)
                 out.println("Case #"+t+": "+s);
                 else
                     out.print("Case #"+t+": "+s);
             }
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
