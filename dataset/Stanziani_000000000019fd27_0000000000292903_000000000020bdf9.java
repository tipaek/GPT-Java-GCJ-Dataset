import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      Activity[] col = new Activity[n];
      for (int j = 0; j < n; j++) {
        int start = in.nextInt();
        int end = in.nextInt();
        col[j] = new Activity(start, end);
      }
      Arrays.sort(col);
      String res = solve(col);
      System.out.println("Case #" + i + ": " + res);
    }
  }

  public static String solve(Activity[] arr) {
    String res = "";
    Activity cameronActivity = null;
    Activity jamieActivity = null;
    for (int i = 0; i < arr.length; i++) {
      Activity current = arr[i];
      if (cameronActivity == null || cameronActivity.end <= current.start) {
        cameronActivity = current;
        res += "C";
      } else if (jamieActivity == null || jamieActivity.end <= current.start) {
        jamieActivity = current;
        res += "J";
      } else {
        return "IMPOSSIBLE";
      }
    }
    return res;
  }

  static class Activity implements Comparable<Activity> {

    public int start;
    public int end;

    public Activity(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int compareTo(Activity a2) {
      if (this.start < a2.start) {
        return -1;
      } else if (a2.start < this.start) {
        return 1;
      } else if (this.end < a2.end) {
        return -1;
      } else if (a2.end < this.end) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}

