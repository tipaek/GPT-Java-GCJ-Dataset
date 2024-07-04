import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int i = 0; i < numTests; i++) {
    	String testCaseInput = in.next();
    	
    	System.out.println("Case #" + (i+1) + ": " + insertNestingParens(testCaseInput));
    }
    in.close();
  }
  
  public static String insertNestingParens(String testCaseInput) {
	  String result = "";
	  int currentParensLevel = 0;
	  for(String character : testCaseInput.split("")) {
		  Integer integer = Integer.parseInt(character);
		  result += generateParens(integer-currentParensLevel) + integer;
		  currentParensLevel = integer;
	  }
	  result += generateParens(-1*currentParensLevel);
	  
	  return result;
  }
  
  public static String generateParens(int parensNeeded)
  {
	  String result = "";
	  String parenToUse = parensNeeded < 0 ? ")" : "(";
	  
	  for(int i = 0; i < Math.abs(parensNeeded); i++) {
		  result += parenToUse;
	  }
	  return result;
  }
}