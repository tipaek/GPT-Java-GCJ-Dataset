import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int testCase = 0; testCase < numTestCases; testCase++) {
            int numActivities = scanner.nextInt();
            int[][] timespan = new int[numActivities][2];
            scanner.nextLine();

            for (int i = 0; i < numActivities; i++) {
                String[] input = scanner.nextLine().split(" ");
                timespan[i][0] = parseToInt(input[0]);
                timespan[i][1] = parseToInt(input[1]);
            }

            process(timespan, numActivities, testCase + 1);
        }
        scanner.close();
    }

    private static int parseToInt(String strNum) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }

    private static void process(int[][] activities, int numActivities, int testCaseNumber) {
        int[] startTimes = new int[numActivities];
        String[] result = new String[numActivities];

        for (int i = 0; i < numActivities; i++) {
            startTimes[i] = activities[i][0];
        }

        sortbyColumn(activities, 0);
        String[] assignments = new String[numActivities];
        assignments[0] = "C";
        int cEnd = activities[0][1];
        int jEnd = 0;

        for (int i = 1; i < numActivities; i++) {
            if (activities[i][0] >= cEnd) {
                assignments[i] = "C";
                cEnd = activities[i][1];
            } else if (activities[i][0] >= jEnd) {
                assignments[i] = "J";
                jEnd = activities[i][1];
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        for (int i = 0; i < numActivities; i++) {
            for (int j = 0; j < numActivities; j++) {
                if (startTimes[i] == activities[j][0]) {
                    result[i] = assignments[j];
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + String.join("", result));
    }
}