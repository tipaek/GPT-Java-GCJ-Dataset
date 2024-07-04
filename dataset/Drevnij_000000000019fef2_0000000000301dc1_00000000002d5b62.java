
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    
		    int t = in.nextInt();  
		    for (int xx = 1; xx <= t; xx++) {
		    	Set<Integer> avail = new HashSet<>();
		    	int x = in.nextInt();
		    	int y = in.nextInt();
		    	
		    	boolean reverseX=false;
		    	if (x<0) {
		    		x=x*-1;
		    		reverseX=true;
		    	}
		    	boolean reverseY=false;
		    	if (y<0) {
		    		y=y*-1;
		    		reverseY=true;
		    	}
		    	
		    	String result = "";
		    	if( (x+y)%2 == 0) result = "IMPOSSIBLE";
		    	else {
		    		if (x==0) {
		    			if (y==1) result="N";
		    			else if (y==3) result ="NN";
		    		} else if (x==1) {
		    			if (y==0) result = "E";
		    			else if (y==2) result="EN";
		    			else if (y==4) result="WEN";
		    		} else if (x==2) {
		    			if (y==1) result = "NE";
		    			else if (y==3) result="SEN";
	    			
		    		} else if (x==3) {
	    			if (y==0) result = "EE";
	    			else if (y==2) result="WNE";
	    			else if (y==4) result="EEN";

		    		} else if (x==4) {
	    			if (y==1) result = "SNE";
	    			else if (y==3) result="NNE";
	    			
		    		}
		    		
		    		
		    		if (reverseX) {
		    			result = result.replace('E', 'T');
		    			result = result.replace('W', 'E');
		    			result = result.replace('T', 'W');
		    		}
		    		if (reverseY) {
		    			result = result.replace('N', 'T');
		    			result = result.replace('S', 'N');
		    			result = result.replace('T', 'S');
		    		}
		    	}
			    	

		    	System.out.println("Case #"+ xx+": "+result);

		    }
		}
	  

	  

}