import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];

            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            int[] indices = sortActivities(activities);

            // Debugging output (can be removed)
            for (int i = 0; i < activitiesCount; i++) {
                System.out.println("Pos: " + indices[i] + ", Start: " + activities[i][0] + ", End: " + activities[i][1]);
            }

            String result = scheduleActivities(activities, indices);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static int[] sortActivities(int[][] activities) {
        int length = activities.length;
        int[] indices = new int[length];

        for (int i = 0; i < length; i++) {
            indices[i] = i;
        }

        for (int i = 1; i < length; i++) {
            int[] key = activities[i];
            int indexKey = indices[i];
            int j = i - 1;

            while (j >= 0 && activities[j][0] > key[0]) {
                activities[j + 1] = activities[j];
                indices[j + 1] = indices[j];
                j--;
            }

            activities[j + 1] = key;
            indices[j + 1] = indexKey;
        }

        return indices;
    }

    private static String scheduleActivities(int[][] activities, int[] indices) {
        int cEnd = 0;
        int jEnd = 0;
        boolean isImpossible = false;
        String[] schedule = new String[activities.length];

        for (int i = 0; i < activities.length; i++) {
            if (cEnd <= activities[i][0]) {
                schedule[indices[i]] = "C";
                cEnd = activities[i][1];
            } else if (jEnd <= activities[i][0]) {
                schedule[indices[i]] = "J";
                jEnd = activities[i][1];
            } else {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            return "IMPOSSIBLE";
        }

        StringBuilder result = new StringBuilder();
        for (String s : schedule) {
            result.append(s);
        }

        return result.toString();
    }
}