import java.util.*;
import java.io.*;
import java.lang.Object;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int toget = in.nextInt() - 1;
      int row = 2;
      int kposition = 1;
      
      System.out.println("Case #" + i + ":");
      System.out.println(1 + " " + 1);
      if(toget != 0) {
    	  System.out.println(2 + " " + 1);
    	  toget --;
      }
      while (toget != 0) {
    	  if(toget - binomial(row+1,2) >= 0) {
    		  row ++;
    		  kposition =2;
    		  System.out.println(row + " " + 2);
    		  toget -= binomial(row,2);
    	  }else {
    		  System.out.println(row + " " + 1);
    		  toget --;
    		  row ++;
    	  }
      }
    }
      
  }
  static long binomial(int N, int K) {
	  N--;
	  K--;
	  return factorial(N)/(factorial(N-K)*factorial(K));
	}
  public static long factorial(int number) {
      long result = 1;

      for (int factor = 2; factor <= number; factor++) {
          result *= factor;
      }

      return result;
  }
}
