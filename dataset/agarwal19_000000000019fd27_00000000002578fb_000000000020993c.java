/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{ 
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
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
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args)
    {
        FastReader sc=new FastReader();
        int T = sc.nextInt();
        int p=0;
        while(p++<T)
        {
            int n= sc.nextInt();
            int a[][]= new int[n][n];
            int row=0,col=0,dia=0;
            for(int i=0;i<n;i++)
            {
                HashMap<Integer,Integer> h= new HashMap<>();
                int flag=0;
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(h.containsKey(a[i][j]))
                    flag=1;
                    else
                    {
                        h.put(a[i][j],1);
                    }
                    
                    if(i==j)
                    dia+= a[i][j];
                }
                if(flag==1)
                row++;
            }
            for(int j=0;j<n;j++)
            {
                HashMap<Integer,Integer> h= new HashMap<>();
                int flag=0;
                for(int i=0;i<n;i++)
                {
                    if(h.containsKey(a[i][j]))
                    flag=1;
                    else
                    {
                        h.put(a[i][j],1);
                    }
                }
                if(flag==1)
                col++;
            }
            System.out.println("Case #"+p+":"+" "+dia+" "+row+" "+col);
        }
	}
}
