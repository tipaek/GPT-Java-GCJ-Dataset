import java.util.*;
import java.lang.*;
import java.io.*;

class Main 
{ 
	static class MyReader
	{
	    BufferedReader br;
	    StringTokenizer st;
	    
	    public MyReader()
	    {
	        br=new BufferedReader(new InputStreamReader(System.in));
	    }
	    
	    String next()
	    {
	        while(st==null || !st.hasMoreElements())
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
	    
	    double nextDouble()
	    {
	        return Double.parseDouble(next());
	    }
	    
	    String nextLine()
	    {
	        String str=" ";
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
	
	public static void main(String[] args)
	{
	    MyReader s=new MyReader();
	    int t=s.nextInt();
	    for(int w=1;w<=t;w++)
		{
		    int n=s.nextInt();
		    int [][]a=new int[n][n];
		    int [][]b=new int[n][n];
		    int i,j,c=0,d=0;
		    long sum=0;
		    for(i=0;i<n;i++)
		    for(j=0;j<n;j++)
		    {
		        a[i][j]=s.nextInt();
		        b[j][i]=a[i][j];
		        if(i==j)
		        sum+=a[i][j];
		    }
		    for(i=0;i<n;i++)
		   {
		       Arrays.sort(a[i]);
		       for(j=0;j<n-1;j++)
		       {
		         if(a[i][j]==a[i][j+1])
		         {
		             ++c;
		             break;
		         }
		       }
		   }
		   for(i=0;i<n;i++)
		   {
		       Arrays.sort(b[i]);
		       for(j=0;j<n-1;j++)
		       {
		         if(b[i][j]==b[i][j+1])
		         {
		             ++d;
		             break;
		         }
		       }
		   }
		   System.out.println("Case #"+w+": "+sum+" "+c+ " "+d);
		}
	}
}
