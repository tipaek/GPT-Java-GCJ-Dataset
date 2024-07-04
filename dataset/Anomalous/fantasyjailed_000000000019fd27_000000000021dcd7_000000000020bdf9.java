import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static class Activity implements Comparable<Activity> {
        Integer start;
        Integer finish;

        public Activity(Integer start, Integer finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Activity other) {
            return this.start.compareTo(other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
                startTimes[i] = start;
                endTimes[i] = end;
            }

            Arrays.sort(startTimes);
            Arrays.sort(endTimes);
            Arrays.sort(activities);

            boolean conflictFound = false;
            for (int i = 0; i < n - 2 && !conflictFound; i++) {
                if (endTimes[i] > startTimes[i + 2] || 
                    (startTimes[i] == startTimes[i + 1] && startTimes[i] == startTimes[i + 2]) ||
                    (endTimes[i] == endTimes[i + 1] && endTimes[i] == endTimes[i + 2])) {
                    conflictFound = true;
                }
            }

            StringBuilder result = new StringBuilder();
            if (conflictFound) {
                result.append("IMPOSSIBLE");
            } else {
                Activity jamie = activities[0];
                Activity cameron = activities[1];
                result.append("JC");
                for (int i = 2; i < n; i++) {
                    Activity current = activities[i];
                    if (current.start >= jamie.finish) {
                        result.append("J");
                        jamie = current;
                    } else if (current.start >= cameron.finish) {
                        result.append("C");
                        cameron = current;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %s", caseNum, result.toString()));
        }
    }
}