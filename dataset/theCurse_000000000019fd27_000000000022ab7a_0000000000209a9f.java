import java.util.*;
import java.io.*;
    
class Solution {
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String num = in.next();
            
            StringBuilder result = new StringBuilder();
            int length = num.length();
            int count = num.charAt(0) - '0';
            
            while(count-- > 0) {
            	result.append("(");
            }
            
            result.append(num.charAt(0));
            for(int j=1; j<length; j++) {
            	int a = num.charAt(j-1) - '0';
            	int b = num.charAt(j) - '0';
            	
            	int diff = a-b;
            	if(diff > 0) {
            		while(diff-- > 0) {
            			result.append(")");
            		}
            		result.append(num.charAt(j));
            	} else if(diff < 0) {
            		diff *= -1;
            		while(diff-- > 0) {
            			result.append("(");
            		}
            		result.append(num.charAt(j));
            	} else {
            		result.append(num.charAt(j));
            	}
            }
            
            count = num.charAt(length-1) - '0';
            while(count-- > 0) {
            	result.append(")");
           	}
            
            System.out.println("Case #"+ i + ": " + result.toString());
		}
	}
}