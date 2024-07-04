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
   
   public static class Event implements Comparable<Event> {
      int start;
      int end;
      int index;
      char parent;
      public Event(int start, int end, int index) {
         this.start = start;
         this.end = end;
         this.index = index;
      }
      
      public void assign(char c) {
         parent = c;
      }
      
      public String toString() {
         return start + " " + end;
      }
      
      public int compareTo(Event other) {
         return this.start - other.start;
      }
   }
   
   public static void findSchedule(Scanner in, int x) {
      int n = in.nextInt();
      String out = "";
      Event[] events = new Event[n];
      for (int i = 0; i < n; i++) {
         events[i] = new Event(in.nextInt(), in.nextInt(), i);
      }
      Event[] sortedEvents = events.clone();
      Arrays.sort(sortedEvents);
      
      Set<int[]> scheduleC = new HashSet<>();
      Set<int[]> scheduleJ = new HashSet<>();
      boolean impossible = false;
      // goes through time of each activity
      for (int i = 0; i < n && !impossible; i++) {
         int start = sortedEvents[i].start;
         int end = sortedEvents[i].end;
         if (checkAvailability(scheduleC, start, end)) {
            sortedEvents[i].assign('C');
         } else if (checkAvailability(scheduleJ, start, end)) {
            sortedEvents[i].assign('J');
         } else {
            out = "IMPOSSIBLE";
            impossible = true;
         }
      }
      for (int i = 0; i < n && !impossible; i++) {
         out += events[i].parent;
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
