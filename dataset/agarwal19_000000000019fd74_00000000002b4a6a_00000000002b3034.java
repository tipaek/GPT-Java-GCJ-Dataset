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
        int z=1;
        while(t-->0)
        {
        	int n= sc.nextInt();
        	ArrayList<String> ar= new ArrayList<>();
        	int j=0;
        	int L=0;
        	for(int i=0;i<n;i++)
        	{
        	    ar.add(sc.nextLine());
        	    int l= ar.get(i).length();
        	    if(l>L)
        	    {
        	        L=l;
        	        j=i;
        	    }
        	}
        	String p= ar.get(j).substring(1);
        	int flag1=0;
        	for(int i=0;i<n;i++)
        	{
        	    if(i!=j)
        	    {
        	        String s= ar.get(i);
        	        int m=L-2;
        	        int flag=0;
        	        for(int k=s.length()-1; k>0; k--)
        	        {
        	            if(s.charAt(k)== p.charAt(m))
        	            {
        	                m--;
        	            }
        	            else
        	            {
        	                flag=1;
        	                break;
        	            }
        	        }
        	        if(flag==1)
        	        {
        	            flag1=1;
        	            break;
        	        }
        	    }
        	}
        	if(flag1==1)
     	    System.out.println("Case #"+z+": *");
     	    else
     	    System.out.println("Case #"+z+": "+p);
     	    
     	    z++;
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
