import java.util.Scanner;

public class Solution {

	public static void main(String[] args)  {
		
		Scanner in = new Scanner(System.in);
		
	    int testNumber = in.nextInt();

	    for (int k = 1; k <= testNumber; k++) {
	        
	    	String s = in.next();
	    	StringBuilder result = new StringBuilder();
    		int depth = 0;
	    	
	    	for (int i = 0 ; i < s.length() ; i++) {
	    		
    			int t = Character.getNumericValue(s.charAt(i));

    			if (t > depth) {
    				
    				while (t > depth) {
    					result.append("(");
    					depth ++;
    				}
    				
    			} else if (t < depth) {
    				

    				while (t < depth) {
    					result.append(")");
    					depth --;
    				}
    				
    			}

				result.append(t);
				
	    	}
	    	
	    	while(depth > 0) {
				result.append(")");
				depth --;
				
	    	}
	      
	    	System.out.println("Case #" + k + ": " + result.toString());
	      
	    }
		
	    
	}

}
