
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

// 2020 CodeJam Round 1C Problem 1
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
      int X = in.nextInt();
      int Y = in.nextInt();
      String M = in.next();
      int x = X;
      int y = Y;
      int output = -1;
      for (int i = 0; i <= M.length(); i++) {
        if (Math.abs(x) + Math.abs(y) <= i) {
          output = i;
          break;
        }
        if (i >= M.length()) break;
        char ch = M.charAt(i);
        if (ch == 'N') {
          y++;
        } else if (ch == 'E') {
          x++;
        } else if (ch == 'S') {
          y--;
        } else if (ch == 'W') {
          x--;
        }
      }
      if (output < 0) {
        System.out.format("Case #%d: IMPOSSIBLE\n", t);
      } else {
        System.out.format("Case #%d: %d\n", t, output);
      }
    }
    in.close();
  }
}
