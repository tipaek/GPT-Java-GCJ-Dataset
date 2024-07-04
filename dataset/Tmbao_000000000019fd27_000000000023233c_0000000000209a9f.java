import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/** Built using CHelper plug-in Actual solution is at the top */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    NestingDepth solver = new NestingDepth();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class NestingDepth {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
      String s = in.next();

      StringBuilder sPrimeBuilder = new StringBuilder();
      int depth = 0;
      for (int i = 0; i < s.length(); ++i) {
        int requirement = s.charAt(i) - '0';
        while (depth < requirement) {
          sPrimeBuilder.append('(');
          depth++;
        }
        while (depth > requirement) {
          sPrimeBuilder.append(')');
          depth--;
        }
        sPrimeBuilder.append(s.charAt(i));
      }
      while (depth > 0) {
        sPrimeBuilder.append(')');
        depth--;
      }
      out.println(String.format("Case #%s: %s", testNumber, sPrimeBuilder.toString()));
    }
  }
}
