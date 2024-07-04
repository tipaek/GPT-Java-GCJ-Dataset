import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int numActivities = scanner.nextInt();
            int[][] timespan = new int[numActivities][2];
            scanner.nextLine();

            for (int i = 0; i < numActivities; i++) {
                String[] input = scanner.nextLine().split(" ");
                timespan[i][0] = parseInt(input[0]);
                timespan[i][1] = parseInt(input[1]);
            }

            process(timespan, numActivities, testCase);
        }
        scanner.close();
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[col]));
    }

    private static void process(int[][] timespan, int numActivities, int testCase) {
        int[] startTimes = new int[numActivities];
        String[] result = new String[numActivities];

        for (int i = 0; i < numActivities; i++) {
            startTimes[i] = timespan[i][0];
        }

        sortbyColumn(timespan, 0);
        String[] assignments = new String[numActivities];
        assignments[0] = "C";
        int endC = timespan[0][1];

        for (int i = 1; i < numActivities; i++) {
            if (timespan[i][0] >= endC) {
                assignments[i] = "C";
                endC = timespan[i][1];
            }
        }

        int startJ = 0;
        for (int i = 0; i < numActivities; i++) {
            if (assignments[i] == null) {
                startJ = i;
                break;
            }
        }

        int endJ = timespan[startJ][0];
        for (int i = startJ; i < numActivities; i++) {
            if (timespan[i][0] >= endJ && assignments[i] == null) {
                assignments[i] = "J";
                endJ = timespan[i][1];
            }
        }

        for (int i = 0; i < numActivities; i++) {
            for (int j = 0; j < numActivities; j++) {
                if (timespan[i][0] == startTimes[j]) {
                    result[j] = assignments[i];
                }
            }
        }

        boolean isImpossible = Arrays.stream(result).anyMatch(Objects::isNull);

        StringBuilder output = new StringBuilder();
        if (isImpossible) {
            output.append("IMPOSSIBLE");
        } else {
            for (String res : result) {
                output.append(res);
            }
        }

        System.out.println("Case #" + testCase + ": " + output.toString());
    }
}