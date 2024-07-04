import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      System.out.println("Case #" + i + ": ");
      System.out.println("1 1");
      n--;
      //down left while large, then switch for tail
      int row = 1;
      while(n>200)
      {
    	  row++;
    	  System.out.println(row+" 2");
    	  n-=row-1;
      }
      if(row==1)
      {
    	  row++;
      }
      while(n>0)
      {
    	  System.out.println(row+" 1");
    	  row++;
    	  n--;    	  
      }
    }
  }
}