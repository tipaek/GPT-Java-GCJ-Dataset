import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            int cEnd = 0, jEnd = 0;
            char[] schedule = new char[n];
            boolean possible = true;

            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    schedule[activity.index] = 'C';
                    cEnd = activity.end;
                } else if (activity.start >= jEnd) {
                    schedule[activity.index] = 'J';
                    jEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            results[t] = possible ? new String(schedule) : "IMPOSSIBLE";
        }

        for (int i = 0; i < results.length; i++) {
            System.out.printf("Case #%d: %s%n", i + 1, results[i]);
        }
    }

    private static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}