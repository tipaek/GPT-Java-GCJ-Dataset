import java.util.*;
import java.io.*;
public class Solution {
  static int [][] rules;
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int counter = 1; counter <= t; counter ++) {
      long left = in.nextLong();
      long right = in.nextLong();
      // first, get the stacks to be approximately even (within i of each other)
      long difference = left - right;
      // getting them "close" will take ~ sqrt(2*difference) turns, where we take just the bigger stack
      // To be safe, we will round this down and then just reanalyze after doing this subtraction
      long i = (long)(Math.sqrt(2*Math.abs(difference)-1)); // number of customers served so far
      if (difference >= 0)
        left -= i*(i+1)/2;
      else
        right -= i*(i+1)/2;
      // the stacks should differ by strictly less than i pancakes now
      // there might be some edge cases where the stacks are exactly equal
      // to be safe, we will decrement the larger one by i until this happens
      while (Math.abs(left-right) < i && left > i && right > i) {
        i ++;
        if (left >= right) left -= i; else right -= i;
      }
      //System.out.println(i + " " + left + " " + right);
      // at this point, we should be able to alternate between the two stacks
      // the bigger stack will lose (i+1) + (i+3) + ... + (i+2k-1) pancakes
      // the smaller one will lose (i+2) + (i+4) + ... + (i+2k) pancakes
      
      // find largest k for bigger stack
      long big = Math.max(left, right);
      long small = Math.min(left, right);
      double eps = 1e-14; // deal with rounding errors
      long kBig = (long)((-i + Math.sqrt(i*i + 4*big))/(2.0 - eps));
      long kSmall = (long)((-(i+1) + Math.sqrt((i+1)*(i+1) + 4*small))/(2.0 - eps));
      //System.out.println(-(i+1) + Math.sqrt((i+1)*(i+1) + 4*small));
      //System.out.println(big + " " + small);
      //System.out.println(kBig + " " + kSmall);
      // decrement big stack by k(i+k) and small stack by k(i+k+1)
      if (left >= right) {
        left -= kBig*(i+kBig);
        right -= kSmall*(i+1+kSmall);
      } else {
        right -= kBig*(i+kBig);
        left -= kSmall*(i+1+kSmall);
      }
      // increment i by kBig and kSmall
      i += kBig + kSmall;
      System.out.println("Case #" + counter + ": " + i + " " + left + " " + right);
    }
  }
}
