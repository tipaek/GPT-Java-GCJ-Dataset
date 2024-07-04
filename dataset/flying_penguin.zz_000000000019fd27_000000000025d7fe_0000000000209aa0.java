
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
				if(K%N!=0) res = "IMPOSSIBLE";
		    	
		    	System.out.println("Case #"+T+ ": " +res);
		     } 
	}

	
	
	
}
