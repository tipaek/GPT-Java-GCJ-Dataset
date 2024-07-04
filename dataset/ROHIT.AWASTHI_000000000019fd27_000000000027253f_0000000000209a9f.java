import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    for (int i = 1; i <= t; ++i) {
		    String s = in.next();
		    StringBuilder sDesh = new StringBuilder();
		    int val = 0;
		    for(int j=0; j<s.length(); j++ ) {
		    	char ch = s.charAt(j);
		    	int digit = ch-48;
		    	if(val>digit) {
		    		for(int k=0; k<val-digit; k++) {
			    		sDesh.append(")");
		    		}
		    	} else
		    		if(val<digit) {
			    		for(int k=0; k<digit-val; k++) {
				    		sDesh.append("(");
			    		}
		    		}
		    	sDesh.append(digit);
		    	val = digit;
		    }
		    if(val!=0) {
	    		for(int k=0; k<val; k++) {
		    		sDesh.append(")");
	    		}
		    }
	    	System.out.println("Case #" + i + ": " +sDesh.toString());
	    }
	    in.close();
	}
	
}
