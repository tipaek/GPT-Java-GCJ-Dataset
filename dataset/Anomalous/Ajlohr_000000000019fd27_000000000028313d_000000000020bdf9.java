import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            int cEndTime = 0;
            int jEndTime = 0;
            char[] schedule = new char[n];

            boolean isPossible = true;

            for (Activity activity : activities) {
                if (activity.start >= cEndTime) {
                    schedule[activity.index] = 'C';
                    cEndTime = activity.end;
                } else if (activity.start >= jEndTime) {
                    schedule[activity.index] = 'J';
                    jEndTime = activity.end;
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(schedule));
            }
        }

        scanner.close();
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}