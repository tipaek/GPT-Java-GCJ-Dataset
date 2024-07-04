import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        short t = in.nextShort(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            short n = in.nextShort();
            StringBuffer activityString = new StringBuffer();
            short[][] cameronActivities = new short[n][2];
            short[][] jamieActivities = new short[n][2];
            short cameronActivityCount = 0;
            short jamieActivityCount = 0;
            for(int j = 0; j < n; j++){
                short startTime = in.nextShort();
                short endTime = in.nextShort();
                if(!isOverlap(cameronActivities, startTime, endTime, cameronActivityCount)){
                    activityString.append("C");
                    cameronActivities[cameronActivityCount][0] = startTime;
                    cameronActivities[cameronActivityCount][1] = endTime;
                    cameronActivityCount++;
                } else if(!isOverlap(jamieActivities, startTime, endTime, jamieActivityCount)){
                    activityString.append("J");
                    jamieActivities[jamieActivityCount][0] = startTime;
                    jamieActivities[jamieActivityCount][1] = endTime;
                    jamieActivityCount++;
                } else {
                    activityString = new StringBuffer("IMPOSSIBLE");
                    break;
                }
            }
          System.out.println("Case #" + i + ": " + (activityString.toString()));
        }
      }
      
      private static boolean isOverlap(short[][] activities, short startTime, short endTime, short activityCount){
          for(int i = 0; i < activityCount; i++){
              short activityStartTime = activities[i][0];
              short activityEndTime = activities[i][1];
              if(!(endTime <= activityStartTime || startTime >= activityEndTime)){
                  return true;
              }
              /*if(startTime >= activityStartTime && startTime < activityEndTime){
                  return true;
              } else if(endTime > activityStartTime && endTime <= activityEndTime) {
                  return true;
              } else if(startTime < activityStartTime && endTime > activityEndTime){
                  return true;
              }*/
          }
          return false;
      }
    }