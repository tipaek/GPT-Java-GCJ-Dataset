import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
	
	static class Pair
	{
		int r;
		int c;
		Pair(int r,int c)
		{
			this.r = r;
			this.c = c;
		}
		
		public int hashCode(){
	        //System.out.println("In hashcode");
	        int hashcode = 0;
	        hashcode = r*20;
	        hashcode += c*20;
	        return hashcode;
	    }
	     
	    public boolean equals(Object obj){
	        //System.out.println("In equals");
	        if (obj instanceof Pair) {
	            Pair pp = (Pair) obj;
	            return (pp.r == this.r && pp.c == this.c);
	        } else {
	            return false;
	        }
	    
	}
	}
	
	public static void main(String[] args) 
	{
		OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        
        int t = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int cnt = 0;
        outer: while(t-- > 0)
        {	
        	cnt--;
        	for(int i = -5; i <= 5; i++)
        	{
        		for(int j = -5; j <= 5; j++)
        		{
        			out.println(i+" "+j);
        			out.flush();
        			
        			String s = sc.nextLine();
        			if(s.equals("CENTER"))
        			{
        				continue outer;
        			}
        			
        			
        		}
        	}
        	
        	
        	//out.println("Case #"+cnt+": ");
        }
        out.close();
	}

}
