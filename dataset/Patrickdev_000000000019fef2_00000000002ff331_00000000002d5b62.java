import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {


  enum dir {
    FORWARD, BACKWARD, STILL;
  }

  private static String solve(int goalX, int goalY) {

    int THIRTY = 31;
    dir[] dirX = new dir[THIRTY];
    dir[] dirY = new dir[THIRTY];

    boolean negateX = goalX < 0;
    boolean negateY = goalY < 0;
    goalX = Math.abs(goalX);
    goalY = Math.abs(goalY);

    for (int counter = 0; counter < THIRTY; counter++) {
      boolean xUses = ((goalX >> counter) & 1) == 1;
      boolean yUses = ((goalY >> counter) & 1) == 1;
      dirX[counter] = xUses ? dir.FORWARD : dir.STILL;
      dirY[counter] = yUses ? dir.FORWARD : dir.STILL;
    }

    for (int counter = 0; counter < THIRTY; counter++) {
      dir[] first, second;

      first = dirX;
      second = dirY;

      if (counter < THIRTY - 2) {
        first = dirX;
        second = dirY;

        if (first[counter] == dir.FORWARD && first[counter + 1] == dir.FORWARD &&
            first[counter + 2] == dir.STILL &&
            second[counter] == dir.STILL && second[counter + 1] == dir.FORWARD &&
            second[counter + 2] == dir.STILL) {
          first[counter] = dir.BACKWARD;
          first[counter + 1] = dir.STILL;
          first[counter + 1] = dir.FORWARD;
          continue;
        }

        first = dirY;
        second = dirX;

        if (first[counter] == dir.FORWARD && first[counter + 1] == dir.FORWARD &&
            first[counter + 2] == dir.STILL &&
            second[counter] == dir.STILL && second[counter + 1] == dir.FORWARD &&
            second[counter + 2] == dir.STILL) {
          first[counter] = dir.BACKWARD;
          first[counter + 1] = dir.STILL;
          first[counter + 2] = dir.FORWARD;
          continue;
        }
      }

      if (counter < THIRTY - 1) {
        if (first[counter] == dir.FORWARD && first[counter + 1] == dir.STILL
            && second[counter] == dir.STILL && second[counter + 1] == dir.STILL) {
          first[counter] = dir.BACKWARD;
          first[counter] = dir.FORWARD;
          continue;
        }

        first = dirY;
        second = dirX;
        if (first[counter] == dir.FORWARD && first[counter + 1] == dir.STILL
            && second[counter] == dir.STILL && second[counter + 1] == dir.STILL) {
          first[counter] = dir.BACKWARD;
          first[counter + 1] = dir.FORWARD;
          continue;
        }
      }

      if (dirX[counter] == dir.FORWARD && dirY[counter] == dir.FORWARD) {
        // unresolvable conflict :(
        return "IMPOSSIBLE";
      }
    }

    int amountNeeded = 0;
    StringBuilder result = new StringBuilder();
    for (int counter = 0, bit = 0; counter < THIRTY; counter++, bit *= 2) {
      boolean xneedsbit = dirX[counter] != dir.STILL;
      boolean yneedsbit = dirY[counter] != dir.STILL;
      if (yneedsbit && xneedsbit) {
        return "IMPOSSIBLE";
      }

      if (!yneedsbit && !xneedsbit) {
        amountNeeded++;
        continue;
      }

      if (xneedsbit) {
        // east!

        while (amountNeeded > 0) {
          result.append(dirX[counter] == dir.FORWARD ? "W" : "E");
          amountNeeded--;
        }
        result.append(dirX[counter] == dir.FORWARD ? "E" : "W");
      } else {
        // north!
        while (amountNeeded > 0) {
          result.append(dirY[counter] == dir.FORWARD ? "S" : "N");
          amountNeeded--;
        }
        result.append(dirY[counter] == dir.FORWARD ? "N" : "S");
      }
    }

    String answer = result.toString();

    if (negateX) {
      answer = answer
          .replace("W", "-")
          .replace("E", "W")
          .replace("-", "E");
    }
    if (negateY) {
      answer = answer
          .replace("N", "-")
          .replace("S", "N")
          .replace("-", "S");
    }


    goalX = Math.abs(goalX);
    goalY = Math.abs(goalY);

    return answer;
  }


  private static void solve(int testCase) {
    int goalX = in.nextInt(),
        goalY = in.nextInt();

    String result = solve(goalX, goalY);

    out.printf("Case #%s: %s%n", testCase, result);

  }

  // -----------

  public static void main(String[] args) {
    int testCount = in.nextInt();
    for (int testCase = 1; testCase <= testCount; testCase++) {
      solve(testCase);
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
