package NestingDepth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
//The nesting depth of a position p is the number of pairs of matching parentheses m such that p is included in the nesting of m.
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
          String S = in.next();
          
          String output = "";
          for(int k = 0; k<S.length();k++) {
        	  String temp = "" + S.charAt(k); 
        	  		//output += S.charAt(k);
        	  
        	  if(S.charAt(k) == '0') {
        		  output += '0';
        	  }else if((k!=0 && S.charAt(k) == S.charAt(k-1) && S.charAt(k-1) != '0' ) || (k!=0 && S.charAt(k) < S.charAt(k-1)&& S.charAt(k-1) != '0' )) {
  	  			//String x = output.substring(0, output.length() - Integer.parseInt(String.valueOf(S.charAt(k))));
  	  		    output = new StringBuilder(output).insert(output.length()-Integer.parseInt(String.valueOf(S.charAt(k))), S.charAt(k)).toString();
  	  		   
        	  } else if (k!=0 && S.charAt(k) > S.charAt(k-1) && S.charAt(k-1) != '0' ) {
        		  
        		  int difference  = Math.abs(Integer.parseInt(String.valueOf(S.charAt(k))) - Integer.parseInt(String.valueOf(S.charAt(k-1))));
        		
        		  for(int j = 1; j<=difference*2;j++) {
          	  		
          	  		if(j % 2 == 0) {
          	  			temp = temp + ")";
          	  		} else if (j % 2 != 0) {
          	  			temp = "(" + temp;
          	  		}
        	  					}
        		
        		  output = new StringBuilder(output).insert(output.length()-Integer.parseInt(String.valueOf(S.charAt(k-1))), temp).toString();
        		  
        	  } else {
  	  		for(int j = 1; j<=Integer.parseInt(String.valueOf(S.charAt(k)))*2;j++) {
    	  		
    	  		if(j % 2 == 0) {
    	  			temp = temp + ")";
    	  		} else if (j % 2 != 0) {
    	  			temp = "(" + temp;
    	  		}
  	  					}
  	  		output += temp;
  	  		}
        	  	
          }
          
          System.out.println("Case #" + i + ": " + output );
        }
        
      }

}
