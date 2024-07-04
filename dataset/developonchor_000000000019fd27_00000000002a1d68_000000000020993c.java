
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		int V = 0;
		int max = 0;
		int min = 0;
		int product = 0;
		int sum = 0;
		int current =0;
		int fact=0;
		int tot=0;
		
		int rc = 0;
		int rr = 0;
		int ones = 0;
		 
	    try {

	    	String output=null;
    		
    		InputStreamReader isr = new InputStreamReader( System.in );
    		
	 
    		BufferedReader stdin = new BufferedReader( isr );
    		
    		String input = stdin.readLine();
    		
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
		            	
		            	 max = 0;
		            	 min = N;
		            	 ones = 0;
		            	 product = 1;
		            	 sum = 0;
		            	 input = stdin.readLine();
		            	 Scanner sc = new Scanner(input);
		         		 
		            	 for(int c = 0; c< N; c++)
			             {
		            		 current= sc.nextInt();
		            		 max = current>max?current:max;
		            		 min = current<min?current:min;
		            		 
		            		 product*=current;
		            		 sum+=current;
		            		 
		            		 
		            		 V+=(r==c)?current:0;
		            		 
		            		 matrix[r][c]=current;
		            		 
		            		 
		            		 if(current==1)ones++;
		            		
		            		 
			             }
			             
		            	 sc.close();
		            	 
		            	 fact = 1;
		            	 for (int i = 2; i <= N; i++) {
		            	        fact = fact * i;
		            	 }
		            	 
		            	 tot = 0;
		            	 for (int i = 1; i <= N; i++) {
		            		 tot = tot + i;
		            	 }
		            	 
		            	 if(product!=fact || sum!=tot || max!=N || min >1 || ones!=1){
		            		 
		            		 rr++;
		            	 }
		            	 
		            	
		            	 
		            	
		            	
		       
		            	 
		             }
	            	 
		             
		             for(int c = 0; c< N; c++)
		             {
		            	
		            	 max = 0;
		            	 min = N;
		            	 ones = 0;
		            	 product = 1;
		            	 sum = 0;
		            	 for(int r = 0; r< N; r++)
			             {
		            		 current= matrix[r][c];
		            		 max = current>max?current:max;
		            		 min = current<min?current:min;
		            		 product*=current;
		            		 sum+=current;
		            		 if(current==1)ones++;
			             }
			             
		            	 fact = 1;
		            	 for (int i = 2; i <= N; i++) {
		            	        fact = fact * i;
		            	 }
		            	 
		            	 tot = 0;
		            	 for (int i = 1; i <= N; i++) {
		            		 tot = tot + i;
		            	 }
		            	 
		            	 if(product!=fact || sum!=tot || max!=N || min >1 || ones!=1){
		            		 
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

