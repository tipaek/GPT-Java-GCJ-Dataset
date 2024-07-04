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

    private static int parseToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void sortByColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }

    private static void process(int[][] timespan, int numActivities, int testCase) {
        int[] startTimes = new int[numActivities];
        String[] result = new String[numActivities];
        String[] assigned = new String[numActivities];

        for (int i = 0; i < numActivities; i++) {
            startTimes[i] = timespan[i][0];
        }

        sortByColumn(timespan, 0);
        assigned[0] = "C";
        int cEndTime = timespan[0][1];

        for (int i = 1; i < numActivities; i++) {
            if (timespan[i][0] >= cEndTime) {
                assigned[i] = "C";
                cEndTime = timespan[i][1];
            }
        }

        int jStartIdx = 0;
        while (jStartIdx < numActivities && assigned[jStartIdx] != null) {
            jStartIdx++;
        }

        int jEndTime = jStartIdx < numActivities ? timespan[jStartIdx][0] : 0;
        for (int i = jStartIdx; i < numActivities; i++) {
            if (timespan[i][0] >= jEndTime && assigned[i] == null) {
                assigned[i] = "J";
                jEndTime = timespan[i][1];
            }
        }

        for (int i = 0; i < numActivities; i++) {
            for (int j = 0; j < numActivities; j++) {
                if (timespan[i][0] == startTimes[j]) {
                    result[j] = assigned[i];
                    break;
                }
            }
        }

        StringBuilder output = new StringBuilder("Case #" + testCase + ": ");
        if (Arrays.stream(result).anyMatch(Objects::isNull)) {
            output.append("IMPOSSIBLE");
        } else {
            for (String res : result) {
                output.append(res);
            }
        }

        System.out.println(output);
    }
}