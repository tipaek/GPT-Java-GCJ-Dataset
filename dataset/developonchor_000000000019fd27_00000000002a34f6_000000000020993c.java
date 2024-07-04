
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		int V = 0;

		int current =0;
	
		int rc = 0;
		int rr = 0;
		boolean duplicate = false;
		 
	    try {

	    	String output=null;
    		
	    	
    		InputStreamReader isr = new InputStreamReader( System.in );
    		
    		
	 
    		BufferedReader stdin = new BufferedReader( isr );
    		
    		String input = stdin.readLine();
    		
    		Set<Integer> testSet = new HashSet<Integer>();
    		
    		
    		int T = Integer.parseInt(input);
	        
	       
	             for(int j = 1; j <= T; j++)
	             {
	            	 input = stdin.readLine();
	            	 
	     			 int N = Integer.parseInt(input);
	     			
	            	 int[][] matrix = new int[N][N];
	            	 V = 0;
	            	 rc = 0;
	         		 rr = 0;
	         		
	         		 
		             for(int r = 0; r< N; r++)
		             {
		            	
		            	
		            	 duplicate = false;
		            	
		            	 input = stdin.readLine();
		            	 Scanner sc = new Scanner(input);
		            	 testSet.clear();
		            	 for(int c = 0; c< N; c++)
			             {
		            		 current= sc.nextInt();
		            		
		 
		            		 V+=(r==c)?current:0;
		            		 
		            		 matrix[r][c]=current;
		            		 
		        
		            		 duplicate = !testSet.add(current) | duplicate;
		            		
		            		 
			             }
			             
		            	 sc.close();
		            	
		            	 
		            	 if(duplicate){
		            		 
		            		 rr++;
		            	 }
		            	 
		            	
		            	 
		            	
		            	
		       
		            	 
		             }
	            	 
		             
		             for(int c = 0; c< N; c++)
		             {
		            	
		            	
		            	 duplicate = false;
		            	 testSet.clear();
		            	 
		            	 for(int r = 0; r< N; r++)
			             {
		            		 current= matrix[r][c];
		            		
		            		 duplicate = !testSet.add(current) | duplicate;
			             }
			             
		            	
		            	 
		            	 if(duplicate){
		            		 
		            		 rc++;
		            	 }
		            	 
		             }
		             
		             System.out.println("Case #"+j+": " +V +" "+rr+ " "+rc);
		             System.out.flush();
	             }
	            
	             
	   
	        
	        
	    } 
	    catch (Exception e) {
	    	
	    	System.out.println("I'll be back! ;)");
	    }
	}

}

