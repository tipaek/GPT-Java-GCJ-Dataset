import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; i++) {
      String s = in.nextLine();
      s = s.replace("1", "(1)");
      s = s.replace(")(", "");
      System.out.println("Case #" + i + ": " + s);
    }
  }
  
}