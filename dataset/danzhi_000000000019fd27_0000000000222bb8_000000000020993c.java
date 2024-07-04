import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

// 2020 CodeJam Qualification Round Problem 1
public class Solution {
  // The complete absolute path from where application was initialized.
  // For example: C:\Users\danzhi\workspace\CodeJam
  final static String USER_DIR = System.getProperty("user.dir");
  final static String CNAME = MethodHandles.lookup().lookupClass().getName();
  final static Random RAND = new Random();

  static String join(Collection<?> objs, String on) {
    StringBuilder sb = new StringBuilder();
    Iterator<?> it = objs.iterator();
    boolean first = true;
    while (it.hasNext()) {
      if (!first) sb.append(on);
      sb.append(it.next().toString() + "L");
      first = false;
    }
    return sb.toString();
  }

  public static void main(String[] args) throws FileNotFoundException {
    File fin = new File(USER_DIR + "/io/" + CNAME + ".in");
    Scanner in = fin.exists()? new Scanner(fin) : new Scanner(System.in);
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
      int N = in.nextInt();
      int[][] M = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          M[i][j] = in.nextInt();
        }
      }
      int trace = 0;
      for (int i = 0; i < N; i++) {
        trace += M[i][i];
      }
      int numRows = 0;
      for (int i = 0; i < N; i++) {
        Set<Integer> s = new HashSet<>();
        for (int j = 0; j < N; j++) {
          if (s.contains(M[i][j])) {
            numRows++;
            break;
          }
          s.add(M[i][j]);
        }
      }
      int numCols = 0;
      for (int j = 0; j < N; j++) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
          if (s.contains(M[i][j])) {
            numCols++;
            break;
          }
          s.add(M[i][j]);
        }
      }
      System.out.format("Case #%d: %d %d %d\n", t, trace, numRows, numCols);
    }
    in.close();
  }

}
