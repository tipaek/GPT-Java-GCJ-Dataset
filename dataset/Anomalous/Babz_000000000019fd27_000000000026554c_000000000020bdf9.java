import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            scanner.nextLine();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < activityCount; j++) {
                String[] time = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(time[0]);
                int endTime = Integer.parseInt(time[1]);
                activities.add(new Activity(startTime, endTime));
            }
            String result = assignActivities(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String assignActivities(List<Activity> activities) {
        List<Activity> sortedActivities = activities.stream()
                .sorted(Comparator.comparingInt(Activity::getStartTime))
                .collect(Collectors.toList());

        int cEndTime = 0;
        int jEndTime = 0;

        for (Activity activity : sortedActivities) {
            if (cEndTime <= activity.getStartTime()) {
                cEndTime = activity.getEndTime();
                activity.setAssigned('C');
            } else if (jEndTime <= activity.getStartTime()) {
                jEndTime = activity.getEndTime();
                activity.setAssigned('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return activities.stream()
                .map(Activity::getAssigned)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}

class Activity {
    private final int startTime;
    private final int endTime;
    private char assigned;

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