import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            PriorityQueue<Activity> activityQueue = new PriorityQueue<>((a, b) -> {
                if (a.end == b.end) {
                    return a.start - b.start;
                }
                return a.end - b.end;
            });

            for (int i = 0; i < numActivities; i++) {
                activityQueue.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            int cEnd = 0, jEnd = 0;
            boolean impossible = false;
            char[] schedule = new char[numActivities];

            while (!activityQueue.isEmpty()) {
                Activity currentActivity = activityQueue.poll();

                if (cEnd <= currentActivity.start) {
                    cEnd = currentActivity.end;
                    schedule[currentActivity.index] = 'C';
                } else if (jEnd <= currentActivity.start) {
                    jEnd = currentActivity.end;
                    schedule[currentActivity.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + new String(schedule));
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