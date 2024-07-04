import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final int TOTAL_TIMELINE = (24 * 60) + 1;
    private Scanner sc;

    public static void main(String[] args) {
        new Solution().processTestCases();
    }

    private void processTestCases() {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= testCases; test++) {
            result.append("Case #").append(test).append(": ");
            int tasks = sc.nextInt();
            StringBuilder taskAssignments = new StringBuilder();
            boolean[] cSchedule = new boolean[TOTAL_TIMELINE];
            boolean[] jSchedule = new boolean[TOTAL_TIMELINE];

            for (int t = 0; t < tasks; t++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                String assignedUser = assignTask(start, end, cSchedule, jSchedule);

                if (assignedUser.isEmpty()) {
                    taskAssignments.setLength(0);
                    taskAssignments.append("IMPOSSIBLE");
                    break;
                } else {
                    taskAssignments.append(assignedUser);
                }
            }

            result.append(taskAssignments).append("\n");
        }

        System.out.print(result.toString());
        sc.close();
    }

    private String assignTask(int start, int end, boolean[] cSchedule, boolean[] jSchedule) {
        boolean cAvailable = isAvailable(start, end, cSchedule);
        boolean jAvailable = isAvailable(start, end, jSchedule);

        if (!cAvailable && !jAvailable) {
            return "";
        }

        if (cAvailable && jAvailable) {
            int cIdleTime = calculateIdleTime(start, end, cSchedule);
            int jIdleTime = calculateIdleTime(start, end, jSchedule);

            if (cIdleTime >= jIdleTime) {
                markSchedule(start, end, cSchedule);
                return "C";
            } else {
                markSchedule(start, end, jSchedule);
                return "J";
            }
        }

        if (cAvailable) {
            markSchedule(start, end, cSchedule);
            return "C";
        } else {
            markSchedule(start, end, jSchedule);
            return "J";
        }
    }

    private boolean isAvailable(int start, int end, boolean[] schedule) {
        for (int i = start + 1; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private int calculateIdleTime(int start, int end, boolean[] schedule) {
        int idleTime = 0;

        for (int i = start - 1; i >= 0; i--) {
            if (schedule[i]) {
                break;
            }
            idleTime++;
        }

        for (int i = end + 1; i < TOTAL_TIMELINE; i++) {
            if (schedule[i]) {
                break;
            }
            idleTime++;
        }

        return idleTime;
    }

    private void markSchedule(int start, int end, boolean[] schedule) {
        for (int i = start; i <= end; i++) {
            schedule[i] = true;
        }
    }
}