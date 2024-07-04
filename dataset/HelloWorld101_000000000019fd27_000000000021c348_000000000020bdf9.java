import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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
  }


  private static String calc(List<Interval> intervals) {
    StringBuilder schedule = new StringBuilder();
    Map<Character, Integer> workers = new HashMap<>();
    workers.put('C', 0);
    workers.put('J', 0);

    intervals.sort(new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        if (o1.start == o2.start) {
          return Integer.compare(o1.end, o2.end);
        } else {
          return Integer.compare(o1.start, o2.start);
        }
      }
    });

    for (Interval interval : intervals) {
      // assign worker
      if (interval.start >= workers.get('C')) {
        schedule.append('C');
        workers.put('C', interval.end);
      } else if (interval.start >= workers.get('J')) {
        schedule.append('J');
        workers.put('J', interval.end);
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
