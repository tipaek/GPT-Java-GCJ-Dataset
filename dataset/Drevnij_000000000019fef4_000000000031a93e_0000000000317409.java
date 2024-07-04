
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    
		    int t = in.nextInt();  
		    for (int xx = 1; xx <= t; xx++) {
		    	int x = in.nextInt();  
		    	int y = in.nextInt();
		    	String path = in.next();
		    	
		    	int result=-1;
		    	
		    	int distance = x+y;
		    	for (int i=0; i<=path.length(); i++) {
		    		if (distance<=i) {
		    			result = i;
		    			break;
		    		}
		    		if (i==path.length()) break;
		    		char c = path.charAt(i);
		    		if (c == 'S' ) {
		    			if (y>0) distance--;
		    			else distance++;
		    			y--;
		    		}
		    		else if (c == 'N' ) {
		    			if (y<0) distance--;
		    			else distance++;
		    			y++;
		    		}
		    		else if (c == 'E' ) {
		    			if (x<0) distance--;
		    			else distance++;
		    			x++;
		    		}
		    		else if (c == 'W' ) {
		    			if (x>0) distance--;
		    			else distance++;
		    			x--;
		    		}
		    	}

		    	
		    	System.out.println("Case #"+ xx+": "+(result==-1?"IMPOSSIBLE":result));

		    }
		}
	  

	  

}