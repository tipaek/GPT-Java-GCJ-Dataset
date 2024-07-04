import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    private void run() {
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(i);
        }
    }

    private void solve(int test) {
        int N = in.nextInt();
        Task[] tasks = new Task[N];

        for (int i = 0; i < N; i++) {
            tasks[i] = new Task(in.nextInt(), in.nextInt());
        }

        tasks = assignTasks(tasks, 0);

        System.out.print("Case #" + test + ": ");
        if (tasks != null) {
            for (Task task : tasks) {
                System.out.print(task.person);
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private Task[] assignTasks(Task[] tasks, int fromIdx) {
        if (fromIdx >= tasks.length) {
            return tasks;
        }

        for (int i = fromIdx; i < tasks.length; i++) {
            if (canAssign(tasks, i, 'C')) {
                tasks[i].person = 'C';
            } else if (canAssign(tasks, i, 'J')) {
                tasks[i].person = 'J';
            } else {
                if (i > 0) {
                    char prevPerson = tasks[i - 1].person;
                    if (prevPerson == 'C' && canAssign(tasks, i - 1, 'J')) {
                        tasks[i - 1].person = 'J';
                        return assignTasks(tasks, i);
                    } else if (prevPerson == 'J' && canAssign(tasks, i - 1, 'C')) {
                        tasks[i - 1].person = 'C';
                        return assignTasks(tasks, i);
                    }
                }
                return null;
            }
        }
        return tasks;
    }

    private boolean canAssign(Task[] tasks, int taskIdx, char person) {
        Task currentTask = tasks[taskIdx];

        for (int i = 0; i < tasks.length; i++) {
            if (i == taskIdx) continue;

            Task otherTask = tasks[i];
            if (otherTask.person == person) {
                if (overlaps(currentTask, otherTask)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean overlaps(Task t1, Task t2) {
        return (t1.start < t2.end && t1.end > t2.start);
    }

    private static class Task {
        int start;
        int end;
        char person;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}