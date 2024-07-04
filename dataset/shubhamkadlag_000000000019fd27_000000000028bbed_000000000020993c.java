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
	    while(t-- > 0) {
	        int n = fr.nextInt();
	        Integer[][] arr = new Integer[n][n];
	        int p = 0;
	        int r =0, c=0;
	        while(p < n) {
	            arr[p] = fr.nextIntArray();
	            HashSet<Integer> set = new HashSet<>();
	            for(int i : arr[p]) {
	                if(set.contains(i)){
	                    r++;
	                    break;
	                }
	                set.add(i);
	            }
	            p++;
	        }
	        p = 0;
	        while(p < n) {
	            int q = 0;
	            HashSet<Integer> set = new HashSet<>();
	            while(q < n) {
	                if(set.contains(arr[q][p])){
	                    c++;
	                    break;
	                }
	                set.add(arr[q][p]);
	                q++;
	            }
	            p++;
	        }
	        
	        int trace = 0;
	        p = 0;
	        while(p < n) {
	            trace += arr[p][p];
	            p++;
	        }
	        
	        System.out.println(trace +" "+r+" "+c);
	        
    	}
    }
}