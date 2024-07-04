
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
    tasks = new int[N][2];
    tasksIndex = new ArrayList<>();
    for (int i = 0; i < N; ++ i) {
      int[] task = new int[] {
          in.nextInt(),
          in.nextInt()
      };
      tasks[i] = task;
      tasksIndex.add(i);
    }

    tasksIndex.sort(Comparator.comparingInt(idx -> tasks[idx][0]));
  }


  static int T;

  static int N;
  static int[][] tasks;
  static List<Integer> tasksIndex;


  private static void solveCase(int caseNumber, PrintStream out) throws Exception
  {
    char[] schedule = new char[N];
    int[] cTask = null, jTask = null;
    for (int idx : tasksIndex) {
      int[] task = tasks[idx];
      if (cTask != null && cTask[1] <= task[0]) cTask = null;
      if (jTask != null && jTask[1] <= task[0]) jTask = null;
      if (cTask == null) {
        cTask = task;
        schedule[idx] = 'C';
      }
      else if (jTask == null) {
        jTask = task;
        schedule[idx] = 'J';
      }
      else {
        writeCaseResult(out, caseNumber, "IMPOSSIBLE");
        return;
      }
    }

    writeCaseResult(out, caseNumber, new String(schedule));
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
