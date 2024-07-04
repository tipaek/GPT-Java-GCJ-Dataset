import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            TimePair[] timePairs = new TimePair[n];
            for(int j=0;j< n; j++) {
                timePairs[j] = new TimePair(in.nextInt(), in.nextInt());
            }
            String schedule = schedule(timePairs);
            System.out.println("Case #"+i+": "+schedule);
        }
    }

    public static String schedule(TimePair[] timePairs) {
        ArrayList<TimePair> selectedScheduleCameron = new ArrayList();
        ArrayList<TimePair> selectedScheduleJamie = new ArrayList();
        String schedule = "";

        for(int i=0;i<timePairs.length;i++) {
            if(canSchedule(selectedScheduleCameron, timePairs[i])) {
                schedule += "C";
                selectedScheduleCameron.add(timePairs[i]);
            } else if(canSchedule(selectedScheduleJamie, timePairs[i])) {
                schedule += "J";
                selectedScheduleJamie.add(timePairs[i]);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule;
    }

    static Boolean canSchedule(ArrayList<TimePair> schedules, TimePair currentActivity) {
        for(TimePair schedule: schedules) {
            if(((currentActivity.startTime < schedule.startTime && currentActivity.endTime < schedule.endTime && currentActivity.endTime < schedule.startTime)
            || currentActivity.startTime >= schedule.endTime)) {

            } else {
                return false;
            }
        }
        return true;
    }
}
class TimePair {
    int startTime;
    int endTime;

    public TimePair(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}