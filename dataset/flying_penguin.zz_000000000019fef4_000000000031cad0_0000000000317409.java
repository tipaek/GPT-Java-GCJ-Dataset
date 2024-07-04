
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int X = in.nextInt();
		    	int Y = in.nextInt();
		    	String path = in.next();
		    	//String[] words = new String[len];
		    	//System.out.println(path);
		    	boolean get = false;
		    	for(int i=0;i<path.length();i++){
		    		switch(path.charAt(i)){
		    			case 'E':
		    				X++;break;
		    			case 'W':
		    				X--;break;
		    			case 'N':
		    				Y++;break;
		    			case 'S':
		    				Y--;break;
		    		}
		    		if(Math.abs(X)+Math.abs(Y)<=i+1){
		    			System.out.println("Case #"+t+": "+(i+1));
		    			get = true; break;
		    		}
		    	}
		    	if(!get)
		    		System.out.println("Case #"+t+": IMPOSSIBLE");
		    	
		    	//System.out.println("Case #"+t+": IMPOSSIBLE");
		      
		    }

	}

}
