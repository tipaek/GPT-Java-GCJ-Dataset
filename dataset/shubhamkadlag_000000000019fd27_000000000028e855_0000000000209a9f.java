import java.io.*;
import java.util.*;


public class Solution {
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
        
        String[] nextStrArray() {
            return nextLine().split("\\s+");
        }
        
        Integer[] nextIntArray() {
            String[] arr = nextStrArray();
            Integer[] iarr = new Integer[arr.length];
            for(int i = 0 ; i < iarr.length ; i++) {
                iarr[i] = Integer.valueOf(arr[i]);
            }
            return iarr;
        }
    }
    
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int tt = t;
	    while(t-- > 0) {
	        String s = fr.next();
	        StringBuilder sb = new StringBuilder();
	        int o = 0;
            for(char c : s.toCharArray()) {
                int num = c - '0';
                if(num < o) {
                    int nc = o - num;
                    while(nc-- >0) {
                        sb.append(')');
                        o--;
                    }
                }
                else if(num > o) {
                    int no = num - o;
                    while(no-- >0) {
                        sb.append('(');
                        o++;
                    }
                }
                sb.append(num);
            }
            while(o-- >0) {
                sb.append(')');
            }
	        System.out.println("Case #"+(tt-t)+": "+sb.toString());
	        
    	}
    }
}