import java.util.*;
import java.io.*;
    
class Solution {
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
 
        	if(b == 10) {
        		StringBuilder result = new StringBuilder();
	        	for(int j=1; j<=10; j++) {
    	    		System.out.println(j);
    	    		result.append(in.next());
        		}
 
        		System.out.println(result.toString());
        		
        		String c = in.next();
        		if(c.equals("N")) {
        			return;
        		}
        		
        	} else {
        		System.out.println("1111000");
        		String c = in.next();
        		if(c.equals("N")) {
        			return;
        		}
        	}
        }
	}
}