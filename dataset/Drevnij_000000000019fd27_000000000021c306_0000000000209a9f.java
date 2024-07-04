
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  
    for (int x = 1; x <= t; x++) {
      String s = in.next();

      String result = "";

      int depth = 0;
      for (int i=0; i<s.length(); i++) {
    	  int c = Integer.parseInt(String.valueOf(s.charAt(i)));
    	  if (c==depth) result = result+c;
    	  else if (c<depth) {
    		  for (int j=0; j<depth-c; j++) result = result+")";
    		  result = result+c;
    		  depth=c;
    	  }
    	  else if (c>depth) {
    		  for (int j=0; j<c-depth; j++) result = result+"(";
    		  result = result+c;
    		  depth=c;
    	  }
    	  
      }
	  if (depth>0) {
		  for (int j=0; j<depth; j++) result = result+")";
	  }
      
      System.out.println("Case #" + x + ": "+result);
    }
  }
}