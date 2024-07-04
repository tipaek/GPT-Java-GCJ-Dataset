
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
	  char [] data;
	  StringBuilder sb = null;
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; ++i) {
    	sb = new StringBuilder();
    	data = in.nextLine().toCharArray();
      System.out.println("Case #" + i + ": " +createNestedDepth(sb, data));
      
    }
    if(in != null) {
    	in.close();
    }
    
  }
  
  public static String createNestedDepth(StringBuilder sb, char [] data) {
	  int firstDig = 0, irstCarIntal;
	  
	  for (int dig = 0; dig < data.length; dig++) {
		  irstCarIntal = Character.getNumericValue(data[dig]);
		  if(irstCarIntal> firstDig) {
			  sb = createNestedDepth(sb, '(', irstCarIntal-firstDig);
		  }else {
			  sb = createNestedDepth(sb, ')', firstDig-irstCarIntal);
		  }
		  sb.append(irstCarIntal);
		  firstDig = Character.getNumericValue(data[dig]);
	  } 
	  sb = createNestedDepth(sb, ')', firstDig);
	  return sb.toString();
	  
  }
  
  public static StringBuilder createNestedDepth(StringBuilder sb, char opnClsBrac, int cnt) {
	  for (int i = 1; i <= cnt; ++i) {
		  sb.append(opnClsBrac);
	  }
	  return sb;
  }
}
