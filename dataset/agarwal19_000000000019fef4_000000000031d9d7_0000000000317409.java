/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{   static class FastReader
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
     	int t= sc.nextInt();
     	int p=1;
        while(t-->0)
        {
            String s1= sc.nextLine();
            String[] sp = s1.split("\\s+");
            int x= Integer.valueOf(sp[0]);
            int y= Integer.valueOf(sp[1]);
            String s= sp[2];
            int flag=0;
            for(int i=0;i<s.length();i++)
            {
                char c= s.charAt(i);
                if(c=='N')
                y++;
                if(c=='S')
                y--;
                if(c=='E')
                x++;
                if(c=='W')
                x--;
                
                int sum= Math.abs(x)+Math.abs(y);
                if(sum<=i+1)
                {
                    flag=i+1;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Case #"+p+": IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #"+p+": "+flag);
            }
            p++;
        }
	}
	static class Pair
	{
	    int x;
	    int y;
	    public Pair(int a, int b)
	    {
	        x=a;
	        y=b;
	    }
	}
}
