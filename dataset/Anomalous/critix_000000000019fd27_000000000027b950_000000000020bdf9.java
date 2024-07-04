import java.util.*;
import java.io.*;

class Activity {
    final int start;
    final int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(activityCount);

            for (int i = 0; i < activityCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            activities.sort(Comparator.comparingInt((Activity a) -> a.start).thenComparingInt(a -> a.end));

            StringBuilder schedule = new StringBuilder(activityCount);
            int endC = -1, endJ = -1;
            boolean possible = true;

            for (Activity activity : activities) {
                if (endC <= activity.start) {
                    schedule.append('C');
                    endC = activity.end;
                } else if (endJ <= activity.start) {
                    schedule.append('J');
                    endJ = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? schedule.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}