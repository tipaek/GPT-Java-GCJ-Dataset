
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

// 2020 CodeJam Round 1C Problem 3
public class Solution {
  // The complete absolute path from where application was initialized.
  // For example: C:\Users\danzhi\workspace\CodeJam
  final static String USER_DIR = System.getProperty("user.dir");
  final static String CNAME = MethodHandles.lookup().lookupClass().getName();
  final static Random RAND = new Random();

  static String join(Collection<?> objs) {
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
      int N = in.nextInt();  // You currently have N slices
      int D = in.nextInt();
      long[] A = new long[N];
      for (int i = 0; i < N; i++) {
        A[i] = in.nextLong();
      }

      // N: [1,300]
      // D: [2,3]
      Arrays.sort(A);
      TreeMap<Long, Integer> m = new TreeMap<>();
      for (long a : A) {
        Integer v = m.get(a);
        if (v == null) {
          m.put(a, 1);
        } else {
          m.put(a, v + 1);
        }
      }

      if (D == 2) {
        int ans = 1;
        for (Map.Entry<Long, Integer> e : m.entrySet()) {
          if (e.getValue() >= 2) {
            ans = 0;
            break;
          }
        }
        System.out.format("Case #%d: %d\n", t, ans);
      } else if (D == 3) {
        int ans = 2;
        for (Map.Entry<Long, Integer> e : m.entrySet()) {
          if (e.getValue() >= 3) {
            ans = 0;
            break;
          }
          if (m.containsKey(2L * e.getKey())) {
            ans = 1;
          }
        }
        System.out.format("Case #%d: %d\n", t, ans);
      } else {
        System.out.format("Case #%d: %d\n", t, 0);
      }
      // Case #1: TPFOXLUSHB
    }
    in.close();
  }
}
