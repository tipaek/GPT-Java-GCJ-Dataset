import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private static class Interval {
    int start;
    int end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    boolean intersects(Interval that) {
      Interval e;
      Interval l;

      if (this.start <= that.start) {
        e = this;
        l = that;
      } else {
        e = that;
        l = this;
      }

      if (l.start >= e.end) {
        return false;
      } else {
        return true;
      }
    }
  }


  private static boolean assignable(List<Interval> intervals, Interval interval) {
    for (Interval currentInterval : intervals) {
      if (currentInterval.intersects(interval)) {
        return false;
      }
    }

    intervals.add(interval);
    return true;
  }

  private static String calc(List<Interval> intervals) {
    StringBuilder schedule = new StringBuilder();
    Map<Character, List<Interval>> workers = new HashMap<>();
    workers.put('C', new ArrayList<>());
    workers.put('J', new ArrayList<>());

    for (Interval interval : intervals) {
      if (assignable(workers.get('C'), interval)) {
        schedule.append('C');
      } else if (assignable(workers.get('J'), interval)) {
        schedule.append('J');
      } else {
        return "IMPOSSIBLE";
      }
    }

    return schedule.toString();
  }


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int T = Integer.parseInt(br.readLine());

      for (int input = 1; input <= T; input++) {
        int N = Integer.parseInt(br.readLine());
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < N; i++) {
          String[] inp = br.readLine().split(" ");
          Interval interval = new Interval(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
          intervals.add(interval);
        }

        String r = calc(intervals);
        System.out.println("Case #" + input + ": " + r);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
