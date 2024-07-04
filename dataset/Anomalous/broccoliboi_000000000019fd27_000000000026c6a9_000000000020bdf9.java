import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = scanner.nextInt();
            scanner.nextLine();
            for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
                int numActivities = scanner.nextInt();
                scanner.nextLine();
                List<Activity> activities = new ArrayList<>();
                for (int i = 0; i < numActivities; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    activities.add(new Activity(i, start, end));
                    scanner.nextLine();
                }
                Collections.sort(activities);
                processActivities(caseNumber, numActivities, activities);
            }
        }
    }

    private static void processActivities(int caseNumber, int numActivities, List<Activity> activities) {
        char[] schedule = new char[numActivities];
        boolean isCFree = true, isJFree = true;
        int cEndTime = -1, jEndTime = -1;

        for (Activity activity : activities) {
            int currentTime = activity.start;

            if (currentTime >= cEndTime) isCFree = true;
            if (currentTime >= jEndTime) isJFree = true;

            if (isCFree) {
                schedule[activity.index] = 'C';
                cEndTime = activity.end;
                isCFree = false;
            } else if (isJFree) {
                schedule[activity.index] = 'J';
                jEndTime = activity.end;
                isJFree = false;
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println(String.valueOf(schedule));
    }

    static class Activity implements Comparable<Activity> {
        int index;
        int start;
        int end;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}