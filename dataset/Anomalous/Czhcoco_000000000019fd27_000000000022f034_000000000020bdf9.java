import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(i, start, end));
            }

            Collections.sort(activities, Comparator.comparingInt(a -> a.start));

            int endC = 0, endJ = 0;
            boolean isPossible = true;
            for (Activity activity : activities) {
                if (activity.start >= endC) {
                    activity.assignedTo = 'C';
                    endC = activity.end;
                } else if (activity.start >= endJ) {
                    activity.assignedTo = 'J';
                    endJ = activity.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                activities.sort(Comparator.comparingInt(a -> a.index));
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assignedTo);
                }
                System.out.println(String.format("Case #%d: %s", t, result.toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            }
        }
    }

    static class Activity {
        int index;
        int start;
        int end;
        char assignedTo;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}