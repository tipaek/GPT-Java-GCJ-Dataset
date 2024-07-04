import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    int t, n, s, e, cs, ce, cCount, jCount, js, je;
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();
    for (int j = 0; j < t; j++) {
      cs = ce = js = je = -1;
      n = sc.nextInt();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        s = sc.nextInt();
        e = sc.nextInt();
        if (isNotOverlap(cs, ce, s, e)) {
          if (cs > -1)
            cs = Math.min(cs, s);
          else
            cs = s;
          ce = Math.max(ce, e);
          sb.append("C");
        } else if (isNotOverlap(js, je, s, e)) {
          if (js > -1)
            js = Math.min(js, s);
          else
            js = s;
          je = Math.max(je, e);
          sb.append("J");
        }
      }
      String ans;
      if (sb.length() == n)
        ans = sb.toString();
      else
        ans = "IMPOSSIBLE";
      System.out.println("Case #" + (j + 1) + " " + ans);

    }

  }

  private static boolean isNotOverlap(int start, int end, int s, int e) {
    return (s >= end || e <= start);
  }

}
