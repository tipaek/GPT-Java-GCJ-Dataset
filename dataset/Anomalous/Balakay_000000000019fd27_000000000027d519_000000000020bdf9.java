import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];
            List<Activity> cameronSchedule = new ArrayList<>();
            List<Activity> jamieSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < numActivities; j++) {
                activities[j] = new Activity(scanner.nextInt(), scanner.nextInt());
                boolean assigned = false;

                if (j == 0) {
                    cameronSchedule.add(activities[j]);
                    result.append("C");
                    continue;
                }

                if (canBeAssigned(cameronSchedule, activities[j])) {
                    cameronSchedule.add(activities[j]);
                    result.append("C");
                    assigned = true;
                } else if (canBeAssigned(jamieSchedule, activities[j])) {
                    jamieSchedule.add(activities[j]);
                    result.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                results.add(result.toString());
            } else {
                results.add("IMPOSSIBLE");
            }
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static boolean canBeAssigned(List<Activity> schedule, Activity newActivity) {
        for (Activity activity : schedule) {
            if (overlaps(activity, newActivity)) {
                return false;
            }
        }
        return true;
    }

    private static boolean overlaps(Activity a1, Activity a2) {
        return a1.start < a2.end && a2.start < a1.end;
    }
}

class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}