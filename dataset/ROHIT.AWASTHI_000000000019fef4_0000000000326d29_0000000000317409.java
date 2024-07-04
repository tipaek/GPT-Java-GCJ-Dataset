import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    for (int l = 1; l <= t; ++l) {
	    	int x = in.nextInt();
	    	int y = in.nextInt();
	    	int currX = 0;
	    	int currY = 0;
		    String m = in.next();
		    int result = 0;
		    int i=0;
//	    	System.out.println("x : "+x+" y : "+y+" currX : "+currX+" currY : "+currY);
		    for(; i<m.length(); i++) {
		    	char dir = m.charAt(i);
	    		result += 1;
		    	switch(dir) {
		    	case 'N':
		    		y += 1;
		    		break;
		    	case 'S':
		    		y -= 1;
		    		break;
		    	case 'E':
			    	x += 1;
		    		break;
		    	case 'W':
			    	x -= 1;
		    		break;
		    	}
	    		if(Math.abs(x-currX)>Math.abs(y-currY)) {
	    			if(x>currX) {
	    				currX += 1;
	    			} else
	    				if(x<currX) {
	    					currX -= 1;
	    				}
	    		} else
	    			if(Math.abs(x-currX)<Math.abs(y-currY)) {
	    				if(y>currY) {
			    			currY += 1;
			    		} else
		    				if(y<currY) {
	    						currY -= 1;
	    					}
	    			}
//		    	System.out.println("x : "+x+" y : "+y+" currX : "+currX+" currY : "+currY);
		    	if(x==currX && y == currY) {
		    		break;
		    	}
		    }
		    System.out.println("Case #" + l + ": "+(i==m.length() ? "IMPOSSIBLE" : result));
	    }
	    in.close();
	}

}
