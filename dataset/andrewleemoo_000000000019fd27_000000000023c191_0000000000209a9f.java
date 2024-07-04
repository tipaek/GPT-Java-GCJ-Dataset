import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.nextLine();

      //divide and conquer
      //wrap contiguous nonzero substrings with one paren
      //recurse
      //concatenate the result
      String ans = recurse(s, 0, s.length()-1, 0);

      System.out.println("Case #" + i + ": " + ans);
    }
  }

  public static String recurse(String s, int left, int right, int depth) {
    if(left>=right) {
      return "";
    }
    String ans = "";
    while(left<right) {
      int ptr = left;
      while((Integer.parseInt(s.charAt(ptr))-depth) > 0) {
        ptr++;
      }
      if(ptr>left) {
        ans += "(" + recurse(s, left, ptr-1, depth+1) + ")";
      }
      else {
        ans += s.charAt(ptr);
      }
      left = left==ptr ? left+1 : ptr;
    }
    return ans;
  }
}