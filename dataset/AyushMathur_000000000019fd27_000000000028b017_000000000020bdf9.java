import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String[] tokens;

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");

            int N = Integer.parseInt(reader.readLine().trim());

            int[][] tasks = new int[N][2];
            for (int i = 0; i < N; i++) {
                tokens = reader.readLine().trim().split(" ");

                tasks[i][0] = Integer.parseInt(tokens[0]);
                tasks[i][1] = Integer.parseInt(tokens[1]);
            }

            output.append(getAssignedTasks(N, tasks)).append("\n");
        }

        System.out.print(output);
    }

    private static String getAssignedTasks(int n, int[][] tasks) {
        int[] pointers = new int[n];
        for (int i = 0; i < n; i++) {
            pointers[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (tasks[i][0] > tasks[j][0]) {
                    int[] temp1 = tasks[i];
                    tasks[i] = tasks[j];
                    tasks[j] = temp1;

                    int temp2 = pointers[i];
                    pointers[i] = pointers[j];
                    pointers[j] = temp2;
                }
            }
        }

        char[] schedule = new char[n];
        boolean cameronAvailable = true;
        int cameronUnavailableUntil = 0;
        boolean jamieAvailable = true;
        int jamieUnavailableUntil = 0;

        for (int i = 0; i < n; i++) {
            if (cameronUnavailableUntil < tasks[i][0]) {
                cameronAvailable = true;
            }

            if (jamieUnavailableUntil < tasks[i][0]) {
                jamieAvailable = true;
            }

            if (cameronAvailable) {
                cameronAvailable = false;
                cameronUnavailableUntil = tasks[i][1] - 1;
                schedule[pointers[i]] = 'C';
            } else if (jamieAvailable) {
                jamieAvailable = false;
                jamieUnavailableUntil = tasks[i][1] - 1;
                schedule[pointers[i]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.valueOf(schedule);
    }
}
