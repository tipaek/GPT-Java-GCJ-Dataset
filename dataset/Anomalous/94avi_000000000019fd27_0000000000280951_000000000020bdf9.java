import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            int activityCount = Integer.parseInt(br.readLine());
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                String[] times = br.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities.add(new Activity(i, start, end));
            }

            Collections.sort(activities);

            List<Activity> cSchedule = new ArrayList<>();
            List<Activity> jSchedule = new ArrayList<>();
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (canSchedule(jSchedule, activity)) {
                    activity.setName("J");
                    jSchedule.add(activity);
                } else if (canSchedule(cSchedule, activity)) {
                    activity.setName("C");
                    cSchedule.add(activity);
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? buildResult(activities) : "IMPOSSIBLE";
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static boolean canSchedule(List<Activity> schedule, Activity activity) {
        return schedule.isEmpty() || activity.getStartTime() >= schedule.get(schedule.size() - 1).getEndTime();
    }

    private static String buildResult(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(Activity::getId));
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getName());
        }
        return result.toString();
    }
}

class Activity implements Comparable<Activity> {
    private final int id;
    private final int startTime;
    private final int endTime;
    private String name;

    public Activity(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}