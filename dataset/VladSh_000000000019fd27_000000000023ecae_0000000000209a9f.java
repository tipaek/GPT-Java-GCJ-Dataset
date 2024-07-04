
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
  public static InputStream in = System.in;
  public static PrintStream out = System.out;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int t = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    Q2 q2 = new Q2();

    for (int i = 1; i <= t; ++i) {
      out.println("Case #" + i + ": " + q2.solve(scanner.next()));
    }
  }

  public static class Q2 {
    public String solve(String s) {
      StringBuilder sb = new StringBuilder();
      int prev = 0;
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        int num = ch - '0';
        if (num > prev) {
          sb.append(repOp(num - prev));
        } else if (num < prev) {
          sb.append(repCl(prev - num));
        }
        sb.append(ch);
        prev = num;
      }
      if (prev > 0) {
        sb.append(rep(")", prev));
      }
      return sb.toString();
    }

    private String repOp(int i) {
      return op[i];
    }

    private String repCl(int i) {
      return cl[i];
    }
  }

  private static String rep(String s, int n) {
    return String.join("", Collections.nCopies(n, s));
  }

  private static final String[] op =
      IntStream.range(0, 10).mapToObj(i -> rep("(", i)).toArray(n -> new String[n]);
  private static final String[] cl =
      IntStream.range(0, 10).mapToObj(i -> rep(")", i)).toArray(n -> new String[n]);
}
