import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] jamieSchedule = new int[1440];
        int[] cameronSchedule = new int[1440];

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            Arrays.fill(jamieSchedule, 0);
            Arrays.fill(cameronSchedule, 0);

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            // Initialize the first interval for Jamie
            for (int j = intervals[0][0]; j < intervals[0][1]; j++) {
                jamieSchedule[j] = 1;
            }

            String result = "J";
            result = assignTasks(jamieSchedule, cameronSchedule, n, 1, intervals, result);
            System.out.println("Case #" + (testCase + 1) + ": " + result);
        }
    }

    private static String assignTasks(int[] jamieSchedule, int[] cameronSchedule, int n, int startIndex, int[][] intervals, String result) {
        for (int i = startIndex; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean canAssignToJamie = true;
            boolean canAssignToCameron = true;

            for (int j = start; j < end; j++) {
                if (jamieSchedule[j] == 1) {
                    canAssignToJamie = false;
                    break;
                }
            }

            for (int j = start; j < end; j++) {
                if (cameronSchedule[j] == 1) {
                    canAssignToCameron = false;
                    break;
                }
            }

            if (canAssignToJamie && !canAssignToCameron) {
                for (int j = start; j < end; j++) {
                    jamieSchedule[j] = 1;
                }
                result += "J";
            } else if (canAssignToCameron && !canAssignToJamie) {
                for (int j = start; j < end; j++) {
                    cameronSchedule[j] = 1;
                }
                result += "C";
            } else if (canAssignToJamie && canAssignToCameron) {
                for (int j = start; j < end; j++) {
                    jamieSchedule[j] = 1;
                }
                String resultJamie = result + "J";
                resultJamie = assignTasks(jamieSchedule, cameronSchedule, n, i + 1, intervals, resultJamie);

                for (int j = start; j < end; j++) {
                    cameronSchedule[j] = 1;
                    jamieSchedule[j] = 0;
                }
                String resultCameron = result + "C";
                resultCameron = assignTasks(jamieSchedule, cameronSchedule, n, i + 1, intervals, resultCameron);

                if (resultJamie.equals("IMPOSSIBLE")) {
                    if (resultCameron.equals("IMPOSSIBLE")) {
                        result = resultJamie;
                    } else {
                        result = resultCameron;
                    }
                } else {
                    result = resultJamie;
                }
                break;
            } else {
                result = "IMPOSSIBLE";
                break;
            }
        }
        return result;
    }
}