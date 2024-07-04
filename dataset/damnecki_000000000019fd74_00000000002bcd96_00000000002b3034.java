import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

  private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream OUT = System.out;

  public static void main(String[] args) {
    int T = IN.nextInt();
    int N;
    List<List<String>> P = new ArrayList<>();
    String pp;
    String[] p;
    String name;
    for (int t = 1; t <= T; t++) {
      N = IN.nextInt();
      P.clear();
      name = "";
      for (int i = 0; i < N; i++) {
        pp = IN.next();
        p = pp.split("\\*");
        for (int j = 0; j < p.length; j++) {
          if (P.size() == j) {
            P.add(new ArrayList<>());
          }
          P.get(j).add(p[j]);
        }
        if (pp.endsWith("*")) {
          if (P.size() == p.length) {
            P.add(new ArrayList<>());
          }
          P.get(P.size() - 1).add("");
        }
      }
      for (int j = 0; j < P.size(); j++) {
        Collections.sort(P.get(j), new Comp());
      }
//      System.out.println(P);
      pp = P.get(0).get(0);
      if (!pp.isEmpty()) {
        for (int i = 1; i < P.get(0).size(); i++) {
          if (!pp.startsWith(P.get(0).get(i))) {
            name = "*";
            break;
          }
        }
        if (name.equals("*")) {
          OUT.println("Case #" + t + ": " + name);
          continue;
        } else {
          name = pp;
        }
      }
      for (int i = 1; i < P.size() - 1; i++) {
        pp = P.get(i).get(0);
        for (int j = 0; j < P.get(i).size(); j++) {
          if (!pp.contains(P.get(i).get(j))) {
            name = "*";
          }
        }
        if (name.equals("*")) {
          break;
        } else {
          name += pp;
        }
      }
      if (name.equals("*")) {
        OUT.println("Case #" + t + ": " + name);
        continue;
      }
      pp = P.get(P.size() - 1).get(0);
      if (!pp.isEmpty()) {
        for (int i = 1; i < P.get(P.size() - 1).size(); i++) {
          if (!pp.startsWith(P.get(P.size() - 1).get(i))) {
            name = "*";
            break;
          }
        }
        if (!name.equals("*")) {
          name += P.get(P.size() - 1).get(0);
        }
      }
      OUT.println("Case #" + t + ": " + name);
    }
  }

  static class Comp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      return o2.length() - o1.length();
    }
  }
}