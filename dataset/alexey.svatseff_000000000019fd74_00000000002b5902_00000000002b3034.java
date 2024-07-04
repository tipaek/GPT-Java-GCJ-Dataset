
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
    in.nextLine();
    s = new String[N];
    for (int i = 0; i < N; ++ i)
      s[i] = in.nextLine();
  }


  static int T;

  static int N;
  static String[] s;


  private static void solveCase(int caseNumber, PrintStream out) throws Exception
  {
    String[] prefixes = new String[N], suffixes = new String[N];
    int[] firstAny = new int[N], lastAny = new int[N];
    for (int i = 0; i < N; ++ i) {
      firstAny[i] = s[i].indexOf('*');
      prefixes[i] = s[i].substring(0, firstAny[i]);
      lastAny[i] = s[i].lastIndexOf('*');
      suffixes[i] = s[i].substring(1 + lastAny[i]);
    }

    String maxPrefix = prefixes[0], maxSuffix = suffixes[0];
    for (int i = 1; i < N; ++ i) {
      if (prefixes[i].length() > maxPrefix.length()) maxPrefix = prefixes[i];
      if (suffixes[i].length() > maxSuffix.length()) maxSuffix = suffixes[i];
    }

    for (int i = 0; i < N; ++ i) {
      if (! (maxPrefix.startsWith(prefixes[i]) && maxSuffix.endsWith(suffixes[i]))) {
        writeCaseResult(out, caseNumber, "*");
        return;
      }
    }

    StringBuilder matchAll = new StringBuilder(maxPrefix);
    for (int i = 0; i < N; ++ i) {
      for (int j = firstAny[i] + 1; j < lastAny[i]; ++ j) {
        char ch = s[i].charAt(j);
        if (ch != '*') matchAll.append(ch);
      }
    }
    matchAll.append(maxSuffix);

    writeCaseResult(out, caseNumber, matchAll.toString());
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
