
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
			boolean b =false;
			int n = sc.nextInt();
			int k = sc.nextInt();
			int x = 0;
			for(int i =1;i<=n;i++)
				if(i*n==k)
				{
					x=i;
					b= true;
				}
			if(b)
			{
				System.out.println("Case #"+(m+1)+": POSSIBLE");
				for(int i =0;i<n;i++)
				{	
					int d = (x+i);
					if(d>n)
						d=1;
					for(int j=0;j<n;j++)
					{
						System.out.print(d+" ");
						d--;
						if(d==0)
							d=n;
					}
					System.out.println();
				}
			}
			else
				System.out.println("Case #"+m+": IMPOSSIBLE");
			
		}
	}
}


