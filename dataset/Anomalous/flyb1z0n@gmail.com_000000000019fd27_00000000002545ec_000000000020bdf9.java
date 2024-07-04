import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();
            int[][] schedule = new int[activities][2];

            for (int i = 0; i < activities; i++) {
                schedule[i][0] = scanner.nextInt();
                schedule[i][1] = scanner.nextInt();
            }

            String result = assignActivities(schedule);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignActivities(int[][] schedule) {
        boolean[] cameronSchedule = new boolean[1440];
        boolean[] jamesSchedule = new boolean[1440];
        StringBuilder assignment = new StringBuilder();

        for (int[] activity : schedule) {
            int start = activity[0];
            int end = activity[1];

            if (canAssign(cameronSchedule, start, end)) {
                assignment.append("C");
            } else if (canAssign(jamesSchedule, start, end)) {
                assignment.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignment.toString();
    }

    private static boolean canAssign(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }

        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }

        return true;
    }
}