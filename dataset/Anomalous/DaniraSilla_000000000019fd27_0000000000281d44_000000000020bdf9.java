import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Activity {
        int start;
        int end;
        int index;
        String person;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static String solve(Activity[] activities) {
        int n = activities.length;
        boolean isCameronFree = true;
        boolean isJamieFree = true;
        int lastCameronIndex = -1;
        int lastJamieIndex = -1;

        for (int i = 0; i < n; i++) {
            int currentStartTime = activities[i].start;
            if (isCameronFree) {
                isCameronFree = false;
                lastCameronIndex = i;
                activities[i].person = "C";
            } else if (activities[lastCameronIndex].end <= currentStartTime) {
                lastCameronIndex = i;
                activities[i].person = "C";
            } else if (isJamieFree) {
                isJamieFree = false;
                lastJamieIndex = i;
                activities[i].person = "J";
            } else if (activities[lastJamieIndex].end <= currentStartTime) {
                lastJamieIndex = i;
                activities[i].person = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a.index));
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.person);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
            String result = solve(activities);

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}