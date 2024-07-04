import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            int[][] camSchedule = new int[numActivities][2];
            int[][] jamSchedule = new int[numActivities][2];
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < numActivities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(camSchedule, start, end)) {
                    result.append('C');
                    assignActivity(camSchedule, activity, start, end);
                } else if (isAvailable(jamSchedule, start, end)) {
                    result.append('J');
                    assignActivity(jamSchedule, activity, start, end);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }

    private static void assignActivity(int[][] schedule, int index, int start, int end) {
        schedule[index][0] = start;
        schedule[index][1] = end;
    }

    private static boolean isAvailable(int[][] schedule, int start, int end) {
        for (int[] activity : schedule) {
            int scheduledStart = activity[0];
            int scheduledEnd = activity[1];

            if (scheduledEnd != 0 && start < scheduledEnd && end > scheduledStart) {
                return false;
            }
        }
        return true;
    }
}