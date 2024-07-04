import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());
            for (int t = 1; t <= testCases; t++) {
                int n = Integer.parseInt(reader.readLine());
                Task[] tasks = new Task[n];
                for (int i = 0; i < n; i++) {
                    tasks[i] = new Task(reader.readLine(), i);
                }
                processTestCase(t, n, tasks);
            }
        }
    }

    private void processTestCase(int testCaseNumber, int taskCount, Task[] tasks) {
        Arrays.sort(tasks);
        int jEndTime = -1, cEndTime = -1;
        boolean isImpossible = false;
        char[] schedule = new char[taskCount];
        
        for (int i = 0; i < taskCount; i++) {
            if (jEndTime <= tasks[i].start) {
                schedule[tasks[i].index] = 'J';
                jEndTime = tasks[i].end;
            } else if (cEndTime <= tasks[i].start) {
                schedule[tasks[i].index] = 'C';
                cEndTime = tasks[i].end;
            } else {
                isImpossible = true;
                break;
            }
        }
        
        if (isImpossible) {
            System.out.printf("Case #%d: IMPOSSIBLE\n", testCaseNumber);
        } else {
            System.out.printf("Case #%d: %s\n", testCaseNumber, new String(schedule));
        }
    }

    private static class Task implements Comparable<Task> {
        final int start, end, index;

        Task(String input, int index) {
            StringTokenizer tokenizer = new StringTokenizer(input);
            this.start = Integer.parseInt(tokenizer.nextToken());
            this.end = Integer.parseInt(tokenizer.nextToken());
            this.index = index;
        }

        @Override
        public int compareTo(Task other) {
            int startComparison = Integer.compare(this.start, other.start);
            return startComparison != 0 ? startComparison : Integer.compare(this.end, other.end);
        }
    }
}