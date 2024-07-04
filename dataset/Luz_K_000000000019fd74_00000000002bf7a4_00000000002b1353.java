import java.util.*;
import java.io.*;
import java.lang.Object;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int toget = in.nextInt() - 1;
      int row = 1;
      
      System.out.println("Case #" + i + ":");
      System.out.println(1 + " " + 1);
      while (toget > 0) {
    	  if(toget - row >= 0) {
    		  row ++;
    		  System.out.println(row + " " + 2);
    		  toget -= row - 1;
    	  }else {
    		  while(toget >0) {
    		  System.out.println(row + " " + 1);
    		  toget --;
    		  row ++;
    		  }
    	  }
      }
    }
      
  }
}
