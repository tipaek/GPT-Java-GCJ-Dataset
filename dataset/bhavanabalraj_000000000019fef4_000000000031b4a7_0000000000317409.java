import java.util.*;
import java.io.*;
    
class Solution {
    public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
        	int x = in.nextInt(), y = in.nextInt();
        	String path = in.next();
        	int len = path.length();
        	
        	boolean poss = true;
        	int time = 0, var = 0;
        	for(; time<=len; time++) {
        		int temp = Math.abs(x) + Math.abs(y);
        		
        		if(temp <= time) {
        			poss = false;
        			break;
        		}
        		
        		if((var < len) && (path.charAt(var) == 'N')) {
        			y += 1;
        		} else if((var < len) && (path.charAt(var) == 'S')) {
        			y -= 1;
        		} else if((var < len) && (path.charAt(var) == 'E')) {
        			x -= 1;
        		} else if ((var < len) && (path.charAt(var) == 'W')){
        			x += 1;
        		}
        		
        		var++;
        		//System.out.print(var + " ");
        	}
        	
        	if(poss) {
        		System.out.println("Case #" + t + ": IMPOSSIBLE");
        	} else {
	        	System.out.println("Case #" + t + ": " + time);
        	}
        }
    }
}