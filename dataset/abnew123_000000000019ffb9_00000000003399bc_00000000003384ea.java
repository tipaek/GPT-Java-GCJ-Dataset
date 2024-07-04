import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int l = in.nextInt();
      int r = in.nextInt();
      int cust = 1;
      while(cust <= l || cust <= r) {
    	  	if(l >=r) {
    	  		l-=cust;
    	  	}
    	  	else {
    	  		r-=cust;
    	  	}
    	  	cust++;
      }
      cust--;
      System.out.println("Case #" + i + ": " + cust + " " + l + " " + r);
    }
  }
}