import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
  public static InputStream in = System.in;
  public static PrintStream out = System.out;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(in);
    int t = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int b = scanner.nextInt();
    Q4 q4 = new Q4(b, scanner);
    for (int ks = 1; ks <= t; ks++) {
      if (!"Y".equalsIgnoreCase(q4.solve())) {
        return;
      }
    }
  }

  public static class Q4 {
    private final int b;
    private final Scanner scanner;

    public Q4(int b, Scanner scanner) {
      this.b = b;
      this.scanner = scanner;
    }

    public String solve() {
      int j = 1;
      char[] nums = new char[b];
      while (j <= b) {
        nums[j - 1] = next(j);
        j++;
      }
      println(new String(nums));
      String result = scanner.next();
      return result;
    }

    private char next(int j) {
      println("" + j);
      String next = scanner.next();
      return next.charAt(0);
    }
  }

  static void println(String line) {
    out.println(line);
    out.flush();
  }
}
