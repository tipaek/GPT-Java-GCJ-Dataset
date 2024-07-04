import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  private class Interval {
    public int start;
    public int end;
    public String person;
    public int index;
  }

  private Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  private void solve() throws Exception {
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    List<Interval> intervals = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Interval interval = new Interval();
      interval.start = sc.nextInt();
      interval.end = sc.nextInt();
      interval.index = i;
      interval.person = null;
      intervals.add(interval);
    }

    intervals.sort(Comparator.comparingInt((Interval i) -> i.start));

    int cend = 0;
    int jend = 0;

    for (Interval interval : intervals) {
      if (interval.start >= cend) {
        interval.person = "C";
        cend = interval.end;
      }
      else if (interval.start >= jend) {
        interval.person = "J";
        jend = interval.end;
      }
      else {
        System.out.print("IMPOSSIBLE");
        return;
      }
    }

    intervals.sort(Comparator.comparingInt((Interval i) -> i.index));

    for (Interval interval : intervals) {
      sb.append(interval.person);
    }

    System.out.print(sb.toString());
  }

  private void run() throws Exception {
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
      System.out.print("Case #" + i + ": ");
      solve();
      System.out.println();
    }
    sc.close();
    System.out.close();
  }


  public static void main(String[] args) throws Exception {
    new Solution().run();
  }

}