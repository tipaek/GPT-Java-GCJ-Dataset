
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    
		    int t = in.nextInt();  
		    for (int xx = 1; xx <= t; xx++) {
		    	long l = in.nextLong();  
		    	long r = in.nextLong();  
		    	
		    	long fin=0;
		    	for (long i=1; i<100000000000000000L; i++) {
		    		if (r>l) {
		    			if (r>=i) {
		    				r-=i;
		    			} else {
		    				fin = i-1;
		    				break;
		    			}
		    		}
		    		else {
		    			if (l>=i) {
		    				l-=i;
		    			} else {
		    				fin = i-1;
		    				break;
		    			}
		    		}
		    	}
		    	

		    	String result = ""+fin+" "+l+" "+r;
		    	
		    	System.out.println("Case #"+ xx+": "+result);

		    }
		}
	  

	  

}