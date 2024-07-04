import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  public static InputStream in = System.in;
  public static PrintStream out = System.out;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(in);
    int t = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int b = scanner.nextInt();
    for (int ks = 1; ks <= t; ks++) {
      Q4 q4 = new Q4(b, scanner);
      if (!"Y".equalsIgnoreCase(q4.solve())) {
        return;
      }
    }
  }

  public static class Q4 {
    public enum Op {
      N,
      R,
      NR,
      X,
      F;
    }

    private final int b;
    private final Scanner scanner;
    private final String[] words;

    public Q4(int b, Scanner scanner) {
      this.b = b;
      this.scanner = scanner;
      this.words = new String[b / 5];
    }

    public String solve() {
      int i0 = 0;
      int j0 = b / 5 - 1;
      words[i0] = read5(i0);
      words[j0] = read5(j0);

      if (b > 10) {
        while (words[i0].equals(not(words[j0]))) { // reverse() is not distinguishable from not()
          words[i0] = null;
          words[j0] = null;
          i0++;
          j0--;
          words[i0] = read5(i0);
          words[j0] = read5(j0);
        }
      }

      final int i = i0;
      while (!allRead()) {
        int j = nextJ();
        String first = read5(i);
        String second = read5(j);
        System.err.println(String.format("before:  %s %s %s", words[i], words[j], words[j0]));
        System.err.println(String.format("now   :  %s %s %s", first, second, words[j0]));

        Op operation = detectOperation(i, j0, j, first, second);
        System.err.println(String.format("op    :  %s", operation));
        System.err.println(String.format("op before   :  %s", Arrays.asList(words)));
        apply(operation);

        if (!(words[i].equals(first))) {
          throw new IllegalStateException(
              "invalid application: " + words[i] + " should be " + first);
        }

        System.err.println(String.format("op after    :  %s", Arrays.asList(words)));
        words[j] = second;
        System.err.println(String.format("op after2    :  %s", Arrays.asList(words)));
      }

      System.err.println(String.format("Answer     :  %s", Arrays.asList(words)));
      println(String.join("", Arrays.asList(words)));
      String result = scanner.next();
      return result;
    }

    private int nextJ() {
      for (int i = words.length - 1; i >= 0; i--) {
        if (words[i] == null) {
          return i;
        }
      }
      return 0;
    }

    private void apply(Op operation) {
      if (Op.N.equals(operation) || Op.NR.equals(operation)) {
        for (int i = 0; i < words.length; i++) {
          if (words[i] != null) {
            words[i] = not(words[i]);
          }
        }
      }
      if (Op.R.equals(operation) || Op.NR.equals(operation)) {
        for (int i = 0; i < words.length / 2; i++) {
          words[i] = reverse(words[i]);
          swap(i, words.length - i - 1);
          words[i] = reverse(words[i]);
        }
      }
    }

    private void swap(int i, int j) {
      String tmp = words[i];
      words[i] = words[j];
      words[j] = tmp;
    }

    private Op detectOperation(int i, int j0, int j, String f, String s) {
      if (f.equals(words[i])) {
        return Op.X;
      } else if (not(f).equals(words[i])) {
        return Op.N;
      } else if (reverse(f).equals(words[j0]) || reverse(s).equals(words[words.length - j - 1])) {
        return Op.R;
      } else if (not(reverse(f)).equals(words[j0])) {
        return Op.NR;
      }
      return Op.F;
    }

    private static String not(String word) {
      StringBuilder sb = new StringBuilder();
      for (char ch : word.toCharArray()) {
        sb.append(ch == '0' ? '1' : '0');
      }
      return sb.toString();
    }

    private static String reverse(String word) {
      return word == null ? null : new StringBuilder(word).reverse().toString();
    }

    private String read5(int from) {
      char[] nums = new char[5];
      for (int i = 0; i < 5; i++) {
        nums[i] = next(i + from * 5 + 1);
      }
      return new String(nums);
    }

    private boolean allRead() {
      for (int i = 0; i < words.length; i++) {
        if (words[i] == null) {
          return false;
        }
      }
      return true;
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
