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
        int j=0;
        while(j++<T)
        {
            String s= sc.nextLine();
            String ans= "";
            for(int i=0;i<s.length();i++)
            {
                char c= s.charAt(i);
                int x= (int)(c-'0');
                if(i==0)
                {
                    while(x-->0)
                    ans+= '(' ;
                }
                else
                {
                    x= x- (int)(s.charAt(i-1)-'0');
                    if(x>0)
                    {
                        while(x-->0)
                        ans+= '(';
                    }
                    else
                    {
                        while(x++<0)
                        ans+= ')';
                    }
                }
                ans+= c;
                if(i==s.length()-1)
                {
                    x= (c-'0');
                    while(x-->0)
                    ans+=')';
                }
            }
            
            System.out.println("Case #"+j+":"+" "+ans);
        }
	}
	static class Pair{
	    int x;
	    int y;
	    int z;
	    public Pair(int a, int b, int c)
	    {
	        x=a;
	        y=b;
	        z=c;
	    }
	}
}
