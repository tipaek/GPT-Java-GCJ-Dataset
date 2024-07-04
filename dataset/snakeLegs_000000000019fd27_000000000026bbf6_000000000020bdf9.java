import java.util.*;

public class Solution {

  static class Interval {
    int low = 0, high = 0;
  }

  static boolean doOVerlap(Interval i1, Interval i2) {
    if (i1.low < i2.high && i2.low < i1.high) return true;
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long tc = sc.nextInt();
    int tcn = 1;

    while (tc-- != 0) {
      int n = sc.nextInt();

      int inter[][] = new int[n][2];
      for (int i = 0; i < n; i++) {
        inter[i][0] = sc.nextInt();
        inter[i][1] = sc.nextInt();
      }

      String answer = "";
      HashMap<String, List<Interval>> map1 = new HashMap<>();

      for (int i = 0; i < n; i++) {
        Interval iz = new Interval();
        iz.low = inter[i][0];
        iz.high = inter[i][1];

        Boolean foundC = false;
        if (map1.containsKey("C")) {
          List<Interval> c = map1.get("C");
          boolean found = false;
          for (Interval ic : c) {
            if (doOVerlap(ic, iz)) {
              found = true;
              break;
            }
          }
          if (!found) {
            foundC = true;
            c.add(iz);
            map1.put("C", c);
            answer = answer + "C";
          }

        } else {
          ArrayList<Interval> intervals = new ArrayList<>();
          intervals.add(iz);
          map1.put("C", intervals);
          answer = answer + "C";
          foundC = true;
        }

        if (!foundC) {
          Boolean foundJ = false;
          if (map1.containsKey("J")) {
            List<Interval> c = map1.get("J");
            boolean found = false;
            for (Interval ic : c) {
              if (doOVerlap(ic, iz)) {
                found = true;
                break;
              }
            }
            if (!found) {
              c.add(iz);
              map1.put("J", c);
              answer = answer + "J";
              foundJ = true;
            }
          } else {
            ArrayList<Interval> intervals = new ArrayList<>();
            intervals.add(iz);
            map1.put("J", intervals);
            answer = answer + "J";
            foundJ = true;
          }

          if (!foundJ) {
            answer = "IMPOSSIBLE";
            break;
          }
        }
      }

      System.out.println("Case #" + tcn + ": " + answer);
      tcn++;
    }
  }
}
