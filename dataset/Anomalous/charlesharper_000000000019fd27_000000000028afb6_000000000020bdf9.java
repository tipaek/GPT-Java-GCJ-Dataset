import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static String assignTasks(int counter, int[][] tasks, boolean[] cameronSchedule, boolean[] jamieSchedule, String result) {
        if (counter == tasks.length) {
            return result;
        }

        int start = tasks[counter][0];
        int end = tasks[counter][1];

        if (isAvailable(cameronSchedule, start, end)) {
            markSchedule(cameronSchedule, start, end, true);
            String nextResult = assignTasks(counter + 1, tasks, cameronSchedule, jamieSchedule, result + "C");
            if (!nextResult.equals("IMPOSSIBLE")) {
                return nextResult;
            }
            markSchedule(cameronSchedule, start, end, false);
        }

        if (isAvailable(jamieSchedule, start, end)) {
            markSchedule(jamieSchedule, start, end, true);
            String nextResult = assignTasks(counter + 1, tasks, cameronSchedule, jamieSchedule, result + "J");
            if (!nextResult.equals("IMPOSSIBLE")) {
                return nextResult;
            }
            markSchedule(jamieSchedule, start, end, false);
        }

        return "IMPOSSIBLE";
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(boolean[] schedule, int start, int end, boolean value) {
        for (int i = start; i <= end; i++) {
            schedule[i] = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++) {
            int numTasks = Integer.parseInt(br.readLine());
            int[][] tasks = new int[numTasks][2];
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];

            for (int j = 0; j < numTasks; j++) {
                String[] taskTimes = br.readLine().split(" ");
                tasks[j][0] = Integer.parseInt(taskTimes[0]);
                tasks[j][1] = Integer.parseInt(taskTimes[1]);
            }

            String result = assignTasks(0, tasks, cameronSchedule, jamieSchedule, "");
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}