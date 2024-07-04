import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);

    int cases = read.nextInt();

    for (int x = 0; x < cases; x++) {
      int n = read.nextInt();
      TimePeriod[] timePeriods = new TimePeriod[n];
      for (int i = 0; i < n; i++) {
        TimePeriod timePeriod = new TimePeriod();
        int s = read.nextInt();
        int f = read.nextInt();
        timePeriod.start = s;
        timePeriod.end = f;
        timePeriods[i] = timePeriod;
      }


      solve(x + 1, timePeriods);
    }
  }

  static class TimePeriod {
    int start;
    int end;

  }
  public static void solve(int test, TimePeriod[] a) {
    StringBuilder result = new StringBuilder();
    int CUntil = 0;
    int CFrom = 0;
    int JUntil = 0;
    int JFrom = 0;

    for (int j = 0; j < a.length; j++) {
      if (CUntil == 0 || a[j].start >= CUntil || a[j].end <= CFrom) {
        result.append("C");
        CUntil = a[j].end;
        CFrom = a[j].start;
      } else if (JUntil == 0 || a[j].start >= JUntil || a[j].end <= JFrom) {
        result.append("J");
        JUntil = a[j].end;
        JFrom = a[j].start;
      } else {
        System.out.printf("Case #%s: %s \n", test, "IMPOSSIBLE");
        return;
      }
    }

    System.out.printf("Case #%s: %s \n", test, result.toString());
  }
}
