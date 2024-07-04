
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
	   // try{
	        FastReader sc=new FastReader();
	     int t = sc.nextInt();
	     PrintWriter out = new PrintWriter(System.out);
	     for(int tcase = 1; tcase <= t; tcase++){
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0 ; j < n; j++)
                    arr[i][j] = sc.nextInt();
	        int dia_sum = 0;
	        int col_count = 0;
	        int row_count = 0;
	        HashSet<Integer> hs = new HashSet<>();
	        for(int i = 0, j = 0; i < n && j <n; i++,j++){
	            dia_sum += arr[i][j];
	            hs.add(arr[i][j]);
	            boolean flag = true;
	            for(int k = j+1; k < n; k++){
	                if(hs.contains(arr[i][k])){
	                    row_count++;
	                    flag = false;
	                    break;
	                }
	                hs.add(arr[i][k]);
	            }
	            if(flag){
	                for(int k = j-1; k >= 0; k--){
    	                if(hs.contains(arr[i][k])){
    	                    row_count++;
    	                    break;
    	                }
    	                hs.add(arr[i][k]);
	                }
	            }
	            hs.clear();
	            hs.add(arr[i][j]);
	            flag = true;
	            for(int k = i+1; k < n; k++){
	                if(hs.contains(arr[k][j])){
	                    col_count++;
	                    flag = false;
	                    break;
	                }
	                hs.add(arr[k][j]);
	            }
	            if(flag){
	                for(int k = i-1; k >= 0; k--){
    	                if(hs.contains(arr[k][j])){
    	                    col_count++;
    	                    break;
    	                }
    	                hs.add(arr[k][j]);
	                }
	            }
	            hs.clear();
	        }
            out.println("Case #"+tcase+": "+dia_sum+" "+row_count+" "+col_count);         
	    }out.flush();
	   // }
	   // catch(Exception  e){}
	     
	}
}
