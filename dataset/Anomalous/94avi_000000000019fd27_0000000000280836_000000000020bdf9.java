import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            List<Activity> activities = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String[] times = br.readLine().split(" ");
                int startTime = Integer.parseInt(times[0]);
                int endTime = Integer.parseInt(times[1]);
                activities.add(new Activity(i, startTime, endTime));
            }

            Collections.sort(activities);

            List<Activity> cActivities = new ArrayList<>();
            List<Activity> jActivities = new ArrayList<>();
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (canAddActivity(jActivities, activity)) {
                    activity.setAssignedTo("J");
                    jActivities.add(activity);
                } else if (canAddActivity(cActivities, activity)) {
                    activity.setAssignedTo("C");
                    cActivities.add(activity);
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? generateResultString(activities) : "IMPOSSIBLE";
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static boolean canAddActivity(List<Activity> activities, Activity newActivity) {
        return activities.isEmpty() || activities.get(activities.size() - 1).getEndTime() <= newActivity.getStartTime();
    }

    private static String generateResultString(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(Activity::getId));
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getAssignedTo());
        }
        return result.toString();
    }
}

class Activity implements Comparable<Activity> {
    private final int id;
    private final int startTime;
    private final int endTime;
    private String assignedTo;

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

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}