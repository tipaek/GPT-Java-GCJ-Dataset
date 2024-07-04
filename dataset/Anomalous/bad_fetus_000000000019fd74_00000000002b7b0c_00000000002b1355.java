import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());
            for (int t = 1; t <= testCases; t++) {
                int activityCount = Integer.parseInt(scanner.nextLine());
                List<Activity> activities = new ArrayList<>();
                for (int i = 0; i < activityCount; i++) {
                    String[] times = scanner.nextLine().split("\\s+");
                    activities.add(new Activity(Integer.parseInt(times[0]), Integer.parseInt(times[1])));
                }
                
                List<Activity> originalOrder = new ArrayList<>(activities);
                Collections.sort(activities);

                int cameronEnd = 0;
                int jamieEnd = 0;
                boolean[] assignments = new boolean[activityCount];
                boolean possible = true;

                for (Activity activity : activities) {
                    if (activity.startTime >= cameronEnd) {
                        cameronEnd = activity.endTime;
                        assignments[originalOrder.indexOf(activity)] = true;
                    } else if (activity.startTime >= jamieEnd) {
                        jamieEnd = activity.endTime;
                    } else {
                        possible = false;
                        break;
                    }
                }

                StringBuilder result = new StringBuilder("Case #").append(t).append(": ");
                if (possible) {
                    for (boolean assignedToCameron : assignments) {
                        result.append(assignedToCameron ? 'C' : 'J');
                    }
                } else {
                    result.append("IMPOSSIBLE");
                }
                System.out.println(result);
            }
        }
    }
}

class Activity implements Comparable<Activity> {
    int startTime;
    int endTime;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}