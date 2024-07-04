import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    public void run() {
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(i);
        }
    }

    private void solve(int test) {
        int N = in.nextInt();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Task t = new Task(in.nextInt(), in.nextInt(), 'C', i);
            tasks.add(t);
        }

        List<List<Task>> allTasks = new ArrayList<>();
        generateOptions(allTasks, tasks, 0);

        List<Task> validResult = null;
        for (List<Task> option : allTasks) {
            if (isValidOption(option)) {
                validResult = option;
                break;
            }
        }

        System.out.print("Case #" + test + ": ");
        if (validResult != null) {
            validResult.forEach(task -> System.out.print(task.person));
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private void generateOptions(List<List<Task>> allTasks, List<Task> current, int idx) {
        if (idx == current.size()) {
            allTasks.add(new ArrayList<>(current));
            return;
        }

        Task original = current.get(idx);

        Task optionC = new Task(original.start, original.end, 'C', original.idx);
        current.set(idx, optionC);
        generateOptions(allTasks, current, idx + 1);

        Task optionJ = new Task(original.start, original.end, 'J', original.idx);
        current.set(idx, optionJ);
        generateOptions(allTasks, current, idx + 1);

        current.set(idx, original);  // Restore original task
    }

    private boolean isValidOption(List<Task> tasks) {
        for (Task task : tasks) {
            if (!isTaskValid(tasks, task, task.person)) {
                return false;
            }
        }
        return true;
    }

    private boolean isTaskValid(List<Task> tasks, Task currentTask, char person) {
        for (Task task : tasks) {
            if (task.idx == currentTask.idx || task.person != person) {
                continue;
            }
            if (overlaps(currentTask, task)) {
                return false;
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
        int idx;

        Task(int start, int end, char person, int idx) {
            this.start = start;
            this.end = end;
            this.person = person;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return String.valueOf(person);
        }
    }
}