import java.util.*;
import java.io.*;

public class Solution {

  private static String booking(List<Interval> activities) {
    char[] assignment = new char[activities.size()];
    int jamie = 0, cameron = 0;

    for (Interval act : activities) {
      if (cameron <= act.start) {
        assignment[act.id] = 'C';
        cameron = act.end;
      } else if (jamie <= act.start) {
        assignment[act.id] = 'J';
        jamie = act.end;
      } else {
        return "IMPOSSIBLE";
      }
    }
    return String.valueOf(assignment);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cases = scanner.nextInt();
    for (int t = 1; t <= cases; ++t) {
      int activities = scanner.nextInt();
      List<Interval> segments = new ArrayList<>();
      for (int i = 0; i < activities; ++i) {
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        segments.add(new Interval(i, start, end));
      }
      Collections.sort(segments);
      String ans = booking(segments);
      System.out.println("Case #" + t + ": " + ans);
    }
  }
}

class Interval implements Comparable<Interval> {
  int id;
  int start, end;
  Interval(int i, int s, int e) {
    id = i;
    start = s;
    end = e;
  }
  @Override
  public int compareTo(Interval that) {
    return this.start == that.start ? Integer.compare(this.end, that.end) : Integer.compare(this.start, that.start);
  }
}
