
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; i++) {
      String input = in.nextLine();
      String output = "";
      int openCounter = 0,closeCounter = 0,strIndex = 0;
      for(int s = 0; s<input.length();s++) {
    	  int curr = Integer.parseInt(input.charAt(s)+"");
    	  if(curr-openCounter>0) {
    		  while(openCounter!=curr) {
    			  output+="(";
    			  openCounter++;
    		  }
    		  
    	  }
    	  else if(curr-openCounter<0) {
    		  while(openCounter!=curr) {
    			  output+=")";
        		  openCounter--;
    		  }
    		 
    	  }
    	  output+=curr;
      }
      while(openCounter!=0) {
    	  output+=")";
    	  openCounter--;
      }
      System.out.println("Case #" + i + ": " +output);
    }
  }
}