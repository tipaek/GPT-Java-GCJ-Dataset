import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      String s = in.nextLine();
	      //System.out.println("s="+s);
	      int before=10;
    	  StringBuilder sb = new StringBuilder();
	      for(int j=0; j < s.length() ; j++) {
	    	  int temp=Character.getNumericValue(s.charAt(j));
	    	  if(before!=temp) {
	    		  for(int k=0; k< temp ;k++) {
	    			  sb.append("(");
	    		  }
	    		  sb.append(temp);
	    	  }else if(before==temp) {
	    		  sb.append(temp);
	    	  }
    		  before=temp;

	    	  if((j+1)==s.length() ) {
	    		  for(int k=0; k< temp ;k++) {
	    			  sb.append(")");
	    		  }
	    	  }else {
	    		  int after=Character.getNumericValue(s.charAt(j+1));
	    		  if(after!=temp) {

		    		  for(int k=0; k< temp ;k++) {
		    			  sb.append(")");
		    		  }
	    		  }
	    	  }
	      }

	      System.out.println("Case #" + i + ": " + sb.toString());
	    }
	}

}