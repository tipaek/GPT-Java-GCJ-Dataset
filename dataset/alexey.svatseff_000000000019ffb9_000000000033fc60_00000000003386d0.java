
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


// Aliaksei Sviattsau
public class Solution
{
  private static boolean DEBUG = false;

  // Solution //////////////////////////////////////////////////////////////////////////////////////////////////////////

  private static void readCaseInput(int caseNumber, Scanner in) throws Exception
  {
    N = in.nextInt();
    holes = new int[N][2];
    for (int i = 0; i < N; ++ i) {
      holes[i][0] = in.nextInt();
      holes[i][1] = in.nextInt();
    }
  }


  static int T;

  static int N;
  static int[][] holes;


  private static void solveCase(int caseNumber, PrintStream out) throws Exception
  {
    Map<List<Integer>, Set<Set<Integer>>> connectedByVector = new HashMap<>();
    for (int i = 0; i < N; ++ i) {

      Map<List<Integer>, Set<Integer>> connectedLocallyByVector = new HashMap<>();
      for (int j = 0; j < N; ++ j) {

        if (i == j) continue;

        int vx, vy;
        if (holes[i][0] < holes[j][0] || (holes[i][0] == holes[j][0] && holes[i][1] < holes[j][1])) {
          // Vector is from i to j
          vx = holes[j][0] - holes[i][0];
          vy = holes[j][1] - holes[i][1];
        }
        else {
          // Vector is from j to i
          vx = holes[i][0] - holes[j][0];
          vy = holes[i][1] - holes[j][1];
        }

        int a = Math.max(Math.abs(vx), Math.abs(vy));
        int b = Math.min(Math.abs(vx), Math.abs(vy));
        int gcd = gcd(a, b);
        vx = vx / gcd;
        vy = vy / gcd;
        List<Integer> vector = new ArrayList<>();
        vector.add(vx);
        vector.add(vy);

        Set<Integer> connected = connectedLocallyByVector.computeIfAbsent(vector, key -> new HashSet<>());
        connected.add(i);
        connected.add(j);
      }

      for (Map.Entry<List<Integer>, Set<Integer>> localConnections : connectedLocallyByVector.entrySet()) {
        Set<Set<Integer>> connectedSets = connectedByVector.computeIfAbsent(localConnections.getKey(), key -> new HashSet<>());
        connectedSets.add(localConnections.getValue());
      }
    }
    int maxConnected = connectedByVector.values().stream().mapToInt(Solution::price).max().orElse(0);

    writeCaseResult(out, caseNumber, String.valueOf(Math.min(maxConnected + 2, N)));
  }


  private static int price(Set<Set<Integer>> x)
  {
    // Points at the same vector
    List<Integer> sizes = x.stream().map(Set::size).collect(Collectors.toList());

    boolean isOddPair = false;
    int count = 0;
    for (Integer size : sizes) {
       if (size % 2 == 0) count += size;
       else {
         if (isOddPair) {
           isOddPair = false;
           count += size + 1;
         }
         else {
           count += size - 1;
           isOddPair = true;
         }
       }
    }

    return count;
  }


  private static int gcd(int a, int b)
  {
    if (b==0) return a;
    return gcd (b,a%b);
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
