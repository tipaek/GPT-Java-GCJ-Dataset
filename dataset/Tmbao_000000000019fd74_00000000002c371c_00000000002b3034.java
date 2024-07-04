import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;
import java.util.ArrayList;

/** Built using CHelper plug-in Actual solution is at the top */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    PatternMatching solver = new PatternMatching();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static final class PatternMatching {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
      int N = in.nextInt();
      List<String> patterns = new ArrayList<>();
      for (int i = 0; i < N; ++i) {
        patterns.add(in.next());
      }
      String result = patterns.get(0);
      for (int i = 1; i < N; ++i) {
        Optional<String> mergeResult = merge(result, patterns.get(i));
        if (mergeResult.isPresent()) {
          result = mergeResult.get();
        } else {
          result = "*";
          break;
        }
      }

      if (result != "*") {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length(); ++i) {
          if (result.charAt(i) != '*') {
            builder.append(result.charAt(i));
          }
        }
        result = builder.toString();
      }

      out.println(String.format("Case #%d: %s", testNumber, result));
    }

    private static Optional<String> merge(String lhs, String rhs) {
      if (lhs.startsWith("*") && rhs.endsWith("*")) {
        return Optional.of(rhs + lhs.substring(1));
      }
      if (lhs.endsWith("*") && rhs.startsWith("*")) {
        return Optional.of(lhs + rhs.substring(1));
      }
      if (lhs.startsWith("*") && lhs.endsWith("*")) {
        return Optional.of(mergeInBetween(rhs, lhs));
      }
      if (rhs.startsWith("*") && rhs.endsWith("*")) {
        return Optional.of(mergeInBetween(lhs, rhs));
      }

      String lhsPrefix = lhs.substring(0, lhs.indexOf('*'));
      String lhsSuffix = lhs.substring(lhs.lastIndexOf('*') + 1);

      String rhsPrefix = rhs.substring(0, rhs.indexOf('*'));
      String rhsSuffix = rhs.substring(rhs.lastIndexOf('*') + 1);

      String prefix;
      int lhsSubStrStart, rhsSubStrStart;
      if (lhsPrefix.length() >= rhsPrefix.length()) {
        if (!lhsPrefix.startsWith(rhsPrefix)) {
          return Optional.empty();
        }
        prefix = rhsPrefix;
        lhsSubStrStart = rhsPrefix.length();
        rhsSubStrStart = rhsPrefix.length();
      } else {
        if (!rhsPrefix.startsWith(lhsPrefix)) {
          return Optional.empty();
        }
        prefix = lhsPrefix;
        lhsSubStrStart = lhsPrefix.length();
        rhsSubStrStart = lhsPrefix.length();
      }

      String suffix;
      int lhsSubStrEnd, rhsSubStrEnd;
      if (lhsSuffix.length() >= rhsSuffix.length()) {
        if (!lhsSuffix.endsWith(rhsSuffix)) {
          return Optional.empty();
        }
        suffix = rhsSuffix;
        lhsSubStrEnd = lhs.length() - rhsSuffix.length();
        rhsSubStrEnd = rhs.length() - rhsSuffix.length();
      } else {
        if (!rhsSuffix.endsWith(lhsSuffix)) {
          return Optional.empty();
        }
        suffix = lhsSuffix;
        lhsSubStrEnd = lhs.length() - lhsSuffix.length();
        rhsSubStrEnd = rhs.length() - lhsSuffix.length();
      }

      Optional<String> middlePart =
          merge(
              lhs.substring(lhsSubStrStart, lhsSubStrEnd),
              rhs.substring(rhsSubStrStart, rhsSubStrEnd));
      if (!middlePart.isPresent()) {
        return Optional.empty();
      }
      return Optional.of(prefix + middlePart.get() + suffix);
    }

    private static String mergeInBetween(String main, String component) {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < main.length(); ++i) {
        if (main.charAt(i) != '*') {
          builder.append(main.charAt(i));
        } else {
          builder.append(component);
          builder.append(main.substring(i + 1));
          break;
        }
      }
      return builder.toString();
    }
  }
}
