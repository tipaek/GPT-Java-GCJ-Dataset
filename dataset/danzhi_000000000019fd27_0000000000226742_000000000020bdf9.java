
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

// 2020 CodeJam Qualification Round Problem 3
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
      if (!first) sb.append(',');
      sb.append(it.next().toString());
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
      int[][] A = new int[N][3];
      for (int i = 0; i < N; i++) {
        A[i][0] = in.nextInt();
        A[i][1] = in.nextInt();
        A[i][2] = i;
      }
      Arrays.sort(A, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          if (o1[0] != o2[0]) {
            return Integer.compare(o1[0], o2[0]);
          } else {
            return Integer.compare(o1[1], o2[1]);
          }
        }});

      for (int i = 0; i < N; i++) {
        // System.out.format("(%d,%d:%d)\n", A[i][0], A[i][1], A[i][2]);
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < N; i++) {
        sb.append(' ');
      }
      int J = 0;
      int C = 0;
      for (int[] v : A) {
        if (C <= v[0]) {
          sb.setCharAt(v[2], 'C');
          C = v[1];
        } else if (J <= v[0]) {
          sb.setCharAt(v[2], 'J');
          J = v[1];
        } else {
          sb.setLength(0);
          sb.append("IMPOSSIBLE");
          break;
        }
      }
      System.out.format("Case #%d: %s\n", t, sb.toString());
    }
    in.close();
  }

}
