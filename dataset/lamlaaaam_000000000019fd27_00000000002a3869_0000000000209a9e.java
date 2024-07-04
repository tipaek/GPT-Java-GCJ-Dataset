import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int B = in.nextInt();
    for (int i = 1; i <= T; ++i) {
      solve(i, in, B);
    }
  }

  public static void solve(int c, Scanner in, int B) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= B; ++i) {
      System.out.println(i);
      sb.append(Integer.parseInt(in.nextLine()));
    }
    System.out.println(sb.toString());
  }
}