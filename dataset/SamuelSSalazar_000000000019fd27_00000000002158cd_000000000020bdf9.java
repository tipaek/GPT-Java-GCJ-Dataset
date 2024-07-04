import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int c = 1; c <= t; ++c) {
      int a = in.nextInt();
      List<Activity> activities = new ArrayList<>();
      for (int i = 0; i < a; i++) {
        activities.add(new Activity(i, in.nextInt(), in.nextInt()));
      }
      activities.sort(Comparator.comparingInt(o -> o.start));
      Activity current1 = null, current2 = null;
      boolean impossible = false;
      for (int i = 0; i < activities.size() && !impossible; i++) {
        Activity next = activities.get(i);
        if (current1 == null || next.start >= current1.end) {
          next.assignee = 1;
          current1 = next;
        } else if (current2 == null || next.start >= current2.end) {
          next.assignee = 2;
          current2 = next;
        } else {
          impossible = true;
        }
      }
      if (impossible) {
        System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
      } else {
        activities.sort(Comparator.comparingInt(o -> o.no));
        final String schedule = activities.stream()
                                          .map(activity -> activity.assignee == 1 ? "C" : "J")
                                          .collect(Collectors.joining());
        System.out.println(String.format("Case #%d: %s", c, schedule));
      }
    }
  }

  static class Activity {

    int no, start, end, assignee = -1;

    Activity(int n, int s, int e) {
      this.no = n;
      this.start = s;
      this.end = e;
    }
  }
}