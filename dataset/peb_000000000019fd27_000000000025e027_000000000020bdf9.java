import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

  public static void main(String[] args) {

    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

      for (int i = 1; i <= t; ++i) {
        String output = parseTest(in);
        printOutput(i, output);
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  private static void printOutput(int i, String value) {
    System.out.println("Case #" + i + ": " + value);
  }

  public static String parseTest(Scanner in) {
    StringBuilder result = new StringBuilder();

    Set<Activity> orderedActivities = new TreeSet<>();
    List<Activity> activities = new ArrayList<>();

    Activity C = new Activity(0, 0);
    Activity J = new Activity(0, 0);

    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int s = in.nextInt();
      int e = in.nextInt();
      Activity activity = new Activity(s, e);
      orderedActivities.add(activity);
      activities.add(activity);
    }

    for (Activity activity : orderedActivities) {
      if (activity.getS() >= C.getE()) {
        C = activity;
        activity.setUser("C");
      } else if (activity.getS() >= J.getE()) {
        J = activity;
        activity.setUser("J");
      } else {
        return "IMPOSSIBLE";
      }
    }

    for (Activity activity : activities) {
      result.append(activity.getUser());
    }

    return result.toString();
  }

  static class Activity implements Comparable {
    private int s;

    private int e;

    private String user;

    Activity(int s, int e) {
      this.s = s;
      this.e = e;
    }

    public int getS() {
      return s;
    }

    public int getE() {
      return e;
    }

    public String getUser() {
      return user;
    }

    public void setUser(String user) {
      this.user = user;
    }

    @Override
    public int compareTo(Object arg0) {

      int compareStart = this.s - ((Activity)arg0).getS();
      if (compareStart != 0) {
        return compareStart;
      } else {
        return this.e - ((Activity)arg0).getE();
      }
    }
  }

}
