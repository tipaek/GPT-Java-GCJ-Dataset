import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  private static class Interval {
    int start;
    int end;
    String person;
    int index;

    Interval(int start, int end, int index) {
      this.start = start;
      this.end = end;
      this.index = index;
      this.person = null;
    }
  }

  private final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  private void solve() {
    StringBuilder result = new StringBuilder();
    int n = scanner.nextInt();
    List<Interval> intervals = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int start = scanner.nextInt();
      int end = scanner.nextInt();
      intervals.add(new Interval(start, end, i));
    }

    intervals.sort(Comparator.comparingInt(interval -> interval.start));

    int cEnd = 0;
    int jEnd = 0;

    for (Interval interval : intervals) {
      if (interval.start >= cEnd) {
        interval.person = "C";
        cEnd = interval.end;
      } else if (interval.start >= jEnd) {
        interval.person = "J";
        jEnd = interval.end;
      } else {
        System.out.print("IMPOSSIBLE");
        return;
      }
    }

    intervals.sort(Comparator.comparingInt(interval -> interval.index));

    for (Interval interval : intervals) {
      result.append(interval.person);
    }

    System.out.print(result.toString());
  }

  private void run() {
    int t = scanner.nextInt();
    for (int i = 1; i <= t; i++) {
      System.out.print("Case #" + i + ": ");
      solve();
      System.out.println();
    }
    scanner.close();
  }

  public static void main(String[] args) {
    try {
      new Solution().run();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}