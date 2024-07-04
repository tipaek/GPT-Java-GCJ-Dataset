import java.util.*;
import java.io.*;
public class Solution {
    
    public static Boolean overlaps(ArrayList<ArrayList<Integer>> schedule, int start, int end) {
        for (ArrayList<Integer> activity: schedule) {
            int activityStart = activity.get(0);
            int activityEnd = activity.get(1);
            
            if ((start >= activityStart && start < activityEnd) || (end > activityStart && end < activityEnd)){
                return true;
            }
        }
        return false;
    }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test_cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= test_cases; ++i) {
      int n = in.nextInt();
      
      ArrayList<ArrayList<Integer>> cameronSchedule = new ArrayList<ArrayList<Integer>>();
      ArrayList<ArrayList<Integer>> jameySchedule = new ArrayList<ArrayList<Integer>>();
      String output = ""; 
      
      for(int j = 0; j < n; j++) {
         int activityStart = in.nextInt();
         int activityEnd = in.nextInt();
         
         ArrayList<Integer> activity = new ArrayList<Integer>();
         activity.add(activityStart);
         activity.add(activityEnd);
         
         if (!overlaps(cameronSchedule, activityStart, activityEnd)){
             cameronSchedule.add(activity);
             output += "C";
         }
        else if (!overlaps(jameySchedule, activityStart, activityEnd)){
             jameySchedule.add(activity);
             output += "J";
         }
         else {
             output = "IMPOSSIBLE";
             break;
         }
      }
      System.out.println("Case #" + i + ": " + output);
    }
  }
}
