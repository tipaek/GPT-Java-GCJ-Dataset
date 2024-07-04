import java.util.Scanner;

import static java.lang.Math.abs;

class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      StringBuilder Sout = new StringBuilder();
      String S = in.next();
      int numOpen = 0;
      String open = "(((((((((";
      String close = ")))))))))";
      for (int j = 0; j < S.length(); j++) {
        char c = S.charAt(j);
        int pendingOpen = (c - '0') - numOpen;
        if (pendingOpen > 0) {
          Sout.append(open, 0, pendingOpen);
        } else if (pendingOpen < 0) {
          Sout.append(close, 0, abs(pendingOpen));
        }
        numOpen += pendingOpen;
        Sout.append(c);
      }
      if (numOpen > 0) {
        Sout.append(close, 0, numOpen);
      }
      System.out.println("Case #" + (t + 1) + ": " + Sout.toString());
    }
  }
}
