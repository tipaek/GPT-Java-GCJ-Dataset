import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      String m = in.next();
      System.out.println("Case #" + i + ": " + parenthese(m));
    }
  }
  public static String parenthese(String a) {
	  String ans = "";
	  int current = 0;
	  for (int i = 0 ; i < a.length(); i++) {
		  int b = Character.getNumericValue(a.charAt(i));
		  current -= b;
//		  System.out.println(current);
		  if (current < 0) {
			  for (int j = 0; j < -current; j++) {
				  ans += '(';
			  }
			  ans += a.charAt(i);
		  }
		  else {
			  for (int j = 0; j < current; j++) {
				  ans += ')';
			  }
			  ans += a.charAt(i);
		  }
		  current = b;
	  }
	  for (int k = 0; k < current; k++) {
		  ans += ')';
	  }
	  return ans;
  }
  }