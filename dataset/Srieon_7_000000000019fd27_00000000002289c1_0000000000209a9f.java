import java.io.*;
import java.util.*;

class FastReader 
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

class Solution {

	public static void main(String args[])throws IOException
	{	
		FastReader sc = new FastReader();
		final int t = sc.nextInt();
		for(int m=0;m<t;m++ )
		{
			String s = sc.nextLine();
			int op=0;
			String d="";
			for(int i =0;i<s.length();i++)
			{
				int c = Integer.parseInt(""+s.charAt(i));
				if(c>op)
				{
					while((c-op)!=0)
					{
						d = d+"(";
						op++;
					}
					
				}
				else if(c<op)
				{
					for(int j =0;j<(op-c);j++)
					{
						d=d+")";
					}
					
					op=c;
				}
				d=d+c;
				if(i==(s.length()-1)&&c!=0)
				{
					
					for(int j =0;j<op;j++)
						d=d+")";
					
					break;
				}
				else if(i==(s.length()-1)&&c==0)
				{
					d=d+0;
				}
				
			}
			System.out.println(d);
			
		}
	}
}


