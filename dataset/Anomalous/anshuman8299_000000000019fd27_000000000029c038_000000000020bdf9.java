import java.util.*;
import java.io.*;

public class Solution {

    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        if (start > 1440 || end > 1440) return false;
        
        for (int[] slot : schedule) {
            if (slot[0] == 0 && slot[1] == 0) continue;
            if ((slot[0] < start && slot[1] > start) || (slot[0] < end && slot[1] > end)) {
                return false;
            }
        }
        return true;
    }

    private String assignTasks(int[][] tasks) {
        StringBuilder assignedPersons = new StringBuilder();
        int[][] cSchedule = new int[tasks.length][2];
        int[][] jSchedule = new int[tasks.length][2];
        int cCount = 0, jCount = 0;

        for (int i = 0; i < tasks.length; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];

            if (i == 0 || isTimeSlotFree(cSchedule, start, end)) {
                assignedPersons.append("C");
                cSchedule[cCount][0] = start;
                cSchedule[cCount][1] = end;
                cCount++;
            } else if (i == 1 || isTimeSlotFree(jSchedule, start, end)) {
                assignedPersons.append("J");
                jSchedule[jCount][0] = start;
                jSchedule[jCount][1] = end;
                jCount++;
            } else {
                return "IMPOSSIBLE";
            }

            if (start > 1440 || end > 1440) {
                return "IMPOSSIBLE";
            }
        }

        return assignedPersons.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = in.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int taskCount = in.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = in.nextInt();
                tasks[j][1] = in.nextInt();
            }

            String result = solution.assignTasks(tasks);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}