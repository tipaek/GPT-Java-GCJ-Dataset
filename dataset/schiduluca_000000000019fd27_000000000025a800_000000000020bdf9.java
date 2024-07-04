import java.util.Scanner;
import java.util.Arrays;

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
    int CUntil = -1;
    int CFrom = -1;
    int JUntil = -1;
    int JFrom = -1;

    int[] ints = Arrays.stream(a).mapToInt(t -> t.start).toArray();
    int[] ends = Arrays.stream(a).mapToInt(t -> t.end).toArray();
    if (maxOverlapIntervalCount(ints, ends) > 2) {
      System.out.printf("Case #%s: %s \n", test, "IMPOSSIBLE");
      return;
    }

    for (int j = 0; j < a.length; j++) {
      if (CUntil == -1 || a[j].start >= CUntil || a[j].end <= CFrom) {
        result.append("C");
        CUntil = a[j].end;
        CFrom = a[j].start;
      } else {
        result.append("J");
        JUntil = a[j].end;
        JFrom = a[j].start;
      }
    }

    System.out.printf("Case #%s: %s \n", test, result.toString());
  }

  public static int maxOverlapIntervalCount(int[] start, int[] end){
    int maxOverlap = 0;
    int currentOverlap = 0;

    Arrays.sort(start);
    Arrays.sort(end);

    int i = 0;
    int j = 0;
    int m=start.length,n=end.length;
    while(i< m && j < n){
      if(start[i] < end[j]){
        currentOverlap++;
        maxOverlap = Math.max(maxOverlap, currentOverlap);
        i++;
      }
      else{
        currentOverlap--;
        j++;
      }
    }

    return maxOverlap;
  }
}
