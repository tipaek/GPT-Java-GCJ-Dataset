import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int activitiesCount = in.nextInt();
            in.nextLine();//to consume /n after nextint
            List<Activity> activities = new ArrayList<>();
            for (int j = 1; j <= activitiesCount; j++) {
                String activity = in.nextLine();
                String[] time = activity.split(" ");
                int startTime = Integer.valueOf(time[0]);
                int endTime = Integer.valueOf(time[1]);
                activities.add(new Activity(startTime, endTime));
            }
            String output = getTimeSheet(activities);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String getTimeSheet(List<Activity> activities) {
        List<Activity> sortedByStartTime = activities.stream()
                .sorted(Comparator.comparing(Activity::getStartTime))
                .collect(Collectors.toList());
        int cLastTaskEndTime = 0;
        int jLastTaskEndTime = 0;

        for (int i = 0; i < sortedByStartTime.size(); i++) {
            if (i == 0) {
                cLastTaskEndTime = sortedByStartTime.get(i).getEndTime();
                sortedByStartTime.get(i).setAssigned('C');
            } else {
                // checkifCisBusy
                if (sortedByStartTime.get(i - 1).getAssigned() == 'C') {
                    if (sortedByStartTime.get(i - 1).getEndTime() <= sortedByStartTime.get(i).getStartTime()) {
                        cLastTaskEndTime = sortedByStartTime.get(i).getEndTime();
                        sortedByStartTime.get(i).setAssigned('C');
                    } else {
                        if (jLastTaskEndTime == 0) {
                            jLastTaskEndTime = sortedByStartTime.get(i).getEndTime();
                            sortedByStartTime.get(i).setAssigned('J');
                        } else {
                            if (jLastTaskEndTime <= sortedByStartTime.get(i).getStartTime()) {
                                jLastTaskEndTime = sortedByStartTime.get(i).getEndTime();
                                sortedByStartTime.get(i).setAssigned('J');
                            } else {
                                return "IMPOSSIBLE";
                            }
                        }
                    }
                } else {
                    if (sortedByStartTime.get(i - 1).getEndTime() <= sortedByStartTime.get(i).getStartTime()) {
                        jLastTaskEndTime = sortedByStartTime.get(i).getEndTime();
                        sortedByStartTime.get(i).setAssigned('J');
                    } else {
                        if (cLastTaskEndTime == 0) {
                            cLastTaskEndTime = sortedByStartTime.get(i).getEndTime();
                            sortedByStartTime.get(i).setAssigned('C');
                        } else {
                            if (cLastTaskEndTime <= sortedByStartTime.get(i).getStartTime()) {
                                cLastTaskEndTime = sortedByStartTime.get(i).getEndTime();
                                sortedByStartTime.get(i).setAssigned('C');
                            } else {
                                return "IMPOSSIBLE";
                            }
                        }
                    }
                }

            }

        }
        String result = activities.stream().map(Activity::getAssigned).map(s -> String.valueOf(s))
                .collect(Collectors.joining(""));
        return result;

    }


}

class Activity {
    int startTime;
    int endTime;
    char assigned;

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public char getAssigned() {
        return assigned;
    }

    public void setAssigned(char assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", assigned=" + assigned +
                '}';
    }
}