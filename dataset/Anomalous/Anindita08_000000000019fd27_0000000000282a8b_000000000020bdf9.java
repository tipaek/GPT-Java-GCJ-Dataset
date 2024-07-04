import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Task {
    int start, end, index;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());

        for (int t = 1; t <= testCases; t++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int numTasks = Integer.parseInt(tokenizer.nextToken());
            Task[] tasks = new Task[numTasks];

            for (int i = 0; i < numTasks; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                tasks[i] = new Task(start, end, i);
            }

            char[] result = new char[numTasks];
            Arrays.sort(tasks, new TaskComparator());

            int conflict = 0;
            int cEnd = tasks[0].end;
            int jEnd = 0;
            result[tasks[0].index] = 'C';

            for (int i = 1; i < numTasks; i++) {
                if (tasks[i].start < cEnd) {
                    if (tasks[i].start >= jEnd) {
                        jEnd = tasks[i].end;
                        result[tasks[i].index] = 'J';
                    } else {
                        conflict = 1;
                        break;
                    }
                } else {
                    cEnd = tasks[i].end;
                    result[tasks[i].index] = 'C';
                }
            }

            if (conflict == 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

    static class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task t1, Task t2) {
            if (t1.start != t2.start) {
                return Integer.compare(t1.start, t2.start);
            }
            return Integer.compare(t1.end, t2.end);
        }
    }
}