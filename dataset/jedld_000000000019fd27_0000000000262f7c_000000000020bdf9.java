import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int c = in.nextInt();
      List<int[]> schedules = new ArrayList<int[]>();
      for (int j = 0; j < c; j++) {
        int start = in.nextInt();
        int end = in.nextInt();
        schedules.add(new int[] {start, end, -1});
      }
      String result = solution(schedules);
      if (result != null) {
        System.out.println("Case #" + i + ": " + result);
      } else {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      }
    }
  }

  private static boolean addToBucket(TreeMap<Integer, int[]> schedules, int[] schedule, int index) {
    TreeMap<Integer, int[]> t = (TreeMap<Integer, int[]>) schedules.clone();

    if (t.containsKey(schedule[0])) return false;

    t.put(schedule[0], schedule);

    Iterator<Integer> itr = t.navigableKeySet().iterator();

    Integer prev = itr.next();
    while (itr.hasNext()) {
      int[] current = t.get(prev);
      Integer k = itr.next();
      if (k >= current[1]) {
        prev = k;
      } else {
        return false;
      }
    }

    schedule[2] = index;
    schedules.put(schedule[0], schedule);
    return true;
  };

  private static String solution(List<int[]> schedules) {
    TreeMap<Integer, int[]> bucket1 = new TreeMap<Integer, int[]>();
    TreeMap<Integer, int[]> bucket2 = new TreeMap<Integer, int[]>();

    List<int[]> sortedSched = schedules.stream().sorted(Comparator.comparingInt(a -> a[0])).collect(Collectors.toList());

    for (int[] s : sortedSched) {
      if (!addToBucket(bucket1, s, 0)) {
        if (!addToBucket(bucket2, s, 1)) {
          return null;
        }
      }
    }

    StringBuilder buffer = new StringBuilder();
    for (int[] s : schedules) {
      if (s[2] == 0) {
        buffer.append("C");
      } else {
        buffer.append("J");
      }
    }
    return buffer.toString();
  }
}
