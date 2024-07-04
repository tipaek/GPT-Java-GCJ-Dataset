import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int currentTest = 1;

        while (currentTest <= testCases) {
            int n = scanner.nextInt();
            int lastCameronEnd = 0, lastJamieEnd = 0;
            boolean isImpossible = false;
            char[] schedule = new char[n];
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

            for (Activity activity : activities) {
                if (activity.start >= lastCameronEnd) {
                    schedule[activity.index] = 'C';
                    lastCameronEnd = activity.end;
                } else if (activity.start >= lastJamieEnd) {
                    schedule[activity.index] = 'J';
                    lastJamieEnd = activity.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + currentTest + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + currentTest + ": " + new String(schedule));
            }

            currentTest++;
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