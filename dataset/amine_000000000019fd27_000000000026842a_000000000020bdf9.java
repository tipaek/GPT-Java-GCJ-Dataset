import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
	    int testNumber = in.nextInt();
	    
	    for (int k = 1; k <= testNumber; ++k) {
	        
	    	int count = in.nextInt();
	    	StringBuilder response = new StringBuilder();

	    	int startJ = 0;
	    	int startC = 0;
	    	int endJ = 0;
	    	int endC = 0;
	    	
	    	for (int i = 0 ; i < count ; i ++) {
	    		
	    		int start = in.nextInt();
	    		int end = in.nextInt();
	    		
	    		if (start == endJ || end == startJ) {
	    			
	    			response.append("J");
	    			endJ = end;
	    			startJ = start;
	    			
	    		} else if (start == endC || end == startC) {
	    			
	    			response.append("C");
	    			startC = start;
	    			endC = end;
	    			
	    		} else if (start > endJ || end < startJ) {
	    		
	    			response.append("J");
	    			endJ = end;
	    			startJ = start;
	    		
	    		} else if (start > endC || end < startC) {
	    			
	    			response.append("C");
	    			startC = start;
	    			endC = end;
	    			
	    		} else {
	    			
	    			response = new StringBuilder("IMPOSSIBLE");
	    			break;
	    		
	    		}
	    		
	    	}
	        
	    	System.out.println("Case #" + k + ": " + response.toString());
	      
	    }
	}
}