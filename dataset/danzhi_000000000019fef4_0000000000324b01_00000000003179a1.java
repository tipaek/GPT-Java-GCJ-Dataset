
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

  public static void main(String[] args) throws FileNotFoundException {
    File fin = new File(USER_DIR + "/io/" + CNAME + ".in");
    Scanner in = fin.exists()? new Scanner(fin) : new Scanner(System.in);
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
      int U = in.nextInt();
      List<String> a = new ArrayList<>();
      for (int i = 0; i < 10000; i++) {
        in.nextInt();
        a.add(in.next());
      }
      TreeSet<Character> chs = new TreeSet<>();
      TreeMap<Character, Integer> m = new TreeMap<>();
      TreeMap<Character, Integer> tm = new TreeMap<>();
      for (String v : a) {
        char c = v.charAt(0);
        m.put(c, m.getOrDefault(c, 0) + 1);
        for (char w : v.toCharArray()) {
          chs.add(w);
          tm.put(w, tm.getOrDefault(w, 0) + 1);
        }
      }
      char zero = 0;
      for (char c : chs) {
        if (!m.containsKey(c)) {
          zero = c;
          break;
        }
      }
      tm.remove(zero);
      for (Map.Entry<Character, Integer> e : tm.entrySet()) {
        System.out.format("%c %d\n", e.getKey(), e.getValue());
      }

      TreeMap<Integer, Character> rm = new TreeMap<>(Collections.reverseOrder());
      for (Map.Entry<Character, Integer> e : m.entrySet()) {
        rm.put(e.getValue(), e.getKey());
      }

      TreeMap<Integer, Character> trm = new TreeMap<>(Collections.reverseOrder());
      for (Map.Entry<Character, Integer> e : tm.entrySet()) {
        trm.put(e.getValue(), e.getKey());
      }
      StringBuilder sb = new StringBuilder();
      sb.append(zero);
      for (char c : trm.values()) {
        sb.append(c);
      }
      System.out.format("Case #%d: %s\n", t, sb.toString());
      // Case #1: TPFOXLUSHB
    }
    in.close();
  }
}
