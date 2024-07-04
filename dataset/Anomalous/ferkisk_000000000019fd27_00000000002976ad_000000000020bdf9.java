import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private final Scanner in = new Scanner(System.in);

    private void run() {
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

        boolean isPossible = assignTasks(tasks, 0);

        System.out.print("Case #" + test + ": ");
        if (isPossible) {
            for (Task task : tasks) {
                System.out.print(task.person);
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private boolean assignTasks(Task[] tasks, int fromIdx) {
        if (fromIdx >= tasks.length) {
            return true;
        }

        for (int i = fromIdx; i < tasks.length; i++) {
            if (canAssign(tasks, i, 'C')) {
                tasks[i].person = 'C';
                if (assignTasks(tasks, fromIdx + 1)) {
                    return true;
                }
                tasks[i].person = '\0';
            }
            if (canAssign(tasks, i, 'J')) {
                tasks[i].person = 'J';
                if (assignTasks(tasks, fromIdx + 1)) {
                    return true;
                }
                tasks[i].person = '\0';
            }
        }
        return false;
    }

    private boolean canAssign(Task[] tasks, int taskIdx, char person) {
        Task task = tasks[taskIdx];

        for (int i = 0; i < tasks.length; i++) {
            if (i == taskIdx) continue;

            Task otherTask = tasks[i];
            if (otherTask.person == person) {
                if (task.start < otherTask.end && task.end > otherTask.start) {
                    return false;
                }
            }
        }
        return true;
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