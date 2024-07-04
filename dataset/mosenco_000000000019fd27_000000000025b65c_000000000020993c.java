  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
       
        
        
        int numbers=0;
		ArrayList<int[][]> matrixHolder = new ArrayList<int[][]>(); 
		ArrayList<Integer> trace = new ArrayList<Integer>(); 
		ArrayList<Integer> row = new ArrayList<Integer>(); 
		ArrayList<Integer> col = new ArrayList<Integer>(); 
		
		int dim;
		int tracenum;
		int rownum;
		int doppio;
		int n;
		int nn;
		int colnum;
		
		      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		      while (in.hasNextLine()) {
		        
		    	  numbers = in.nextInt();
		    	  
		    	 
		    	  for(int i=0; i<numbers; i++){
		    		  
		    		  
		    		  dim = in.nextInt();
		    		  matrixHolder.add(new int[dim][dim]);
		    		  
		    		  for(int x=0; x<dim; x++){
		    			  for(int y=0; y<dim; y++){
		    				  matrixHolder.get(i)[y][x] = in.nextInt();
		    			  }
		    		  }
		    		  
		    	  }
		      
		      }
      }}