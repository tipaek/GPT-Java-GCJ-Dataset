
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int N = in.nextInt();
		    	int K = in.nextInt();
		    	
		    	String res = "POSSIBLE";
		    	if(N==3){
		    		if(K%3 !=0) res = "IMPOSSIBLE";
		    	}
		    	if(N==2||N==4){
		    		if(K%2!=0) res = "IMPOSSIBLE";
		    	}
		    	if(N==5){
		    		if(K==6||K==7||K==21||K==23||K==24)
		    			res = "IMPOSSIBLE";
		    	}
				
		    	
		    	System.out.println("Case #"+T+ ": " +res);
		     } 
	}

	
	
	
}
