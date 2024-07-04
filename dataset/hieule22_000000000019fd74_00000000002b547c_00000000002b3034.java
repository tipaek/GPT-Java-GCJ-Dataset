import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Hieu Le
 */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    PatternMatching solver = new PatternMatching();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class PatternMatching {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      out.printf("Case #%d: %s\n", testNumber, crack(in));
    }

    private String crack(InputReader in) {
      int n = in.nextInt();

      PatternMatching.Pattern[] patterns = new PatternMatching.Pattern[n];
      String prefix = "", suffix = "";

      for (int i = 0; i < n; ++i) {
        PatternMatching.Pattern pattern = new PatternMatching.Pattern(in.next());
        {
          String currPrefix = pattern.prefix();
          if (!cover(prefix, currPrefix, false)) {
            return "*";
          }
          if (currPrefix.length() > prefix.length()) {
            prefix = currPrefix;
          }
        }
        {
          String currSuffix = pattern.suffix();
          if (!cover(suffix, currSuffix, true)) {
            return "*";
          }
          if (currSuffix.length() > suffix.length()) {
            suffix = currSuffix;
          }
        }

        patterns[i] = pattern;
      }

      StringBuilder sb = new StringBuilder(prefix);

      for (PatternMatching.Pattern pattern : patterns) {
        for (int i = pattern.first + 1; i < pattern.last; ++i) {
          if (pattern.data.charAt(i) != '*') {
            sb.append(pattern.data.charAt(i));
          }
        }
      }
      sb.append(suffix);

      return sb.toString();
    }

    private boolean cover(String s, String t, boolean inverse) {
      int length = Math.min(s.length(), t.length());
      if (!inverse) {
        for (int i = 0; i < length; ++i) {
          if (s.charAt(i) != t.charAt(i)) {
            return false;
          }
        }
      } else {
        for (int i = 0; i < length; ++i) {
          if (s.charAt(s.length() - 1 - i) != t.charAt(t.length() - 1 - i)) {
            return false;
          }
        }
      }
      return true;
    }

    static class Pattern {
      String data;
      int first = -1;
      int last = -1;

      Pattern(String data) {
        this.data = data;
        for (int i = 0; i < data.length(); ++i) {
          if (data.charAt(i) == '*') {
            last = i;
            if (first == -1) {
              first = i;
            }
          }
        }
        if (first == -1 || last == -1) {
          throw new RuntimeException();
        }
      }

      String prefix() {
        return data.substring(0, first);
      }

      String suffix() {
        return data.substring(last + 1);
      }
    }
  }

  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private static final int BUFFER_SIZE = 32768;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
