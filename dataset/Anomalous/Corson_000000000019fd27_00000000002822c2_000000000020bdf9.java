import java.util.*;
import java.io.*;

class Task {
    int start;
    int end;
    char person;
    int order;

    Task(int start, int end, int order) {
        this.start = start;
        this.end = end;
        this.order = order;
    }
}

class TaskStartComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        if (t1.start != t2.start) {
            return Integer.compare(t1.start, t2.start);
        } else {
            return Integer.compare(t1.end, t2.end);
        }
    }
}

class TaskOrderComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return Integer.compare(t1.order, t2.order);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end, i));
            }

            tasks.sort(new TaskStartComparator());

            int maxEndJ = 0;
            int maxEndC = 0;
            boolean isImpossible = false;

            for (Task task : tasks) {
                if (task.start >= maxEndJ) {
                    maxEndJ = task.end;
                    task.person = 'J';
                } else if (task.start >= maxEndC) {
                    maxEndC = task.end;
                    task.person = 'C';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                tasks.sort(new TaskOrderComparator());
                StringBuilder output = new StringBuilder();
                for (Task task : tasks) {
                    output.append(task.person);
                }
                System.out.println("Case #" + (t + 1) + ": " + output);
            }
        }
    }
}