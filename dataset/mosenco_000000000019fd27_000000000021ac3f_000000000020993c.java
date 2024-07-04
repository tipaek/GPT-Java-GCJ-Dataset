import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) throws FileNotFoundException{
       
        
        
        int numbers=0;
		ArrayList<int[][]> matrixHolder = new ArrayList<int[][]>(); 
		ArrayList<Integer> trace = new ArrayList<Integer>(); 
		ArrayList<Integer> row = new ArrayList<Integer>(); 
		ArrayList<Integer> col = new ArrayList<Integer>(); 
		
			
		      
		      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		      while (in.hasNextLine()) {
		        
		    	  numbers = in.nextInt();
		    	  
		    	 
		    	  for(int i=0; i<numbers; i++){
		    		  
		    		  
		    		  int dim = in.nextInt();
		    		  matrixHolder.add(new int[dim][dim]);
		    		  
		    		  for(int x=0; x<dim; x++){
		    			  for(int y=0; y<dim; y++){
		    				  matrixHolder.get(i)[y][x] = in.nextInt();
		    			  }
		    		  }
		    		  
		    	  }
		      
		      }
		      
		      
		      for(int i=0; i<numbers; i++){
		    	  int tracenum = 0;
	    		  for(int a=0; a<matrixHolder.get(i)[0].length; a++){
	    			  tracenum += matrixHolder.get(i)[a][a];
	    		  }
		    	  
		    	  trace.add(tracenum);
		      }
		      
		      for(int i=0; i<numbers; i++){
		    	  int n = matrixHolder.get(i)[0].length;
		    	  int rownum=0;
		    	 
		    	  for(int a=0; a<matrixHolder.get(i)[0].length; a++){
		    		  int doppio = 0;
			    	  for(int x = 0; x < n-1; x++ ){
				    	  for (int y = x + 1; y <  n; y++){
				    		  if (matrixHolder.get(i)[a][x] == matrixHolder.get(i)[a][y]){
				    			 
				    			  doppio = 1;
				    			  
				    		  }
				    		 
				    	  }
			    	  }
			    	  if(doppio == 1){
			    		  rownum++;
			    	  }
			    	  
		    	  }
		    	  row.add(rownum);
		    	  
		    	  
		    	  int nn = matrixHolder.get(i)[0].length;
		    	  int colnum=0;
		    	  
		    	  for(int a=0; a<matrixHolder.get(i)[0].length; a++){
		    		  int doppioo=0;
			    	  for(int x = 0; x < nn-2; x++ ){
				    	  for (int y = x + 1; y <  nn-1; y++){
				    		  if (matrixHolder.get(i)[x][a] == matrixHolder.get(i)[y][a]){
				    			  doppioo=1;
				    		  }
				    	  }
			    	  }
			    	  if(doppioo==1){
			    		  colnum++;
			    	  }
		    	  }
		    	  
		    	  col.add(colnum);

		      }
		      
		     
		      
		      for(int i=0; i<numbers; i++){
		    	  System.out.print("Case #"+(i+1)+": "+trace.get(i)+" "+col.get(i)+" "+row.get(i));
		    	  System.out.println("");
		      }
		      
		      
		      in.close();
		     
      }
    }