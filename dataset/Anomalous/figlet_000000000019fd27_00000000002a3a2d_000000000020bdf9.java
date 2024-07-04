import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    private static boolean isOverlapping(ArrayList<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if ((activity.start == newActivity.start && activity.end == newActivity.end) ||
                (activity.start < newActivity.start && activity.end > newActivity.start) ||
                (newActivity.start < activity.start && newActivity.end > activity.start)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCases = Integer.parseInt(reader.readLine().trim());
            StringBuilder result = new StringBuilder();

            for (int i = 1; i <= testCases; i++) {
                int activitiesCount = Integer.parseInt(reader.readLine().trim());
                ArrayList<Activity> cameronActivities = new ArrayList<>();
                ArrayList<Activity> jamieActivities = new ArrayList<>();
                boolean possible = true;

                for (int j = 0; j < activitiesCount; j++) {
                    String[] input = reader.readLine().trim().split(" ");
                    int start = Integer.parseInt(input[0]);
                    int end = Integer.parseInt(input[1]);
                    Activity activity = new Activity(start, end);

                    if (!isOverlapping(cameronActivities, activity)) {
                        cameronActivities.add(activity);
                        result.append("C");
                    } else if (!isOverlapping(jamieActivities, activity)) {
                        jamieActivities.add(activity);
                        result.append("J");
                    } else {
                        possible = false;
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        reader.readLine(); // Read and discard the remaining lines for this test case
                        break;
                    }
                }

                System.out.println("Case #" + i + ": " + result.toString());
                result.setLength(0);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

class Activity {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + ":" + end;
    }
}