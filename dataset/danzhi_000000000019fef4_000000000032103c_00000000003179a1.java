
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

// 2020 CodeJam Round 1C Problem 2
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

  static class QR {
    // the i-th query and response
    int Q;
    String R;

    // Length of Q
    int qlen = 0;
    // Leading digit of Q
    int lead = 0;
    public QR(int q, String r) {
      this.Q = q;
      this.R = r;
      this.qlen = Integer.toString(Q).length();
      this.lead = Integer.toString(Q).charAt(0) - '0';
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    File fin = new File(USER_DIR + "/io/" + CNAME + ".in");
    Scanner in = fin.exists()? new Scanner(fin) : new Scanner(System.in);
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
      int U = in.nextInt();
      List<QR> a = new ArrayList<>();
      for (int i = 0; i < 10000; i++) {
        a.add(new QR(in.nextInt(), in.next()));
      }
      Collections.sort(a, new Comparator<QR>() {
        @Override
        public int compare(QR o1, QR o2) {
          return Integer.compare(o1.Q, o2.Q);
        }});

      // System.out.format("%d\n", U);
      TreeSet<Character> chs = new TreeSet<>();
      for (QR v : a) {
        for (char c : v.R.toCharArray()) {
          chs.add(c);
        }
        // System.out.format("%d %s\n", v.Q, v.R);
      }
      // System.out.format("%s\n", join(chs));
      TreeSet<Character> zeros = new TreeSet<>(chs);
      for (QR v : a) {
        zeros.remove(v.R.charAt(0));
      }
      // System.out.format("%s\n", join(zeros));
      TreeMap<Character, TreeSet<Integer>> cvalues = new TreeMap<>();
      char z = zeros.first();
      for (char c : chs) {
        if (c == z) continue;
        TreeSet<Integer> values = new TreeSet<>();
        for (int i = 1; i <= 9; i++) {
          values.add(i);
        }
        cvalues.put(c, values);
      }
      TreeMap<Character, Integer> cvm = new TreeMap<>();
      TreeMap<Integer, Character> vcm = new TreeMap<>();
      vcm.put(0, z);
      cvm.put(z, 0);
      for (int i = 0; i < 10; i++) {
        if (vcm.size() >= 10) break;
        for (QR v : a) {
          // If response has same number of digits as query
          if (v.qlen == v.R.length()) {
            char c = v.R.charAt(0);
            if (cvm.containsKey(c)) continue;
            // value of the first character is limited to 1...lead
            TreeSet<Integer> values = cvalues.get(c);
            for (int m = v.lead + 1; m < 10; m++) {
              values.remove(m);
            }
            values.removeAll(vcm.keySet());
            if (values.size() == 1) {
              vcm.put(values.first(), c);
              cvm.put(c, values.first());
            }
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      for (char c : vcm.values()) {
        sb.append(c);
      }
      System.out.format("Case #%d: %s\n", t, sb.toString());
      // Case #1: TPFOXLUSHB
    }
    in.close();
  }
}
