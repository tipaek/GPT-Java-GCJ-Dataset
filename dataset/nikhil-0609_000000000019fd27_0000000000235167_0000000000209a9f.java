import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args)	throws java.lang.Exception{
		FastReader sc = new FastReader();
		OutputStream out = new BufferedOutputStream ( System.out );
		int t = sc.nextInt();
        int c = 1;
		while(c <= t) {
		    String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            int count = 0;
            for(int i = 0; i<n; i++) {
                int k = s.charAt(i) - 48;
                if(k > count) {
                    while(count < k) {
                        sb.append("(");
                        count++;
                    }
                }else if(k < count) {
                    while(count > k) {
                        sb.append(")");
                        count--;
                    }
                }
                sb.append(Integer.toString(k));
            }
            while(count > 0 ){
                sb.append(")");
                count--;
            }
            System.out.println("Case #"+c+": "+sb);
            c++;
		}
	}
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
}