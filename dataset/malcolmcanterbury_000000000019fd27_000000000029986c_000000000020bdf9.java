
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          List<int[]> activities = new ArrayList<>();
          for (int j = 0; j < n; j++) {
            activities.add(new int[]{in.nextInt(), in.nextInt(), j});
          }
          String schedule = scheduleActivities(activities);
          System.out.println("Case #" + i + ": " + schedule);
        }
    }

    static String scheduleActivities(List<int[]> activities) {
      String[] schedule = new String[activities.size()];
      activities.sort(Comparator.comparingInt(act -> act[0]));

      int c = 0;
      int j = 0;
      for (int[] act: activities) {
        if (c <= act[0]) {
          schedule[act[2]] = "C";
          c = act[1];
        } else if (j <= act[0]){
          schedule[act[2]] = "J";
          j = act[1];
        } else {
          return "IMPOSSIBLE";
        }
      }
      
      StringBuilder res = new StringBuilder();
      for (String str: schedule) {
        res.append(str);
      }
      return res.toString();
    }

}
