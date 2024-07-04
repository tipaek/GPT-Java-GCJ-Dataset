import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String activityString = "";
            int[][] cameronActivities = new int[n][2];
            int[][] jamieActivities = new int[n][2];
            int cameronActivityCount = 0;
            int jamieActivityCount = 0;
            for(int j = 0; j < n; j++){
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                if(!isOverlap(cameronActivities, startTime, endTime, cameronActivityCount)){
                    activityString += "C";
                    cameronActivities[cameronActivityCount][0] = startTime;
                    cameronActivities[cameronActivityCount][1] = endTime;
                    cameronActivityCount++;
                } else if(!isOverlap(jamieActivities, startTime, endTime, jamieActivityCount)){
                    activityString += "J";
                    jamieActivities[jamieActivityCount][0] = startTime;
                    jamieActivities[jamieActivityCount][1] = endTime;
                    jamieActivityCount++;
                } else {
                    activityString = "IMPOSSIBLE";
                    break;
                }
            }
          System.out.println("Case #" + i + ": " + (activityString));
        }
      }
      
      private static boolean isOverlap(int[][] activities, int startTime, int endTime, int activityCount){
          for(int i = 0; i < activityCount; i++){
              int activityStartTime = activities[i][0];
              int activityEndTime = activities[i][1];
              if(startTime >= activityStartTime && startTime < activityEndTime){
                  return true;
              } else if(endTime >= activityStartTime && endTime <= activityEndTime) {
                  return true;
              } else if(startTime <= activityStartTime && endTime >= activityEndTime){
                  return true;
              }
          }
          return false;
      }
    }