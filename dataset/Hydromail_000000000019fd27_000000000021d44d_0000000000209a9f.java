import java.util.*;
import java.io.*;
public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    in.nextLine();
		    for (int i = 1; i <= t; i++) {
		      String line = in.nextLine();
		      StringBuilder sb = new StringBuilder();
		      char[] str = line.toCharArray();
		      int opened = 0;
		      for (int j=0; j<str.length; j++) {
		        while (Character.getNumericValue(str[j]) > opened) {
		          sb.append("(");
		          opened++;
		        }
		        while (Character.getNumericValue(str[j]) < opened) {
		          sb.append(")");
		          opened--;
		        }
		        sb.append(str[j]);
		      }
			  while (opened > 0) {
			    sb.append(")");
			    opened--;
			  }
		      String s = sb.toString();
		      
		      System.out.println("Case #" + i + ": " + s);
		    }
		  }
}