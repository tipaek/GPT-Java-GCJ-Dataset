import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        outer: for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            Task[] allTasks = new Task[n];

            for (int k = 0; k < n; k++) {
                int start = in.nextInt();
                int end = in.nextInt();

                allTasks[k] = new Task(k, start, end);
            }

            Arrays.sort(allTasks);

            int[] CTimeline = new int[1441];
            int[] JTimeline = new int[1441];

            for (Task task : allTasks) {
                if (CTimeline[task.start] > 0) {
                    if (JTimeline[task.start] > 0) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        continue outer;
                    } else {
                        assign(JTimeline, task.start, task.end, task.taskIndex);
                        task.assignee = "J";
                    }
                } else {
                    assign(CTimeline, task.start, task.end, task.taskIndex);
                    task.assignee = "C";
                }
            }

            StringBuilder answer = new StringBuilder();

            Arrays.sort(allTasks, new TaskIdexComparator());

            for (Task task : allTasks) {
                answer.append(task.assignee);
            }

            System.out.println("Case #" + i + ": " + answer.toString());
        }
    }

    static void assign(int[] timeline, int start, int end, int taskIndex) {
        for (int i = start; i <= end; i++) {
            timeline[i] = taskIndex;
        }
    }
}

class TaskIdexComparator implements Comparator<Task> {

    @Override
    public int compare(Task left, Task right) {
        return left.taskIndex - right.taskIndex;
    }

}

class Task implements Comparable<Task> {
    int taskIndex;
    int start;
    int end;
    String assignee;

    public Task(int taskIndex, int start, int end) {
        this.taskIndex = taskIndex + 1;
        this.start = start;
        this.end = end - 1;
    }

    @Override
    public int compareTo(Task o) {
        if (start == o.start) {
            return end - o.end;
        }
        return start - o.start;
    }

}