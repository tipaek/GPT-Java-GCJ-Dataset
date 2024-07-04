import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            PriorityQueue<Activity> activitiesQueue = new PriorityQueue<>(
                Comparator.comparingInt((Activity a) -> a.start)
                          .thenComparingInt(a -> a.end)
            );

            for (int i = 0; i < activitiesCount; i++) {
                activitiesQueue.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;
            char[] schedule = new char[activitiesCount];

            while (!activitiesQueue.isEmpty()) {
                Activity currentActivity = activitiesQueue.poll();
                
                if (cameronEnd <= currentActivity.start) {
                    cameronEnd = currentActivity.end;
                    schedule[currentActivity.index] = 'C';
                } else if (jamieEnd <= currentActivity.start) {
                    jamieEnd = currentActivity.end;
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