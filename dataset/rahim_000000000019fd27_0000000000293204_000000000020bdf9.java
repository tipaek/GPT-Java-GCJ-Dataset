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
            res = new ArrayList<>();
            String schedule = schedule(timePairs);
            System.out.println("Case #"+i+": "+schedule);
        }
    }

    public static String schedule(TimePair[] timePairs) {
        schedule(timePairs, 0, "");
        for(String result: res) {
            if(result.length() == timePairs.length) {
                return result;
            }
        }
        return "IMPOSSIBLE";
    }

    static ArrayList<String> res = new ArrayList<String>();
    public static void schedule(TimePair[] timePairs, int index, String schedule) {

        if(!schedule.isBlank()) {
            res.add(schedule);
        }
        if(index == timePairs.length) {
            return;
        }

        Boolean cres = scheduleCameron(timePairs, index, schedule);
        Boolean jres = scheduleJamie(timePairs, index, schedule);
        if(!cres && !jres) {
            return;
        }
    }

    public static Boolean scheduleCameron(TimePair[] timePairs, int index, String schedule) {
        if(canSchedule(timePairs, schedule, 'C', timePairs[index])) {
            schedule += "C";
            schedule(timePairs, index+1, schedule);
            return true;
        }
        return false;
    }

    public static Boolean scheduleJamie(TimePair[] timePairs, int index, String schedule) {
        if(canSchedule(timePairs, schedule, 'J', timePairs[index])) {
            schedule += "J";
            schedule(timePairs, index+1, schedule);
            return true;
        }
        return false;
    }

    static Boolean canSchedule(TimePair[] allSchedules, String madeSchedule, char currentAssigner, TimePair currentActivity) {

        ArrayList<TimePair> schedules = new ArrayList<>();
        char[] madeSchedulesArray = madeSchedule.toCharArray();
        for(int i=0;i<madeSchedulesArray.length; i++) {
            if(madeSchedulesArray[i] == currentAssigner) {
                schedules.add(allSchedules[i]);
            }
        }

        for(TimePair schedule: schedules) {
            if(schedule.startTime<=currentActivity.startTime && schedule.endTime > currentActivity.startTime) {
                return false;
            } else if(schedule.startTime < currentActivity.endTime && schedule.endTime >= currentActivity.endTime) {
                return false;
            } else if (schedule.startTime >=currentActivity.startTime && schedule.endTime <= currentActivity.endTime) {
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



