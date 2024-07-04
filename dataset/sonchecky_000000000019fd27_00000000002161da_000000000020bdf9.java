import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int cFree, jFree;
    for (int i = 1; i <= t; ++i) {
      boolean impossible = false;
      int N = in.nextInt();
      cFree = 0;
      jFree = 0;
      ArrayList<Activity> activities = new ArrayList<Activity>(N);
      for (int j = 1; j <= N; j ++) activities.add(new Activity(in.nextInt(), in.nextInt(), j));
      // sort activities by start time
      Collections.sort(activities, new SortByStart());
      for (Activity a : activities) {
        if (a.begin >= cFree) {
          // assign to C
          cFree = a.end;
          a.person = 'C';
        } else if (a.begin >= jFree) {
          jFree = a.end;
          a.person = 'J';
        } else {
          impossible = true;
          break;
        }
      }
      // resort activities by index
      Collections.sort(activities, new SortByIndex());
      if (impossible) System.out.println("Case #" + i + ": IMPOSSIBLE");
      else {
        System.out.print("Case #" + i + ": " );
        for (Activity a : activities) System.out.print(a.person);
        System.out.println();
      }
    }
  }
}

class Activity {
  int begin, end, index;
  char person;
  public Activity (int begin, int end, int index) {
    this.begin = begin;
    this.end = end;
    this.index = index;
  }
}

class SortByStart implements Comparator<Activity> {
  public int compare (Activity a, Activity b) {
    return a.begin - b.begin;
  }
}

class SortByIndex implements Comparator<Activity> {
  public int compare (Activity a, Activity b) {
    return a.index - b.index;
  }
}
