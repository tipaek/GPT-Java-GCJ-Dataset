import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = Integer.parseInt(in.nextLine()); 
	    
	    for (int i = 1; i <= t; ++i) {
	    	String n = in.nextLine();
	    	int count = 0, br = 0;
	    	StringBuilder str = new StringBuilder();
	    	int c;
	    	for(int j = 0; j < n.length(); ++j) {
	    		c = Character.getNumericValue(n.charAt(j));
	    		
	    		while(br < c) {
	    			str.append("(");
	    			br++;
	    		}
	    		
	    		while(br > c) {
	    			str.append(")");
	    			br--;
	    		}
	    		
	    		str.append(c);
	    	}
	    	
	    	while (br > 0) {
	    		str.append(")");
    			br--;
	    	}
	    	
	    	System.out.println("Case #" + i + ": " + str.toString());
	    }
	}

}
