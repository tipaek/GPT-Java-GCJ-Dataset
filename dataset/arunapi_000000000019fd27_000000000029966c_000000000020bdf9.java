
import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < t; ++i) {
            int activities = in.nextInt();
            String schedule = "";
            int[][] activityDiary = new int[activities][2];
            String[] scheduleArr= new String[activities];

            for (int activityCount = 0; activityCount < activities; activityCount++) {
                int s = in.nextInt();
                int e = in.nextInt();
                activityDiary[activityCount][0] = s;
                activityDiary[activityCount][1] = e;
                scheduleArr = scheduler(activityDiary,scheduleArr,activityCount);
                if(scheduleArr[activityCount]==null){
                    schedule = "IMPOSSIBLE";
                    break;
                }
                schedule=schedule+scheduleArr[activityCount];
            }
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    private static String[] scheduler(int[][] activityDiary, String[] scheduleArr, int activityCount) {
        if(activityCount==0){
            scheduleArr[activityCount] = "J";
            return scheduleArr;
        }
        scheduleArr[activityCount] = null;
        int start = activityDiary[activityCount][0];
        int end = activityDiary[activityCount][1];
        boolean isJAlreadyOccupiedForTheTime = false;
        for(int i=0;i < activityCount;i++){ //for each activity in the diary, see who is occupied
            int startTimeFromDiary = activityDiary[i][0];
            int endTimeFromDiary = activityDiary[i][1];
            if (!((start < startTimeFromDiary && end <= startTimeFromDiary)
                    || start >= endTimeFromDiary)) {
                // occupied for that time. no need to check further.
                if(isJAlreadyOccupiedForTheTime){
                    //cannot allocate
                    scheduleArr[activityCount] = null;
                    return scheduleArr;
                }
                else{
                    if("J".equals(scheduleArr[i])){
                        isJAlreadyOccupiedForTheTime = true;
                    }
                }
            }
        }
        if(isJAlreadyOccupiedForTheTime){
            scheduleArr[activityCount] = "C";
        }
        else{
            scheduleArr[activityCount] = "J";
        }
        return scheduleArr;
    }


}