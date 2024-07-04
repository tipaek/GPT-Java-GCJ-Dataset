
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int S = in.nextInt();
		    	int R = in.nextInt();
		    	//String[] words = new String[len];
		    	//for(int i=0; i<len;i++) words[i] = in.next();
		    	//1 2 4 8 16 32... 
		    	//-1 -2 -4 -16 -32
		    	int a = R*(S-1);
		    	int b = R-1;
		    	System.out.println("Case #"+t+": "+(R-1)*(S-1));
		    	for(int i=0; i<R-1;i++){
		    		for(int j=0; j<S-1;j++){
		    			System.out.println(a+" "+b);
		    			a--;
		    		}
		    		b--; 
		    	}
		    	
		    	
		    	//System.out.println("Case #"+t+": IMPOSSIBLE");
		      
		    }

	}

}
