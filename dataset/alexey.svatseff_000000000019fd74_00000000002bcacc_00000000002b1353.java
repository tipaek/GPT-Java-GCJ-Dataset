
import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

// Aliaksei Sviattsau
public class Solution
{
  private static boolean DEBUG = false;

  // Solution //////////////////////////////////////////////////////////////////////////////////////////////////////////

  private static void readCaseInput(int caseNumber, Scanner in) throws Exception
  {
    N = in.nextInt();
  }


  static int T;

  static int N;



  private static void solveCase(int caseNumber, PrintStream out) throws Exception
  {
    boolean[] bits = numberToBits(N);
    int maxBit = maxBit(bits);
    int passingCost = passingCost(bits, maxBit);
    int extraSteps = 0;

    if (passingCost > 0) {
      int nAdjusted = N - maxBit;
      bits = numberToBits(nAdjusted);
      maxBit = maxBit(bits);
      passingCost = passingCost(bits, maxBit);
      extraSteps = N - nAdjusted - passingCost;
    }

    out.println("Case #" + caseNumber + ": ");
    boolean leftToRightDirection = true;
    int line = 1;
    out.println(String.format("%d %d", line, 1));
    for (int i = 1; i <= maxBit; ++ i) {
      ++ line;
      if (bits[i]) {
        if (leftToRightDirection) {
          for (int j = 1; j <= line; ++ j)
            out.println(String.format("%d %d", line, j));
        }
        else {
          for (int j = line; j >= 1; -- j)
            out.println(String.format("%d %d", line, j));
        }
        leftToRightDirection = ! leftToRightDirection;
      }
      else {
        out.println(String.format("%d %d", line, leftToRightDirection ? 1 : line));
      }
    }

    for (int i = 0; i < extraSteps; ++ i) {
      ++ line;
      out.println(String.format("%d %d", line, leftToRightDirection ? 1 : line));
    }
    out.flush();
  }


  private static int passingCost(boolean[] bits, int maxBit)
  {
    // We have to start at 1/1
    int passingCost = 0;
    for (int i = 0; i <= maxBit; ++ i) {
      if (! bits[i]) ++ passingCost;
    }
    return passingCost;
  }


  private static int maxBit(boolean[] bits)
  {
    int maxBit = 0;
    for (int i = 1; i < bits.length; ++ i) {
      if (bits[i]) maxBit = i;
    }
    return maxBit;
  }


  private static boolean[] numberToBits(int n)
  {
    boolean[] bits = new boolean[32];
    int mask = 1;
    for (int i = 0; i < 31; ++ i) {
      bits[i] = (n & mask) != 0;
      mask = mask << 1;
    }
    return bits;
  }


  // Helpers ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#0.000000");

  public static void main(String[] args)
  {
    try {
      Locale.setDefault(Locale.US);

      try (Scanner in = openInput(args);
           PrintStream out = openOutput(args)) {

        T = in.nextInt();
        for (int caseNumber = 1; caseNumber <= T; caseNumber ++) {
          readCaseInput(caseNumber, in);
          solveCase(caseNumber, out);
          out.flush();
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }


  private static Scanner openInput(String[] args) throws FileNotFoundException
  {
    if (DEBUG) {
      String inPathName = args[0];
      File inFile = new File(inPathName);
      return new Scanner(new BufferedReader(new FileReader(inFile)));
    }
    else {
      return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }
  }


  private static PrintStream openOutput(String[] args) throws IOException
  {
    if (DEBUG) {
      String inPathName = args[0];
      String inPathBase = inPathName.substring(0, inPathName.lastIndexOf('.'));
      File outFile = new File(inPathBase + ".out");
      return new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));
    }
    else {
      return System.out;
    }

  }
}
