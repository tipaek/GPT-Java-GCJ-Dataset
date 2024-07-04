import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean conflictsWith(Activity other) {
            return (this.start < other.end && this.end > other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = Integer.parseInt(reader.readLine());
            List<Activity> jActivities = new ArrayList<>();
            List<Activity> cActivities = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;

            for (int j = 0; j < activitiesCount; j++) {
                String[] times = reader.readLine().split("\\s+");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                Activity newActivity = new Activity(start, end);

                boolean assigned = false;

                if (canAssignActivity(jActivities, newActivity)) {
                    jActivities.add(newActivity);
                    schedule.append('J');
                    assigned = true;
                } else if (canAssignActivity(cActivities, newActivity)) {
                    cActivities.add(newActivity);
                    schedule.append('C');
                    assigned = true;
                }

                if (!assigned) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                writer.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                writer.println("Case #" + (i + 1) + ": " + schedule.toString());
            }
        }

        reader.close();
        writer.close();
    }

    private static boolean canAssignActivity(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (activity.conflictsWith(newActivity)) {
                return false;
            }
        }
        return true;
    }
}