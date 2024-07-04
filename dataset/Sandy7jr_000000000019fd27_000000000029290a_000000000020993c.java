import java.util.*;
import java.io.*;
  public class Solution{
      
	
	  
	   public static BufferedReader ob;
	   
    public static void main (String args[])throws IOException{
  

	  ob = new BufferedReader(new InputStreamReader(System.in));
	  int t = Integer.parseInt(ob.readLine());
	    
	    int c = 1;
	    while(t --> 0) {
	    	int n = Integer.parseInt(ob.readLine());
	    	
	    	int [][]mat = new int[n][n];
	    	StringTokenizer st;
	    	
	    	for(int i = 0; i < n; i++) {
	             st = new StringTokenizer(ob.readLine());
	             for(int j = 0; j < n; j++) {
	            	 mat[i][j] = Integer.parseInt(st.nextToken());
	             }
	    	}
	    	
	    	int sum = 0;
	    	
	    	int row = 0;
	    	int col = 0;
	    	
	    	for(int i = 0; i < n; i++) {
	    		HashSet<Integer>set = new HashSet<>();
	    		
	    		for(int j = 0; j < n; j++) {
	    			
	    			set.add(mat[i][j]);
	    			if(i == j) {
	    				sum += mat[i][j];
	    			}
	    		}
	    			if(set.size() < n)row++;
	    		
	    	}
	    	
	    	for(int i = 0;i < n; i++) {
	    		HashSet<Integer>set = new HashSet<>();
	    		for(int j = 0; j < n; j++) {
	    			set.add(mat[j][i]);
	    		}
	    		if(set.size() < n)col++;
	    	}
	    	System.out.println("Case"+" "+"#"+c+":"+" "+sum+" "+row+" "+col);
	    	c++;
	    }
    }
  }
	    	
	    	
	    	
	    		