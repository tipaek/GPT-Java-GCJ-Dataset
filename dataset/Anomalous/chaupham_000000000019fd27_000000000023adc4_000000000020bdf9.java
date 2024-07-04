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

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][3];

            for (int i = 0; i < numberOfActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            results.add(assignActivities(activities, numberOfActivities, testCase));
        }

        results.forEach(System.out::println);
    }

    private static String assignActivities(int[][] activities, int totalActivities, int testCaseNumber) {
        Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

        String[] schedule = new String[totalActivities];
        if (allocateTasks(activities, 0, 0, 0, schedule)) {
            return formatResult(testCaseNumber, String.join("", schedule));
        }
        return formatResult(testCaseNumber, "IMPOSSIBLE");
    }

    private static boolean allocateTasks(int[][] activities, int current, int cameronEnd, int jamieEnd, String[] schedule) {
        if (current == activities.length) {
            return true;
        }

        int[] activity = activities[current];
        int assignment = determineAssignment(activities, current, cameronEnd, jamieEnd);

        if (assignment == -1) {
            return false;
        }

        boolean isSuccess;
        if (assignment == 0) {
            schedule[activity[2]] = "C";
            isSuccess = allocateTasks(activities, current + 1, activity[1], jamieEnd, schedule);
            if (!isSuccess) {
                schedule[activity[2]] = "J";
                isSuccess = allocateTasks(activities, current + 1, cameronEnd, activity[1], schedule);
            }
        } else if (assignment == 1) {
            schedule[activity[2]] = "C";
            isSuccess = allocateTasks(activities, current + 1, activity[1], jamieEnd, schedule);
        } else {
            schedule[activity[2]] = "J";
            isSuccess = allocateTasks(activities, current + 1, cameronEnd, activity[1], schedule);
        }

        if (!isSuccess) {
            schedule[activity[2]] = null;
        }
        return isSuccess;
    }

    private static int determineAssignment(int[][] activities, int current, int cameronEnd, int jamieEnd) {
        boolean canAssignCameron = cameronEnd <= activities[current][0];
        boolean canAssignJamie = jamieEnd <= activities[current][0];

        if (canAssignCameron && canAssignJamie) {
            return 0;
        } else if (canAssignCameron) {
            return 1;
        } else if (canAssignJamie) {
            return 2;
        } else {
            return -1;
        }
    }

    private static String formatResult(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}