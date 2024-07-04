import java.util.*;
import java.io.*;

class Activity {
    final int start;
    final int end;
    final int index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(numActivities);

            for (int i = 0; i < numActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            activities.sort(Comparator.comparingInt((Activity a) -> a.start)
                                      .thenComparingInt(a -> a.end));

            char[] schedule = new char[numActivities];
            int endCameron = -1;
            int endJamie = -1;
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (endCameron <= activity.start) {
                    schedule[activity.index] = 'C';
                    endCameron = activity.end;
                } else if (endJamie <= activity.start) {
                    schedule[activity.index] = 'J';
                    endJamie = activity.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}