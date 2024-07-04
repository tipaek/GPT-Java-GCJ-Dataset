import java.util.*;
import java.io.*;

public class Solution {

    static class Task {
        int start, end, index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class TaskSeq {
        int index;
        char name;

        TaskSeq(int index, char name) {
            this.index = index;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int taskCount = in.nextInt();
            PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparingInt((Task t1) -> t1.start).thenComparingInt(t1 -> t1.end));
            
            for (int j = 0; j < taskCount; j++) {
                tasks.add(new Task(in.nextInt(), in.nextInt(), j));
            }

            int cEnd = 0, jEnd = 0;
            PriorityQueue<TaskSeq> resultTasks = new PriorityQueue<>(Comparator.comparingInt(t -> t.index));
            boolean possible = true;

            while (!tasks.isEmpty()) {
                Task task = tasks.poll();
                if (task.start >= cEnd) {
                    cEnd = task.end;
                    resultTasks.add(new TaskSeq(task.index, 'C'));
                } else if (task.start >= jEnd) {
                    jEnd = task.end;
                    resultTasks.add(new TaskSeq(task.index, 'J'));
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            while (!resultTasks.isEmpty()) {
                result.append(resultTasks.poll().name);
            }

            System.out.println("Case #" + (i + 1) + ": " + (possible ? result.toString() : "IMPOSSIBLE"));
        }
    }
}