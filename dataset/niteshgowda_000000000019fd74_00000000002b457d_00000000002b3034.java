import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Solution{
	
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
		OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        
        int t = sc.nextInt();
        int cnt = 0;
        nt: while(t-- > 0)
        {	
        	cnt++;
        	int n = sc.nextInt();
        	String ar[] = new String[n];
        	int maxl = 0;
        	int maxi = -1;
        	for(int i = 0; i < n; i++)
        	{
        		ar[i] = sc.nextLine();
        		if(ar[i].length() > maxl)
        		{
        			maxl = Math.max(maxl,ar[i].length());
        			maxi = i;
        		}
        	}
        	
        	if(maxl == 1)
        	{
        		out.println("Case #"+cnt+": *");
        		continue nt;
        	}
        	for(int i = 0; i < n; i++)
        	{		
        		StringBuffer sb = new StringBuffer();
        		for(int j = 0; j < maxl-ar[i].length(); j++)
        		{
        			sb.append('*');
        		}
        		ar[i] = sb.toString()+ar[i];
        		//System.out.println(ar[i]);
        	}
        	
        	
        	int l = maxl-1;
        	boolean pos = true;
        	outer: while(l-- > 0)
        	{	
        		char ch = ar[maxi].charAt(l);
        		for(int i = 0; i < n; i++)
        		{	
        			if(i == maxi) continue;
        			if(ar[i].charAt(l) == '*') continue;
        			
        			if(ar[i].charAt(l) != ch)
        			{
        				pos = false;
        				break outer;
        			}
        		}
        	}
        	
        	
        	if(!pos)
        	out.println("Case #"+cnt+": *");
        	
        	else
        	{
        	out.print("Case #"+cnt+": ");	
        	
        	for(int i = 1; i < ar[maxi].length(); i++)
        	{
        		out.print(ar[maxi].charAt(i));
        	}
        	out.println();
        	}
        }
        out.close();
	}

}
