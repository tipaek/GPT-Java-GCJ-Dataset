import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
  public static void main(String[] args) throws Exception {
    try {
      Solution solution = new Solution();
//      solution.executeBatch("src/codejam2020/esabatad/Solution.txt");
      solution.executeBatch(System.in);
    }
    catch (Exception exception) {
      System.out.println(exception.getMessage());
      exception.printStackTrace();
      throw exception;
    }
  }

  private void executeBatch(String filename) throws Exception {
    executeBatch(new FileInputStream(filename));
  }

  private void executeBatch(InputStream in) throws Exception {
    Scanner scanner = new Scanner(in);
    int testCases = scanner.nextInt();
    int b = scanner.nextInt();
//    System.err.printf("%d %d\n", testCases, b);
    for (int testCase = 1; testCase <= testCases; ++testCase)
      if (execute(testCase, b, scanner) == -1)
        return;
  }

  private int execute(int testCase, int b, Scanner scanner) {
    int[] bits = new int[b];
    boolean checkEPair = false;
    int ePair = -1;
    boolean checkOPair = false;
    int oPair = -1;
    boolean swap = false;
    boolean invert = false;

    int i2 = 0;
    String response = null;
    int bit = 0;
    for (int i1 = 0; i1 < b; ++i2) {
      if ((i2 > 0) && (i2 % 10 == 0)) {
        checkEPair = true;
        checkOPair = true;
        swap = false;
        invert = false;
      }

//      System.err.printf("%d %d %d %d %d ", i2, i1, ePair, oPair,
//            i1 % 2 == 0 ? 1 + i1 / 2 : b - i1 / 2);
      if (checkEPair && (ePair >= 0))
        System.out.printf(Locale.ENGLISH, "%d\n", 1 + ePair);
      else if (checkOPair && (oPair >= 0))
        System.out.printf(Locale.ENGLISH, "%d\n", 1 + oPair);
      else
        System.out.printf(Locale.ENGLISH, "%d\n",
            i1 % 2 == 0 ? 1 + i1 / 2 : b - i1 / 2);
      System.out.flush();

      response = scanner.next();
//      System.err.printf("%s\n", response);
      if ("0".equals(response))
        bit = 0;
      else if ("1".equals(response))
        bit = 1;
      else
        return -1;

      if (checkEPair) {
        if (ePair >= 0)
          invert = (bits[ePair] != bit);
        checkEPair = false;
//        System.err.printf("%s\n", invert ? "do invert" : "don't invert");
      }
      else if (checkOPair) {
        if (oPair >= 0)
          swap = (bits[oPair] != bit) ^ invert;
        checkOPair = false;
//        System.err.printf("%s\n", swap ? "do swap" : "don't swap");
      }
      else {
        bits[i1 % 2 == 0 ? i1 / 2 : b - i1 / 2 - 1] = bit;
        if (i1 % 2 == 1) {
          if (bits[(i1 - 1) / 2] == bits[b - i1 / 2 - 1]) {
            if (ePair == -1)
              ePair = (i1 - 1) / 2;
          }
          else {
            if (oPair == -1)
              oPair = (i1 - 1) / 2;
          }
        }
        ++i1;
//        System.err.printf("%d\n", i1);
      }

//      System.err.println("invert=" + invert + ", swap=" + swap);
      if (!checkEPair && !checkOPair && invert) {
//        System.err.println("execute invert");
//        logBits(bits);
        for (int i = 0; i < b; ++i)
          bits[i] = 1 - bits[i];
//        logBits(bits);
        invert = false;
      }
      if (!checkEPair && !checkOPair && swap) {
//        System.err.println("execute swap");
//        logBits(bits);
        for (int i = 0; i < (b - 1) / 2; ++i) {
          bit = bits[i];
          bits[i] = bits[b - i - 1];
          bits[b - i - 1] = bit;
        }
//        logBits(bits);
        swap = false;
      }
//      logBits(bits);
    }

    StringBuilder out = new StringBuilder(b);
    for (int i = 0; i < b; ++i)
      out.append(bits[i] == 0 ? '0' : '1');
//    System.err.printf(Locale.ENGLISH, "%s\n", out.toString());
    System.out.printf(Locale.ENGLISH, "%s\n", out.toString());
    System.out.flush();
    response = scanner.next();
//    System.err.printf(Locale.ENGLISH, "%s\n", response);
    return "Y".equals(response) ? 0 : -1;
  }

  private void logBits(int[] bits) {
    for (int i = 0; i < bits.length; ++i)
      System.err.print(bits[i]);
    System.err.println();
  }
}
