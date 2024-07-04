import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int n = Integer.parseInt(in.next());
            List<Map.Entry<LocalTime, LocalTime>> schedule = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                LocalTime startTime, endTime;
                int start = in.nextInt();
                int end = in.nextInt();

                startTime = getTime(start);
                endTime = getTime(end);
                schedule.add(new AbstractMap.SimpleEntry<LocalTime, LocalTime>(startTime, endTime));
            }

            List<Map.Entry<LocalTime, LocalTime>> jamieSchedule = new ArrayList<>();
            List<Map.Entry<LocalTime, LocalTime>> cameronSchedule = new ArrayList<>();

            StringBuilder sb = new StringBuilder();

            for (int d = 0; d < n; d++) {
                if (jamieSchedule.size() == 0) {
                    jamieSchedule.add(schedule.get(d));
                    sb.append('J');
                } else if (cameronSchedule.size() == 0) {
                    cameronSchedule.add(schedule.get(d));
                    sb.append('C');
                } else {
                    Map.Entry<LocalTime, LocalTime> activitySchedule = schedule.get(d);

                    boolean canSchedule = true;
                    for (Map.Entry<LocalTime, LocalTime> entry : jamieSchedule) {
                        // for start time
                        if (activitySchedule.getKey().isAfter(entry.getKey()) && activitySchedule.getKey().isBefore(entry.getValue())) {
                            canSchedule = false;
                            break;
                        }

                        // for end time
                        if (activitySchedule.getValue().isAfter(entry.getKey()) && activitySchedule.getValue().isBefore(entry.getValue())) {
                            canSchedule = false;
                            break;
                        }

                        // overlapping
                        if (activitySchedule.getKey().isBefore(entry.getKey()) && activitySchedule.getValue().isAfter(entry.getValue())) {
                            canSchedule = false;
                            break;
                        }

                        // 24-hours
                        if (entry.getKey().equals(entry.getValue())) {
                            canSchedule = false;
                            break;
                        }

                    }

                    if (canSchedule) {
                        jamieSchedule.add(activitySchedule);
                        sb.append('J');
                        continue;
                    }

                    boolean canScheduleCam = true;
                    for (Map.Entry<LocalTime, LocalTime> entry : cameronSchedule) {
                        // for start time
                        if (activitySchedule.getKey().isAfter(entry.getKey()) && activitySchedule.getKey().isBefore(entry.getValue())) {
                            canScheduleCam = false;
                            break;
                        }

                        // for end time
                        if (activitySchedule.getValue().isAfter(entry.getKey()) && activitySchedule.getValue().isBefore(entry.getValue())) {
                            canScheduleCam = false;
                            break;
                        }

                        if (activitySchedule.getKey().isBefore(entry.getKey()) && activitySchedule.getValue().isAfter(entry.getValue())) {
                            canScheduleCam = false;
                            break;
                        }

                        // 24-hours
                        if (entry.getKey().equals(entry.getValue())) {
                            canScheduleCam = false;
                            break;
                        }
                    }

                    if (canScheduleCam) {
                        cameronSchedule.add(activitySchedule);
                        sb.append('C');
                    }
                }
            }


            if ((jamieSchedule.size() + cameronSchedule.size()) == n) {
                System.out.println("Case #" + i + ": " + sb.toString().trim());
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
    }

    public static LocalTime getTime(int time) {
        int hours = time/60;
        int minutes = time % 60;
        LocalTime midnight = LocalTime.parse("00:00");
        midnight = midnight.plusHours(hours);
        midnight = midnight.plusMinutes(minutes);
        return midnight;
    }
}