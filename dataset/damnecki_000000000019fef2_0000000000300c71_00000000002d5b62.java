import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream OUT = System.out;
  private static final List<Long> A = new ArrayList<>();

  static {
    for (int i = 0; i < 32; i++) {
      A.add((long) Math.pow(2, i));
    }
  }

  public static void main(String[] args) {
    int T = IN.nextInt();
    long X, Y;
    String answer, answer2, answer3;
    List<Long> a;
    for (int t = 1; t <= T; t++) {
      X = IN.nextLong();
      Y = IN.nextLong();

      if (X % 2 == 0 && Y % 2 == 0) {
        answer = "IMPOSSIBLE";
      } else if (X % 2 != 0 && Y % 2 != 0) {
        answer = "IMPOSSIBLE";
      } else {
        a = new ArrayList<>(A);
        if (X % 2 == 0) {
          answer = find(X, a, X > 0 ? "E" : "W");
        } else {
          answer = find(Y, a, Y > 0 ? "N" : "S");
        }
        if (!answer.equals("IMPOSSIBLE")) {
          int l = answer.length();
          if (X % 2 != 0) {
            answer2 = "W" + find2(X + 1, a, X + 1 > 0 ? "E" : "W", l, answer);
            if (answer2.contains("IMPOSSIBLE")) {
              answer2 = "E" + find2(X - 1, a, X - 1 > 0 ? "E" : "W", l, answer);
            } else {
              answer3 = "E" + find2(X - 1, a, X - 1 > 0 ? "E" : "W", l, answer);
              if (!answer3.contains("IMPOSSIBLE") && answer3.length() < answer2.length()) {
                answer2 = answer3;
              }
            }
            if (answer2.contains("IMPOSSIBLE")) {
              answer = "IMPOSSIBLE";
            } else {
              answer += answer2;
            }
          } else {
            answer2 = "S" + find2(Y + 1, a, Y + 1 > 0 ? "N" : "S", l, answer);
            if (answer2.contains("IMPOSSIBLE")) {
              answer2 = "N" + find2(Y - 1, a, Y - 1 > 0 ? "N" : "S", l, answer);
            } else {
              answer3 = "N" + find2(Y - 1, a, Y - 1 > 0 ? "N" : "S", l, answer);
              if (!answer3.contains("IMPOSSIBLE") && answer3.length() < answer2.length()) {
                answer2 = answer3;
              }
            }
            if (answer2.contains("IMPOSSIBLE")) {
              answer = "IMPOSSIBLE";
            } else {
              answer = answer2;
            }
          }
        }
      }

      OUT.println("Case #" + t + ": " + answer);
    }
  }

  private static String find2(Long z, List<Long> a, String dir, int i, String answer) {
    Long zz = Math.abs(z);
    for (int ii = 1; ii < i; ii++) {
      zz -= a.get(ii);
      answer = dir + answer;
    }
    if (zz > 0) {
      i = (i == 0) ? 1 : i;
      zz -= a.get(i);
      answer += dir;
    }
    if (zz != 0) {
      return "IMPOSSIBLE";
    }
    return answer;
  }

  private static String find(Long z, List<Long> a, String dir) {
    Long zz = Math.abs(z);
    List<Long> aa = new ArrayList<>();
    while (zz > 0) {
      int i = 0;
      while (a.get(++i) < zz) ;
      zz -= a.get(i);
      aa.add(a.get(i));
    }
    if (zz != 0) {
      return "IMPOSSIBLE";
    }
    a.removeAll(aa);
    String answer = "";
    for (int i = 0; i < aa.size(); i++) {
      answer += dir;
    }
    return answer;
  }
}