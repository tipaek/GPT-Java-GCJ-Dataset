import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");

            int N = Integer.parseInt(reader.readLine().trim());
            int[][] tasks = new int[N][3];

            for (int i = 0; i < N; i++) {
                String[] tokens = reader.readLine().trim().split(" ");
                tasks[i][0] = Integer.parseInt(tokens[0]);
                tasks[i][1] = Integer.parseInt(tokens[1]);
                tasks[i][2] = i; // Store original index
            }

            String result = assignTasks(N, tasks);
            output.append(result).append("\n");
        }

        System.out.print(output);
    }

    private static String assignTasks(int n, int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));

        char[] schedule = new char[n];
        int cameronEnd = 0, jamieEnd = 0;

        for (int[] task : tasks) {
            int start = task[0], end = task[1], index = task[2];
            if (start >= cameronEnd) {
                schedule[index] = 'C';
                cameronEnd = end;
            } else if (start >= jamieEnd) {
                schedule[index] = 'J';
                jamieEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }
}