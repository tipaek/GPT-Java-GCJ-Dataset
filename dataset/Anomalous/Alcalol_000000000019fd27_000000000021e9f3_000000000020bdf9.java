import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseCount = scanner.nextInt();

        for (int i = 1; i <= caseCount; i++) {
            processCase(i, scanner);
        }
    }

    private static void processCase(int caseNumber, Scanner scanner) {
        int activityCount = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < activityCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(i, start, end));
        }

        String result = scheduleActivities(activities);
        printResult(caseNumber, result);
    }

    private static String scheduleActivities(List<Activity> activities) {
        int[] cameronSchedule = new int[1440];
        int[] jamieSchedule = new int[1440];
        Arrays.fill(cameronSchedule, -1);
        Arrays.fill(jamieSchedule, -1);

        Collections.sort(activities);

        for (Activity activity : activities) {
            if (canSchedule(activity, cameronSchedule)) {
                activity.assignedTo = 'C';
                assignToSchedule(activity, cameronSchedule);
            } else if (canSchedule(activity, jamieSchedule)) {
                activity.assignedTo = 'J';
                assignToSchedule(activity, jamieSchedule);
            } else {
                return "IMPOSSIBLE";
            }
        }

        Collections.sort(activities, Comparator.comparingInt(a -> a.index));
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.assignedTo);
        }
        return result.toString();
    }

    private static boolean canSchedule(Activity activity, int[] schedule) {
        for (int i = activity.startTime; i < activity.endTime; i++) {
            if (schedule[i] != -1) {
                return false;
            }
        }
        return true;
    }

    private static void assignToSchedule(Activity activity, int[] schedule) {
        Arrays.fill(schedule, activity.startTime, activity.endTime, activity.index);
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}

class Activity implements Comparable<Activity> {
    int index;
    int startTime;
    int endTime;
    char assignedTo;

    Activity(int index, int startTime, int endTime) {
        this.index = index;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}