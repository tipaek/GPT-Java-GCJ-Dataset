import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int index;
        char assignedTo;
        int start;
        int end;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(i, start, end));
            }

            Collections.sort(activities, (a1, a2) -> a1.start == a2.start ? a1.end - a2.end : a1.start - a2.start);

            int endJ = 0, endC = 0;
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (Activity activity : activities) {
                if (activity.start >= endJ) {
                    activity.assignedTo = 'J';
                    endJ = activity.end;
                } else if (activity.start >= endC) {
                    activity.assignedTo = 'C';
                    endC = activity.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                Collections.sort(activities, (a1, a2) -> a1.index - a2.index);
                for (Activity activity : activities) {
                    result.append(activity.assignedTo);
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}