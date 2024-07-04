import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            int cEnd = 0, jEnd = 0;
            boolean isImpossible = false;
            char[] result = new char[activitiesCount];

            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    result[activity.index] = 'C';
                    cEnd = activity.end;
                } else if (activity.start >= jEnd) {
                    result[activity.index] = 'J';
                    jEnd = activity.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + new String(result));
            }
        }
    }

    static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}