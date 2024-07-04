
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    static class FastReader{ 
     
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
	   
	     FastReader sc=new FastReader();
	     int t = sc.nextInt();
	     PrintWriter out = new PrintWriter(System.out);
	    for(int tcase = 1; tcase <= t; tcase++){
            String s = sc.nextLine();
            StringBuilder final_s = new StringBuilder();
            int left_p = 0;
            for(int i = 0; i < s.length(); i++){
	            int n = s.charAt(i)-'0';
	            while(left_p < n){
	                final_s = final_s.append('(');
	                left_p++;
	            }
	            while(left_p > n){
	                final_s = final_s.append(')');
	                left_p--;
	            }
	            
	            final_s = final_s.append(s.charAt(i));
            }
            // out.println(left_p);
            while(left_p--> 0){
	                final_s = final_s.append(')');
	               // left_p--;
	        }
	        String str = final_s.toString();
            out.println("Case #"+tcase+": "+str);         
	    }out.flush();
	}
}
