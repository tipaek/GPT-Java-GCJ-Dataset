import java.util.*;
import java.io.*;

public class Solution {
   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int n = in.nextInt();
      for (int x = 1; x <= n; x++) {
         findSchedule(in, x);
      }
   }
   
   public static void findSchedule(Scanner in, int x) {
      int n = in.nextInt();
      String out = "";
      Set<int[]> scheduleC = new HashSet<>();
      Set<int[]> scheduleJ = new HashSet<>();
      boolean impossible = false;
      // goes through time of each activity
      for (int i = 0; i < n && !impossible; i++) {
         int start = in.nextInt();
         int end = in.nextInt();
         if (checkAvailability(scheduleC, start, end)) {
            out += "C";
         } else if (checkAvailability(scheduleJ, start, end)) {
            out += "J";
         } else {
            out = "IMPOSSIBLE";
            impossible = true;
         }
      }
      System.out.println("Case #" + x + ": " + out);
   }
   
   public static boolean checkAvailability(Set<int[]> schedule, int start, int end) {
      for (int[] activity : schedule) {
         if ((activity[0] <= start && start < activity[1]) ||
             (activity[0] < end && end <= activity[1])) {
            return false;
         }
      }
      schedule.add(new int[]{start, end});
      return true;
   }
}
