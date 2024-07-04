import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks, new TaskComparator());

            char[] result = new char[n];
            int cEndTime = 0, jEndTime = 0;
            boolean impossible = false;

            for (Task task : tasks) {
                if (cEndTime <= task.start) {
                    result[task.index] = 'C';
                    cEndTime = task.end;
                } else if (jEndTime <= task.start) {
                    result[task.index] = 'J';
                    jEndTime = task.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (char ch : result) {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
    }
}

class Task {
    int start, end, index;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        if (t1.start != t2.start) {
            return Integer.compare(t1.start, t2.start);
        } else {
            return Integer.compare(t1.end, t2.end);
        }
    }
}