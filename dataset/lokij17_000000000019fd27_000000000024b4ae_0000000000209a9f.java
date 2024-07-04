import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      StringBuilder Sout = new StringBuilder();
      String S = in.next();
      boolean open = false;
      for (int j = 0; j < S.length(); j++) {
        char c = S.charAt(j);
        if (c == '1') {
          if (!open) {
            Sout.append('(');
            open = true;
          }
          Sout.append(c);
        } else {
          if (open) {
            Sout.append(')');
            open = false;
          }
          Sout.append(c);
        }
      }
      if (open) {
        Sout.append(")");
      }
      System.out.println("Case #" + (t + 1) + ": " + Sout.toString());
    }
  }
}


