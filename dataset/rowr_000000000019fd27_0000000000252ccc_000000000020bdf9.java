import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] activities = new int[n][2];
      for(int j = 0; j<n; j++){
        activities[j][0] = in.nextInt();
        activities[j][1] = in.nextInt();
      }
      Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
      String results = partnering(activities);
      System.out.println("Case #" + i + ": " + results);
    }
  }
  
  public static String partnering(int[][] activities){
      String schedule = "";
      int[] cameron = new int[2];
      int[] jamie = new int[2];
      int[] activity = new int[2];
      activity[0] = activities[0][0];
      activity[1] = activities[0][1];
      schedule = schedule + "C";
      cameron = Arrays.copyOf(activity, activity.length);
      for(int i=1; i<activities.length; i++){
          activity[0] = activities[i][0];
          activity[1] = activities[i][1];
          if(activity[0] >= cameron[1]){
              cameron = Arrays.copyOf(activity, activity.length);
              schedule = schedule + "C";
          }
          else{
              if(activity[0] >= jamie[1]){
                  jamie = Arrays.copyOf(activity, activity.length);
                  schedule = schedule + "J";
              }
              else return "IMPOSSIBLE";
          }
      }
      return schedule;
  }

  
 }