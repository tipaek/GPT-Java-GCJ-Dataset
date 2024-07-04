import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    private static final int limit = 24 * 60 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String[] tokens;

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");

            int N = Integer.parseInt(reader.readLine().trim());

            int[] timeline = new int[limit];
            int[][] tasks = new int[N][2];
            for (int i = 0; i < N; i++) {
                tokens = reader.readLine().trim().split(" ");

                tasks[i][0] = Integer.parseInt(tokens[0]);
                tasks[i][1] = Integer.parseInt(tokens[1]);

                if (timeline[tasks[i][0]] != 0) {
                    timeline[tasks[i][0]] = 2;
                } else {
                    timeline[tasks[i][0]] = 1;
                }

                if (timeline[tasks[i][1]] != 0) {
                    timeline[tasks[i][1]] = 2;
                } else {
                    timeline[tasks[i][1]] = -1;
                }
            }

            output.append(getAssignedTasks(N, tasks, timeline)).append("\n");
        }

        System.out.print(output);
    }

    private static String getAssignedTasks(int n, int[][] tasks, int[] timeline) {
        char[] schedule = new char[n];
        boolean cameronAvailable = true;
        boolean jamieAvailable = true;

        for (int i = 0; i < limit; i++) {
            if (timeline[i] == 0) {
                continue;
            }

            if (timeline[i] == 1) {
                int taskIndex = getTaskIndexFromStart(n, tasks, i);

                if (cameronAvailable) {
                    cameronAvailable = false;
                    schedule[taskIndex] = 'C';
                } else if (jamieAvailable) {
                    jamieAvailable = false;
                    schedule[taskIndex] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            } else if (timeline[i] == -1) {
                int taskIndex = getTaskIndexFromEnd(n, tasks, i);

                if (schedule[taskIndex] == 'C') {
                    cameronAvailable = true;
                } else if (schedule[taskIndex] == 'J') {
                    jamieAvailable = true;
                }
            } else if (timeline[i] == 2) {
                int taskIndex = getTaskIndexFromEnd(n, tasks, i);

                if (schedule[taskIndex] == 'C') {
                    cameronAvailable = true;
                } else if (schedule[taskIndex] == 'J') {
                    jamieAvailable = true;
                }

                taskIndex = getTaskIndexFromStart(n, tasks, i);

                if (cameronAvailable) {
                    cameronAvailable = false;
                    schedule[taskIndex] = 'C';
                } else if (jamieAvailable) {
                    jamieAvailable = false;
                    schedule[taskIndex] = 'J';
                }
            } else {
                return "ERROR";
            }
        }

        return String.valueOf(schedule);
    }

    private static int getTaskIndexFromStart(int n, int[][] tasks, int start) {
        for (int i = 0; i < n; i++) {
            if (tasks[i][0] == start) {
                return i;
            }
        }

        return -1;
    }

    private static int getTaskIndexFromEnd(int n, int[][] tasks, int end) {
        for (int i = 0; i < n; i++) {
            if (tasks[i][1] == end) {
                return i;
            }
        }

        return -1;
    }
}
