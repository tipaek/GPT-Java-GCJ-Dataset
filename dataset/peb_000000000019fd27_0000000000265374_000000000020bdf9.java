
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

    List<Activity> activities = new ArrayList<>();
    Set<Activity> orderedActivities = new TreeSet<>();

    Activity C = null;
    Activity J = null;

    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      Activity activity = new Activity(in.nextInt(), in.nextInt());

      orderedActivities.add(activity);
      activities.add(activity);
    }

    for (Activity activity : orderedActivities) {
      if (C == null || activity.getS() >= C.getE()) {
        C = activity;
        activity.setUser("C");
      } else if (J == null || activity.getS() >= J.getE()) {
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

  static class Activity implements Comparable<Activity> {
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
    public int compareTo(Activity arg0) {
      int compareStart = this.s - arg0.getS();
      return compareStart != 0 ? compareStart : this.hashCode() - arg0.hashCode();
    }
  }

}
