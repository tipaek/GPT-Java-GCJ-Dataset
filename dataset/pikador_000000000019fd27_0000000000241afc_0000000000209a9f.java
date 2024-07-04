import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	Scanner inp = new Scanner(System.in);
	    int cases = inp.nextInt();
	    for (int c = 0; c < cases; c++) {
	    	String s = inp.next();
	    	
	    	String result = "";

	    	int digit = -1;
	    	int open = 0;
	    	
	    	for (int i = 0; i < s.length(); i++) {
	    		int newDigit = Integer.valueOf(s.substring(i, i+1));
	    		if (i == 0) {
	    	    	for (int p = 0; p < newDigit; p++) {
	    	    		result = result.concat("(");
	    	    		open++;
	    	    	}
	    		} else 
	    		if (newDigit > digit) {
	    	    	for (int p = 0; p < newDigit - digit; p++) {
	    	    		result = result.concat("(");
	    	    		open++;
	    	    	}
	    		} else { 
		    		if (newDigit < digit) {
		    	    	for (int p = 0; p < digit - newDigit; p++) {
		    	    		result = result.concat(")");
		    	    		open--;
		    	    	}
		    		}
	    		}
		    	result = result.concat(s.substring(i, i+1));
		    	digit = newDigit;
	    	}
   	    	for (int p = 0; p < open; p++) {
   	    		result = result.concat(")");
    		} 
	    	
	    	System.out.println("Case #" + (c+1) + ": " + result);
	    }
        inp.close();
    }
}
