
import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            String schedule = "";
            int[][] cDiary = new int[N][2];
            int[][] jDiary = new int[N][2];
            for (int activityCount = 0; activityCount < N; activityCount++) {
                int s = in.nextInt();
                int e = in.nextInt();
                if (!isOccupied(s, e, cDiary,activityCount)) {
                    schedule = schedule + "C";
                    cDiary[activityCount][0]=s;
                    cDiary[activityCount][1]=e;
                    jDiary[activityCount][0]=-1;
                    jDiary[activityCount][1]=-1;
                }
                else if (!isOccupied(s, e, jDiary,activityCount)) {
                    schedule = schedule + "J";
                    jDiary[activityCount][0]=s;
                    jDiary[activityCount][1]=e;
                    cDiary[activityCount][0]=-1;
                    cDiary[activityCount][1]=-1;
                }
                else {
                    schedule = "IMPOSSIBLE";
                    break;
                }

            }
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    public static  boolean isOccupied(int start, int end, int [][]diary, int activityCount){
        for(int i = 0 ; i<activityCount;i++) { //for each activity in the diary
            int startTimeFromDiary = diary[i][0];
            int endTimeFromDiary = diary[i][1];
            if (!((start <startTimeFromDiary && end<=startTimeFromDiary)
            || start>=endTimeFromDiary)) {
                // occupied for that time. no need to check further.
                return true;
            }
        }
        return false;
    }


}