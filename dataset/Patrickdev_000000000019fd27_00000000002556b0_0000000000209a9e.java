import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

  private static void solve(int testCase, int noOfBits) {
    boolean[] result = new boolean[noOfBits];

    // 1. guess first middle 10
    //   2.1  check if complement or original by one bit
    //   2.2  check reverse or its complement by same bit
    // 3. guess 4 to left, 4 to right
    //   2.1 and 2.2
    // until done

    int distanceThatHasDifferentValues = -1;
    int distanceThatHasSameValues = -1;

    int amountChecked = 0;
    while (true) {
      int rightPos = noOfBits / 2 + amountChecked;
      int leftPos = noOfBits / 2 - amountChecked - 1;
      boolean rightValue = guess(rightPos);
      boolean leftValue = guess(leftPos);
      result[rightPos] = rightValue;
      result[leftPos] = leftValue;
      if (rightValue != leftValue && distanceThatHasDifferentValues == -1) {
        distanceThatHasDifferentValues = amountChecked;
      }
      if (rightValue == leftValue && distanceThatHasSameValues == -1) {
        distanceThatHasSameValues = amountChecked;
      }
      amountChecked++;

      if (amountChecked * 2 >= noOfBits) {
        finish(result);
      }

      if (amountChecked % 5 == 0) {
        // SPEND TWO GUESSES TO SEE WHICH ALGO
        int diffValuePos = noOfBits / 2 + distanceThatHasDifferentValues;
        int sameValuePos = noOfBits / 2 + distanceThatHasSameValues;
        boolean diffValueValue = guess(diffValuePos);
        boolean sameValueValue = guess(sameValuePos);
        boolean diffValueIdentical = diffValueValue == result[diffValuePos];
        boolean sameValueIdentical = sameValueValue == result[sameValuePos];
        if (diffValueIdentical && sameValueIdentical) {
          // original
          result = result;
        } else if (diffValueIdentical && !sameValueIdentical) {
          result = reverse(complement(result));
          // reverse, also complement?
        } else if (!diffValueIdentical && sameValueIdentical) {
          result = reverse(result);          // reverse, also complement?
        } else if (!diffValueIdentical && !sameValueIdentical) {
          result = complement(result);
        }
      }

      if (amountChecked * 2 >= noOfBits) {
        finish(result);
      }
    }
  }

  private static void finish(boolean[] result) {

    for (boolean bit : result) {
      out.append(bit ? "1" : "0");
    }
    out.flush();

    String input = in.next();
    if (!input.equals("Y")) {
      System.exit(-1);
    }
  }

  private static boolean guess(int nth) {
    out.print(nth + 1);
    out.flush();
    return in.nextInt() == 1;
  }

  private static boolean[] reverse(boolean[] input) {
    boolean[] result = new boolean[input.length];
    for (int i = 0; i < input.length; i++) {
      result[input.length - 1] = input[i];
    }
    return result;
  }

  private static boolean[] complement(boolean[] input) {
    boolean[] result = new boolean[input.length];
    for (int i = 0; i < input.length; i++) {
      result[i] = !input[i];
    }
    return result;
  }

  // -----------

  public static void main(String[] args) {
    int testCount = in.nextInt();
    int B = in.nextInt();
    for (int testCase = 1; testCase <= testCount; testCase++) {
      solve(testCase, B);
    }
  }

  private static ScannerHelper in = new ScannerHelper(System.in);
  private static PrintStream out = System.out;
  private static PrintStream debug = System.err;

  static class ScannerHelper {

    private Scanner sc;

    static void override(String data) {
      System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    ScannerHelper(InputStream stream) {
      sc = new Scanner(stream);
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    BigInteger nextBigInteger() {
      return new BigInteger(next());
    }

    BigDecimal nextBigDecimal() {
      return new BigDecimal(next());
    }

    String next() {
      String word = sc.next();
      if (word != null && !word.isEmpty()) {
        return word;
      }

      sc.nextLine();
      return next();
    }

  }
}
