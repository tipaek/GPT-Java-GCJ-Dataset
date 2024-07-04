
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
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
  
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader scn=new FastReader();
		int t=scn.nextInt();
		StringBuilder an=new StringBuilder();
		int f=1;
		while(f<=t)
		{
		    String s=scn.next();
		    char ch=s.charAt(0);
		     StringBuilder sb=new StringBuilder();
		    int x=ch-48;
		    if(s.length()==1)
		    {
		    	for(int i=0;i<x;i++)
		    	sb.append('(');
		    sb.append(ch);
		    for(int i=0;i<x;i++)
		    	sb.append(')');
		    }
		    int c=1;
		   
		    for(int i=1;i<s.length();i++)
		    {
		        if(ch!=s.charAt(i))
		        {
		            for(int j=0;j<x;j++)
		            {
		                sb.append('(');
		            }
		            for(int k=0;k<c;k++)
		            sb.append(ch);
		             for(int k=0;k<x;k++)
		            {
		                sb.append(')');
		            }
		            ch=s.charAt(i);
		            x=ch-48;
		             if(i==s.length()-1)
		            {
		                 for(int h=0;h<x;h++)
		            {
		                sb.append('(');
		            }
		            for(int j=0;j<c;j++)
		            sb.append(s.charAt(i));
		             for(int k=0;k<x;k++)
		            {
		                sb.append(')');
		            }
		            }
		            c=1;
		        }
		        else
		        {
		            c++;
		            x=s.charAt(i)-48;
		            // System.out.print("heloo");
		            if(i==s.length()-1)
		            {
		                 for(int h=0;h<x;h++)
		            {
		                sb.append('(');
		            }
		            for(int j=0;j<c;j++)
		            sb.append(s.charAt(i));
		             for(int k=0;k<x;k++)
		            {
		                sb.append(')');
		            }
		            }
		        }
		    }
		  //  System.out.println();
		    an.append("Case #"+f+": "+sb+"\n");
		    f++;
		    
		}
		System.out.println(an);
	}
}