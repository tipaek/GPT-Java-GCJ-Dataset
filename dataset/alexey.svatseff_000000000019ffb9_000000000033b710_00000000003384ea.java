
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
    L = in.nextLong();
    R = in.nextLong();
  }


  static int T;

  static long L, R;



  private static void solveCase(int caseNumber, PrintStream out) throws Exception
  {
    long left = L, right = R, count;
    long discrepancy = Math.max(left, right) - Math.min(left, right);
    long countInit = countCustomers(discrepancy, 1L, 1L);
    long demandInit = demand(1L, 1L, countInit);

    if (left < right) {
      right -= demandInit;
    }
    else {
      left -= demandInit;
    }

    if (left >= right) {
      long countLeft = countCustomers(left, countInit + 1, 2L);
      long countRight = countCustomers(right, countInit + 2, 2L);
      if (countRight > countLeft) countRight = countLeft;
      if (countLeft > countRight + 1) countLeft = countRight + 1;
      count = countInit +  countLeft + countRight;
      left -= demand(countInit + 1, 2L, countLeft);
      right -= demand(countInit + 2, 2L, countRight);
    }
    else {
      long countLeft = countCustomers(left, countInit + 2, 2L);
      long countRight = countCustomers(right, countInit + 1, 2L);
      if (countLeft > countRight) countLeft = countRight;
      if (countRight > countLeft + 1) countRight = countLeft + 1;
      count = countInit +  countLeft + countRight;
      left -= demand(countInit + 2, 2L, countLeft);
      right -= demand(countInit + 1, 2L, countRight);
    }

    writeCaseResult(out, caseNumber, String.format("%d %d %d", count, left, right));
  }


  private static long countCustomers(long stock, long initial, long step)
  {
    long l = 0L, r = Math.min(stock + 1, 20000000000L);
    while (l + 1 < r) {

      long m = (l + r) / 2;
      long demand = demand(initial, step, m);
      if (demand > stock) r = m;
      else if (demand < stock) l = m;
      else return m;
    }
    return l;
  }


  private static long demand(long initial, long step, long n)
  {
    long last = initial + (n - 1) * step;
    return n * (initial + last) / 2L;
  }


  private static void writeCaseResult(PrintStream out, int caseNumber, String formattedResult) throws IOException
  {
    out.println("Case #" + caseNumber + ": " + formattedResult);
    out.flush();
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
