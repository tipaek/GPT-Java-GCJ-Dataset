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
      Map<Integer, Integer> scheduleC = new HashMap<>();
      Map<Integer, Integer> scheduleJ = new HashMap<>();
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
   
   public static boolean checkAvailability(Map<Integer, Integer> schedule, int start, int end) {
      for (int time : schedule.keySet()) {
         if ((time < start && start < schedule.get(time)) ||
             (time < end && end < schedule.get(time))) {
            return false;
         }
      }
      schedule.put(start, end);
      return true;
   }
}
