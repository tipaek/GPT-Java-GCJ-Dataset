 

import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 1; t < T + 1; t++) {
      String s = in.next();
      solve(s, t);
    }
    return;
  }

  public static void solve(String s, int t) {
    int depth = 0; // depth
    String ans = "";
    for (char c : s.toCharArray()) {
      int currentNumber = c - '0';
      if (currentNumber > depth) {
        while (currentNumber > depth) {
          ans += ("(");
          depth++;
        }
      }
      if (currentNumber < depth) {
        while (currentNumber < depth) {
          ans += (")");
          depth--;
        }
      }
      ans += (c);
    }
    while (depth > 0) {
      ans += (")");
      depth--;
    }
    System.out.println(String.format("Case #%depth: %s", t, ans));
  }
}
