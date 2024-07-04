import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; ++i) {   
      String s = in.nextLine();
      StringBuilder s1 = new StringBuilder("");
      int parenCount = 0;
      for(int j = 0; j < s.length();j++) {
    	  int reqParens = Character.getNumericValue(s.charAt(j));
    	  while (parenCount < reqParens) {
    		  s1.append("(");
    		  parenCount++;
    	  }
    	  while (parenCount > reqParens) {
    		  s1.append(")");
    		  parenCount--;
    	  }
    	  s1.append(s.charAt(j));
      }
	  while (parenCount > 0) {
		  s1.append(")");
		  parenCount--;
	  }
      System.out.println("Case #" + i + ": " + s1);    
    }
  }
}