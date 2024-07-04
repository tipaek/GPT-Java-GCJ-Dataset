import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
  static BufferedReader reader;
  static int N;

  public static void main(String... args) throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    for (int i = 0; i < n; i++) {

      System.out.printf("Case #%d: %s\n", i + 1, do_Test());
    }
  }

  private static class Activity implements Comparable<Activity> {
    int index;
    int start;
    int end;

    public Activity(int index, int start, int end) {
      this.index = index;
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Activity o) {
      return Integer.compare(this.start, o.start);
    }
  }

  private static String do_Test() throws IOException {
    int N = Integer.parseInt(reader.readLine());
    String[] assigned = new String[N];
    Activity[] activities = new Activity[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int start = Integer.parseInt(tokenizer.nextToken());
      int end = Integer.parseInt(tokenizer.nextToken());
      activities[i] = new Activity(i, start, end);
    }
    Arrays.sort(activities);
    int C = 0;
    int J = 0;
    for (Activity activity :
        activities) {
      if (activity.start >= C) {
        assigned[activity.index] = "C";
        C = activity.end;
      } else if (activity.start >= J) {
        assigned[activity.index] = "J";
        J = activity.end;
      } else {
        return "IMPOSSIBLE";
      }
    }
    StringBuilder builder = new StringBuilder();
    for (String s : assigned) {
      builder.append(s);
    }
    return builder.toString();
    //sort by start time, try to assign?
  }
}
