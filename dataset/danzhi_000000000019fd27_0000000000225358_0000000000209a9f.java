import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 2020 CodeJam Qualification Round Problem 2
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

  static String f(int[] s, int b, int e) {
    if (b >= e) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    int min = 9;
    List<Integer> idxes = new ArrayList<>();
    for (int i = b; i < e; i++) {
      if (s[i] < min) {
        min = s[i];
        idxes.clear();
        idxes.add(i);
      } else if (s[i] == min) {
        idxes.add(i);
      }
    }
    // System.out.println(join(idxes));
    for (int i = 0; i < min; i++) {
      sb.append('(');
    }
    for (int i = b; i < e; i++) {
      s[i] -= min;
    }
    idxes.add(e);
    int p = b;
    for (int v : idxes) {
      if (p < v) {
        sb.append(f(s,p,v));
      }
      if (v < e) {
        sb.append('0');
      }
      p = v+1;
    }
    for (int i = 0; i < min; i++) {
      sb.append(')');
    }
    return sb.toString();
  }

  public static void main(String[] args) throws FileNotFoundException {
    File fin = new File(USER_DIR + "/io/" + CNAME + ".in");
    Scanner in = fin.exists()? new Scanner(fin) : new Scanner(System.in);
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
      String S = in.next();
      int[] s = new int[S.length()];
      for (int i = 0; i < s.length; i++) {
        s[i] = S.charAt(i) - '0';
      }
      String x = f(s, 0, s.length);
      StringBuilder sb = new StringBuilder(x);
      int k = 0;
      for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == '0') {
          sb.setCharAt(i, S.charAt(k++));
        }
      }
      System.out.format("Case #%d: %s\n", t, sb.toString());
    }
    in.close();
  }

}
