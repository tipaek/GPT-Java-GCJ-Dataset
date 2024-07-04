import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final int MINUTES_IN_DAY = 24 * 60 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");
            int numTasks = Integer.parseInt(reader.readLine().trim());
            int[] timeline = new int[MINUTES_IN_DAY];
            int[][] tasks = new int[numTasks][2];

            for (int i = 0; i < numTasks; i++) {
                String[] timeTokens = reader.readLine().trim().split(" ");
                tasks[i][0] = Integer.parseInt(timeTokens[0]);
                tasks[i][1] = Integer.parseInt(timeTokens[1]);

                updateTimeline(timeline, tasks[i][0], 1);
                updateTimeline(timeline, tasks[i][1], -1);
            }

            result.append(assignTasks(numTasks, tasks, timeline)).append("\n");
        }

        System.out.print(result);
    }

    private static void updateTimeline(int[] timeline, int time, int value) {
        if (timeline[time] != 0) {
            timeline[time] = 2;
        } else {
            timeline[time] = value;
        }
    }

    private static String assignTasks(int numTasks, int[][] tasks, int[] timeline) {
        char[] schedule = new char[numTasks];
        boolean cameronFree = true;
        boolean jamieFree = true;

        for (int i = 0; i < MINUTES_IN_DAY; i++) {
            if (timeline[i] == 0) continue;

            if (timeline[i] == 1) {
                int taskIndex = findTaskIndex(tasks, numTasks, i, true);

                if (cameronFree) {
                    cameronFree = false;
                    schedule[taskIndex] = 'C';
                } else if (jamieFree) {
                    jamieFree = false;
                    schedule[taskIndex] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            } else if (timeline[i] == -1) {
                int taskIndex = findTaskIndex(tasks, numTasks, i, false);

                if (schedule[taskIndex] == 'C') {
                    cameronFree = true;
                } else if (schedule[taskIndex] == 'J') {
                    jamieFree = true;
                }
            } else if (timeline[i] == 2) {
                int taskIndex = findTaskIndex(tasks, numTasks, i, false);

                if (schedule[taskIndex] == 'C') {
                    cameronFree = true;
                } else if (schedule[taskIndex] == 'J') {
                    jamieFree = true;
                }

                taskIndex = findTaskIndex(tasks, numTasks, i, true);

                if (cameronFree) {
                    cameronFree = false;
                    schedule[taskIndex] = 'C';
                } else if (jamieFree) {
                    jamieFree = false;
                    schedule[taskIndex] = 'J';
                }
            } else {
                return "ERROR";
            }
        }

        return new String(schedule);
    }

    private static int findTaskIndex(int[][] tasks, int numTasks, int time, boolean isStart) {
        for (int i = 0; i < numTasks; i++) {
            if ((isStart && tasks[i][0] == time) || (!isStart && tasks[i][1] == time)) {
                return i;
            }
        }
        return -1;
    }
}