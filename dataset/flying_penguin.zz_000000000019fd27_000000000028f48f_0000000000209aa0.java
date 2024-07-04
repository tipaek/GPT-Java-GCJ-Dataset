
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
				
		    	
		    	int[] t4 = {16, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		    	int[] t5 = {5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25};
		    	
		    	String res = "IMPOSSIBLE";
		    	if(N==2){
		    		if(K==2 || K==4) res = "POSSIBLE"; }
		    	if(N==3){
		    		if(K==3 || K==6 || K==9) res = "POSSIBLE"; }
		    	if(N==4){
		    		for(int i:t4){
		    			if(K==i) {res = "POSSIBLE"; break;}}}
	    		if(N==5){
		    		for(int i:t5){
		    			if(K==i) {res = "POSSIBLE"; break;}}}
		    
		    	
		    	
		    	System.out.println("Case #"+t+ ": "+res );
		      
		    }

	}

	
	
	
}
