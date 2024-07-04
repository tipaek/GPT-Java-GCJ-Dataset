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
        	int r= sc.nextInt();
        	int c= sc.nextInt();
        	int a[][]= new int[r][c];
        	int sum=0;
        	for(int i=0;i<r;i++)
        	{
        	    for(int j=0;j<c;j++)
        	    {
        	        a[i][j]= sc.nextInt();
        	        sum+= a[i][j];
        	    }
        	}
        	ArrayList<Pair> ar= new ArrayList<>();
        	int flag=0;
        	for(int i=0;i<r;i++)
        	{
        	    for(int j=0;j<c;j++)
        	    {
        	        int sum1=0;
        	        int d=0;
        	        if(i>0)
        	        {
        	        sum1+= a[i-1][j];
        	        d++;
        	        }
        	        if(i<r-1)
        	        {
        	            sum1+= a[i+1][j];
        	            d++;
        	        }
        	        if(j>0)
        	        {
        	        sum1+= a[i][j-1];
        	        d++;}
        	        if(j<c-1)
        	        {
        	            sum1+= a[i][j+1];
        	            d++;
        	        }
        	        
        	        if((float)a[i][j]< (float)sum1/(float)d)
        	        {
        	            ar.add(new Pair(i,j));
        	        }
        	    }
        	}
        	if(ar.size()==0)
        	{
        	    flag=1;
        	}
        	else
        	{
        	    for(int i=0;i<ar.size();i++)
        	    {
        	        Pair p= ar.get(i);
        	        a[p.x][p.y]= -1;
        	    }
        	}
        	while(flag!=1)
        	{
        	    ar= new ArrayList<>();
        	    for(int i=0;i<r;i++)
        	    {
        	        for(int j=0;j<c;j++)
        	        {
        	            if(a[i][j]!=-1)
        	            {
        	                sum+=a[i][j];
        	                int d=0;
        	                int sum1=0;
        	                int i1= i+1;
        	                while(i1<r)
        	                {
        	                    if(a[i1][j]!=-1)
        	                    break;
        	                    i1++;
        	                }
        	                if(i1!=r)
        	                {
        	                    sum1+= a[i1][j];
        	                    d++;
        	                }
        	                i1=i-1;
        	                while(i1>=0)
        	                {
        	                    if(a[i1][j]!=-1)
        	                    break;
        	                    i1--;
        	                }
        	                if(i1>=0)
        	                {
        	                    sum1+= a[i1][j];
        	                    d++;
        	                }
        	                i1= j+1;
        	                while(i1<c)
        	                {
        	                    if(a[i][i1]!=-1)
        	                    break;
        	                    i1++;
        	                }
        	                if(i1!=c)
        	                {
        	                    sum1+= a[i][i1];
        	                    d++;
        	                }
        	                i1=j-1;
        	                while(i1>=0)
        	                {
        	                    if(a[i][i1]!=-1)
        	                    break;
        	                    i1--;
        	                }
        	                if(i1>=0)
        	                {
        	                    sum1+= a[i][i1];
        	                    d++;
        	                }
        	                
        	                if((float)a[i][j] < (float)sum1/(float)d)
        	                ar.add(new Pair(i,j));
        	            }
        	        }
        	    }
        	    if(ar.size()==0)
        	    flag=1;
        	    else
        	    {
        	       for(int i=0;i<ar.size();i++)
        	      {
        	        Pair p= ar.get(i);
        	        a[p.x][p.y]= -1;
        	      }
        	    }
        	}
     	    System.out.println("Case #"+z+": "+sum);
     	    
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
