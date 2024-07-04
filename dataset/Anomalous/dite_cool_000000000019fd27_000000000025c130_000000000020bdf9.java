import java.io.*;
import java.util.*;

public class ActivityScheduler implements Comparable<ActivityScheduler> {
    private int start, end, index;
    private boolean visited;

    public ActivityScheduler(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.visited = false;
    }

    @Override
    public int compareTo(ActivityScheduler other) {
        if (this.end != other.end) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }

    public static int selectActivities(ActivityScheduler[] activities, int currentIndex, StringBuilder schedule, int totalActivities, String person) {
        int nextIndex = 0;
        if (!activities[currentIndex].visited) {
            int activityIndex = activities[currentIndex].index;
            schedule.setCharAt(activityIndex, person.charAt(0));
            activities[currentIndex].visited = true;
        }
        for (int i = currentIndex + 1; i < totalActivities; i++) {
            if (activities[i].start >= activities[currentIndex].end && !activities[i].visited) {
                int activityIndex = activities[i].index;
                schedule.setCharAt(activityIndex, person.charAt(0));
                currentIndex = i;
                activities[i].visited = true;
            } else if (nextIndex == 0) {
                nextIndex = i;
            }
        }
        return nextIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            ActivityScheduler[] activities = new ActivityScheduler[numActivities];

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new ActivityScheduler(start, end, j);
            }

            StringBuilder schedule = new StringBuilder("0".repeat(numActivities));
            Arrays.sort(activities);

            int nextIndex = selectActivities(activities, 0, schedule, numActivities, "J");
            nextIndex = selectActivities(activities, nextIndex, schedule, numActivities, "C");

            if (schedule.indexOf("0") == -1) {
                results.add(schedule.toString());
            } else {
                results.add("IMPOSSIBLE");
            }
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }

        scanner.close();
    }
}