import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 1; i <= numberOfTestCases; i++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][3];

            for (int j = 0; j < numberOfActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                activities[j][2] = j;
            }

            results.add(findSchedule(activities, numberOfActivities, i));
        }

        results.forEach(System.out::println);
    }

    private static String findSchedule(int[][] activities, int total, int testCaseNumber) {
        Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
        String[] schedule = new String[total];

        if (assignActivities(activities, 0, 0, 0, schedule)) {
            return formatResult(testCaseNumber, String.join("", schedule));
        } else {
            return formatResult(testCaseNumber, "IMPOSSIBLE");
        }
    }

    private static boolean assignActivities(int[][] activities, int current, int cameronEnd, int jamieEnd, String[] schedule) {
        if (current == activities.length) {
            return true;
        }

        int[] activity = activities[current];
        int assignment = determineAssignment(activities, current, cameronEnd, jamieEnd);

        if (assignment == -1) {
            return false;
        }

        boolean success;
        if (assignment == 0 || assignment == 1) {
            schedule[activity[2]] = "C";
            success = assignActivities(activities, current + 1, activity[1], jamieEnd, schedule);
        } else {
            schedule[activity[2]] = "J";
            success = assignActivities(activities, current + 1, cameronEnd, activity[1], schedule);
        }

        if (!success) {
            schedule[activity[2]] = null;
        }

        return success;
    }

    private static int determineAssignment(int[][] activities, int current, int cameronEnd, int jamieEnd) {
        boolean canAssignToCameron = cameronEnd <= activities[current][0];
        boolean canAssignToJamie = jamieEnd <= activities[current][0];

        if (canAssignToCameron && canAssignToJamie) {
            return 0;
        } else if (canAssignToCameron) {
            return 1;
        } else if (canAssignToJamie) {
            return 2;
        } else {
            return -1;
        }
    }

    private static String formatResult(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}